package com.omnitrix.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OmnitrixMod.MODID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void hud(RenderGuiOverlayEvent.Post e) {
        if (e.getOverlay() != VanillaGuiOverlay.HOTBAR.type()) return;
        Minecraft mc = Minecraft.getInstance();
        Player p = mc.player;
        if (p == null || mc.options.hideGui) return;

        int y = 6;
        ItemStack held = p.getMainHandItem().getItem() == ModItems.OMNITRIX.get() ? p.getMainHandItem()
                : p.getOffhandItem().getItem() == ModItems.OMNITRIX.get() ? p.getOffhandItem() : ItemStack.EMPTY;
        if (!held.isEmpty()) {
            Alien a = Alien.values()[OmnitrixItem.selected(held)];
            e.getGuiGraphics().drawString(mc.font,
                    Component.translatable("hud.omnitrix.selected", Component.translatable(a.nameKey())), 6, y, 0x6CFF00, true);
            y += 11;
        }
        int f = OmnitrixHandler.getForm(p);
        if (f >= 0) {
            MobEffectInstance inst = p.getEffect(ModEffects.FORM.get());
            int sec = inst == null ? 0 : inst.getDuration() / 20;
            e.getGuiGraphics().drawString(mc.font,
                    Component.translatable("hud.omnitrix.form", Component.translatable(Alien.values()[f].nameKey()), sec), 6, y, 0xFFFFFF, true);
        }
    }
}
