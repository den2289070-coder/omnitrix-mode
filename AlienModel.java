package com.omnitrix.mod.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

/** Универсальная модель пришельца: части ищутся по именам, отсутствующие просто пропускаются. */
public class AlienModel extends EntityModel<Player> {
    private final ModelPart root;
    private final ModelPart head, rArm, lArm, rArm2, lArm2, rLeg, lLeg, tail;
    private final List<ModelPart> rWings = new ArrayList<>(), lWings = new ArrayList<>();

    public AlienModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.root = root;
        head = opt("head"); rArm = opt("right_arm"); lArm = opt("left_arm");
        rArm2 = opt("right_arm2"); lArm2 = opt("left_arm2");
        rLeg = opt("right_leg"); lLeg = opt("left_leg"); tail = opt("tail");
        for (String n : new String[]{"right_wing", "right_wing2"}) if (root.hasChild(n)) rWings.add(root.getChild(n));
        for (String n : new String[]{"left_wing", "left_wing2"}) if (root.hasChild(n)) lWings.add(root.getChild(n));
    }

    private ModelPart opt(String n) { return root.hasChild(n) ? root.getChild(n) : null; }

    @Override
    public void setupAnim(Player p, float ls, float lsa, float age, float yaw, float pitch) {
        root.getAllParts().forEach(ModelPart::resetPose);
        if (head != null) { head.yRot += yaw * Mth.DEG_TO_RAD; head.xRot += pitch * Mth.DEG_TO_RAD; }

        float swing = Mth.cos(ls * 0.6662F) * lsa;
        float idle = Mth.cos(age * 0.09F) * 0.05F + 0.05F;
        float hit = attackTime > 0 ? Mth.sin(attackTime * Mth.PI) * 1.6F : 0F;

        if (rArm != null) { rArm.xRot += -swing - hit; rArm.zRot += idle; }
        if (lArm != null) { lArm.xRot += swing; lArm.zRot -= idle; }
        if (rArm2 != null) { rArm2.xRot += -swing - hit * 0.8F; rArm2.zRot += idle; }
        if (lArm2 != null) { lArm2.xRot += swing; lArm2.zRot -= idle; }
        if (rLeg != null) rLeg.xRot += swing * 1.4F;
        if (lLeg != null) lLeg.xRot -= swing * 1.4F;

        float flap = Mth.sin(age * 1.3F) * 0.55F;
        for (ModelPart w : rWings) w.zRot += flap;
        for (ModelPart w : lWings) w.zRot -= flap;
        if (tail != null) tail.yRot += Mth.sin(age * 0.1F + ls * 0.5F) * 0.25F;
    }

    @Override
    public void renderToBuffer(PoseStack ps, VertexConsumer vc, int light, int overlay, float r, float g, float b, float a) {
        root.render(ps, vc, light, overlay, r, g, b, a);
    }
}
