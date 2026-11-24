package com.omnitrix.mod.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.omnitrix.mod.Alien;
import com.omnitrix.mod.OmnitrixHandler;
import com.omnitrix.mod.OmnitrixMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/** Заменяет рендер игрока на модель пришельца, пока активна форма. */
@Mod.EventBusSubscriber(modid = OmnitrixMod.MODID, value = Dist.CLIENT)
public class AlienRenderer {
    private static final AlienModel[] MODELS = new AlienModel[Alien.values().length];

    private static AlienModel model(int i) {
        if (MODELS[i] == null)
            MODELS[i] = new AlienModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModelRegistry.layer(Alien.values()[i])));
        return MODELS[i];
    }

    @SubscribeEvent
    public static void onRender(RenderPlayerEvent.Pre e) {
        Player p = e.getEntity();
        int f = OmnitrixHandler.getForm(p);
        if (f < 0) return;
        e.setCanceled(true);
        if (p.isInvisible()) return;

        Alien a = Alien.values()[f];
        AlienModel m = model(f);
        float pt = e.getPartialTick();
        PoseStack ps = e.getPoseStack();

        float bodyYaw = Mth.rotLerp(pt, p.yBodyRotO, p.yBodyRot);
        float headYaw = Mth.rotLerp(pt, p.yHeadRotO, p.yHeadRot) - bodyYaw;
        float pitch = Mth.lerp(pt, p.xRotO, p.getXRot());
        float limbAmt = Math.min(1f, p.walkAnimation.speed(pt));
        float limbPos = p.walkAnimation.position(pt);
        float age = p.tickCount + pt;

        ps.pushPose();
        ps.mulPose(Axis.YP.rotationDegrees(180f - bodyYaw));
        float hover = a == Alien.GHOSTFREAK ? 0.12f + Mth.sin(age * 0.1f) * 0.05f : 0f;
        ps.translate(0, hover, 0);
        float s = a.scale * 0.9375f;
        ps.scale(-s, -s, s);
        ps.translate(0, -(AlienModelData.FEET[f] / 16f + 0.001f), 0);

        m.attackTime = p.getAttackAnim(pt);
        m.setupAnim(p, limbPos, limbAmt, age, headYaw, pitch);

        ResourceLocation tex = new ResourceLocation(OmnitrixMod.MODID, "textures/entity/" + a.key() + ".png");
        VertexConsumer vc = e.getMultiBufferSource().getBuffer(m.renderType(tex));
        m.renderToBuffer(ps, vc, e.getPackedLight(), LivingEntityRenderer.getOverlayCoords(p, 0f), 1f, 1f, 1f, 1f);
        ps.popPose();
    }
}
