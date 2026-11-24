// АВТОГЕНЕРАЦИЯ: tools/gen_models.py — не править руками
package com.omnitrix.mod.client;

import net.minecraft.client.model.geom.builders.*;

public class AlienModelData {
    public static LayerDefinition heatblast() {
        MeshDefinition m = new MeshDefinition();
        PartDefinition r = m.getRoot();
        r.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F).texOffs(32, 0).addBox(-3.0F, -13.0F, -3.0F, 6.0F, 5.0F, 6.0F).texOffs(56, 0).addBox(-2.0F, -17.0F, -2.0F, 4.0F, 4.0F, 4.0F).texOffs(72, 0).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 3.0F, 2.0F).texOffs(80, 0).addBox(-6.0F, -10.0F, -1.0F, 2.0F, 4.0F, 2.0F).texOffs(88, 0).addBox(4.0F, -10.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("body", CubeListBuilder.create().texOffs(96, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(16, 16).addBox(-3.5F, 6.0F, -2.5F, 5.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(36, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(52, 16).addBox(-1.5F, 6.0F, -2.5F, 5.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(72, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(88, 16).addBox(-2.5F, 9.0F, -2.5F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(108, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 32).addBox(-2.5F, 9.0F, -2.5F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(m, 128, 128);
    }

    public static LayerDefinition wildmutt() {
        MeshDefinition m = new MeshDefinition();
        PartDefinition r = m.getRoot();
        r.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 7.0F).texOffs(30, 0).addBox(-2.0F, -3.0F, -8.0F, 4.0F, 3.0F, 4.0F).texOffs(46, 0).addBox(-5.0F, -10.0F, 0.0F, 3.0F, 3.0F, 2.0F).texOffs(56, 0).addBox(2.0F, -10.0F, 0.0F, 3.0F, 3.0F, 2.0F).texOffs(66, 0).addBox(-5.0F, -8.0F, 2.0F, 10.0F, 9.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("body", CubeListBuilder.create().texOffs(96, 0).addBox(-5.0F, 0.0F, -3.0F, 10.0F, 12.0F, 6.0F).texOffs(0, 18).addBox(-1.0F, -2.0F, 3.0F, 2.0F, 3.0F, 3.0F).texOffs(10, 18).addBox(-1.0F, 4.0F, 3.0F, 2.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(20, 18).addBox(-4.0F, -2.0F, -2.5F, 5.0F, 15.0F, 5.0F).texOffs(40, 18).addBox(-4.5F, 9.0F, -3.0F, 6.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-6.0F, 3.0F, -3.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(64, 18).addBox(-1.0F, -2.0F, -2.5F, 5.0F, 15.0F, 5.0F).texOffs(84, 18).addBox(-1.5F, 9.0F, -3.0F, 6.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(6.0F, 3.0F, -3.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(108, 18).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F).texOffs(0, 38).addBox(-3.0F, 9.0F, -3.5F, 6.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-2.4F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(24, 38).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F).texOffs(44, 38).addBox(-3.0F, 9.0F, -3.5F, 6.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(2.4F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(m, 128, 128);
    }

    public static LayerDefinition diamondhead() {
        MeshDefinition m = new MeshDefinition();
        PartDefinition r = m.getRoot();
        r.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F).texOffs(32, 0).addBox(-1.0F, -13.0F, -1.0F, 2.0F, 5.0F, 2.0F).texOffs(40, 0).addBox(-5.0F, -11.0F, -1.0F, 2.0F, 5.0F, 2.0F).texOffs(48, 0).addBox(3.0F, -11.0F, -1.0F, 2.0F, 5.0F, 2.0F).texOffs(56, 0).addBox(-1.0F, -11.0F, 2.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("body", CubeListBuilder.create().texOffs(64, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(88, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(104, 0).addBox(-3.5F, 6.0F, -2.5F, 5.0F, 4.0F, 5.0F).texOffs(0, 16).addBox(-4.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(8, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(24, 16).addBox(-1.5F, 6.0F, -2.5F, 5.0F, 4.0F, 5.0F).texOffs(44, 16).addBox(2.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(52, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(68, 16).addBox(-2.5F, 9.0F, -3.0F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(88, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(104, 16).addBox(-2.5F, 9.0F, -3.0F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(m, 128, 128);
    }

    public static LayerDefinition xlr8() {
        MeshDefinition m = new MeshDefinition();
        PartDefinition r = m.getRoot();
        r.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F).texOffs(32, 0).addBox(-3.0F, -7.0F, 4.0F, 6.0F, 5.0F, 10.0F).texOffs(64, 0).addBox(-1.0F, -9.0F, 3.0F, 2.0F, 1.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("body", CubeListBuilder.create().texOffs(86, 0).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(106, 0).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 12.0F, 3.0F).texOffs(0, 16).addBox(-2.5F, 7.0F, -2.0F, 4.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(-4.5F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(16, 16).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 12.0F, 3.0F).texOffs(28, 16).addBox(-1.5F, 7.0F, -2.0F, 4.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(4.5F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(44, 16).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F).texOffs(56, 16).addBox(-2.0F, 10.0F, -4.0F, 3.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-1.8F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(76, 16).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F).texOffs(88, 16).addBox(-1.0F, 10.0F, -4.0F, 3.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(1.8F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 31).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(m, 128, 128);
    }

    public static LayerDefinition grey_matter() {
        MeshDefinition m = new MeshDefinition();
        PartDefinition r = m.getRoot();
        r.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -10.0F, -5.0F, 12.0F, 10.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("body", CubeListBuilder.create().texOffs(44, 0).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(64, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 2.0F).texOffs(72, 0).addBox(-1.5F, 4.0F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-3.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(84, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 2.0F).texOffs(92, 0).addBox(-1.5F, 4.0F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(3.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(104, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F).texOffs(112, 0).addBox(-2.0F, 9.0F, -3.0F, 4.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-1.5F, 9.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F).texOffs(8, 20).addBox(-2.0F, 9.0F, -3.0F, 4.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(1.5F, 9.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(m, 128, 128);
    }

    public static LayerDefinition four_arms() {
        MeshDefinition m = new MeshDefinition();
        PartDefinition r = m.getRoot();
        r.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 7.0F, 6.0F).texOffs(24, 0).addBox(-4.0F, -10.0F, -2.0F, 2.0F, 3.0F, 2.0F).texOffs(32, 0).addBox(2.0F, -10.0F, -2.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("body", CubeListBuilder.create().texOffs(40, 0).addBox(-6.0F, 0.0F, -3.0F, 12.0F, 13.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(76, 0).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 13.0F, 4.0F).texOffs(94, 0).addBox(-4.5F, 7.0F, -2.5F, 6.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(-6.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -2.0F, -2.0F, 5.0F, 13.0F, 4.0F).texOffs(18, 19).addBox(-1.5F, 7.0F, -2.5F, 6.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(6.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_arm2", CubeListBuilder.create().texOffs(40, 19).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 13.0F, 4.0F).texOffs(58, 19).addBox(-4.5F, 7.0F, -2.5F, 6.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(-6.5F, 6.0F, 1.5F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_arm2", CubeListBuilder.create().texOffs(80, 19).addBox(-1.0F, -2.0F, -2.0F, 5.0F, 13.0F, 4.0F).texOffs(98, 19).addBox(-1.5F, 7.0F, -2.5F, 6.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(6.5F, 6.0F, 1.5F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 36).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 11.0F, 5.0F).texOffs(20, 36).addBox(-3.5F, 0.0F, -3.5F, 6.0F, 6.0F, 6.0F).texOffs(44, 36).addBox(-3.0F, 9.0F, -3.5F, 6.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(-2.5F, 13.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(68, 36).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 11.0F, 5.0F).texOffs(88, 36).addBox(-2.5F, 0.0F, -3.5F, 6.0F, 6.0F, 6.0F).texOffs(0, 52).addBox(-3.0F, 9.0F, -3.5F, 6.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(2.5F, 13.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(m, 128, 128);
    }

    public static LayerDefinition stinkfly() {
        MeshDefinition m = new MeshDefinition();
        PartDefinition r = m.getRoot();
        r.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F).texOffs(24, 0).addBox(-6.0F, -7.0F, -4.0F, 3.0F, 5.0F, 5.0F).texOffs(40, 0).addBox(3.0F, -7.0F, -4.0F, 3.0F, 5.0F, 5.0F).texOffs(56, 0).addBox(-2.0F, -11.0F, -1.0F, 1.0F, 4.0F, 1.0F).texOffs(60, 0).addBox(1.0F, -11.0F, -1.0F, 1.0F, 4.0F, 1.0F).texOffs(64, 0).addBox(-1.0F, -3.0F, -6.0F, 2.0F, 3.0F, 3.0F).texOffs(74, 0).addBox(-2.0F, -2.0F, -5.0F, 1.0F, 2.0F, 2.0F).texOffs(80, 0).addBox(1.0F, -2.0F, -5.0F, 1.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("body", CubeListBuilder.create().texOffs(86, 0).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(106, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F).texOffs(114, 0).addBox(-1.5F, 7.0F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-4.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F).texOffs(8, 16).addBox(-1.5F, 7.0F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(4.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(20, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(-1.5F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(28, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(1.5F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(36, 16).addBox(-14.0F, 0.0F, 0.0F, 14.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(-2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(76, 16).addBox(0.0F, 0.0F, 0.0F, 14.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(m, 128, 128);
    }

    public static LayerDefinition ripjaws() {
        MeshDefinition m = new MeshDefinition();
        PartDefinition r = m.getRoot();
        r.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F).texOffs(32, 0).addBox(-4.0F, -1.0F, -6.0F, 8.0F, 3.0F, 4.0F).texOffs(56, 0).addBox(-1.0F, -12.0F, -3.0F, 2.0F, 5.0F, 8.0F).texOffs(76, 0).addBox(-6.0F, -6.0F, -1.0F, 2.0F, 3.0F, 3.0F).texOffs(86, 0).addBox(4.0F, -6.0F, -1.0F, 2.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("body", CubeListBuilder.create().texOffs(96, 0).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 12.0F, 4.0F).texOffs(0, 16).addBox(-1.0F, 1.0F, 2.0F, 2.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(12, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(28, 16).addBox(-3.5F, 6.0F, -2.5F, 5.0F, 4.0F, 5.0F).texOffs(48, 16).addBox(-4.0F, 3.0F, -1.0F, 1.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-6.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(56, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(72, 16).addBox(-1.5F, 6.0F, -2.5F, 5.0F, 4.0F, 5.0F).texOffs(92, 16).addBox(3.0F, 3.0F, -1.0F, 1.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(6.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(100, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 32).addBox(-3.0F, 10.0F, -5.0F, 6.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-2.5F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(18, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(34, 32).addBox(-3.0F, 10.0F, -5.0F, 6.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(2.5F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(52, 32).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 2.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(m, 128, 128);
    }

    public static LayerDefinition upgrade() {
        MeshDefinition m = new MeshDefinition();
        PartDefinition r = m.getRoot();
        r.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(56, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(72, 0).addBox(-3.5F, 6.0F, -2.5F, 5.0F, 4.0F, 5.0F).texOffs(92, 0).addBox(-4.0F, -3.0F, -3.0F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(112, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 16).addBox(-1.5F, 6.0F, -2.5F, 5.0F, 4.0F, 5.0F).texOffs(20, 16).addBox(-1.0F, -3.0F, -3.0F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(56, 16).addBox(-2.5F, 9.0F, -2.5F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(76, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(92, 16).addBox(-2.5F, 9.0F, -2.5F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(m, 128, 128);
    }

    public static LayerDefinition ghostfreak() {
        MeshDefinition m = new MeshDefinition();
        PartDefinition r = m.getRoot();
        r.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F).texOffs(56, 0).addBox(-5.0F, -1.0F, 2.0F, 10.0F, 17.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(78, 0).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 12.0F, 3.0F).texOffs(90, 0).addBox(-2.5F, 6.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-4.5F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(106, 0).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 12.0F, 3.0F).texOffs(0, 18).addBox(-1.5F, 6.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(4.5F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(16, 18).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F).texOffs(32, 18).addBox(-1.0F, 6.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 18).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F).texOffs(56, 18).addBox(-1.0F, 6.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(2.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        r.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(64, 18).addBox(-3.0F, 0.0F, 0.0F, 2.0F, 12.0F, 2.0F).texOffs(72, 18).addBox(1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 2.0F).texOffs(80, 18).addBox(-1.0F, 0.0F, 1.0F, 2.0F, 14.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(m, 128, 128);
    }

    public static final float[] FEET = {24.0F, 24.0F, 24.0F, 24.0F, 19.0F, 24.0F, 24.0F, 24.0F, 24.0F, 24.0F};

    public static LayerDefinition create(int i) {
        return switch (i) {
            case 0 -> heatblast();
            case 1 -> wildmutt();
            case 2 -> diamondhead();
            case 3 -> xlr8();
            case 4 -> grey_matter();
            case 5 -> four_arms();
            case 6 -> stinkfly();
            case 7 -> ripjaws();
            case 8 -> upgrade();
            case 9 -> ghostfreak();
            default -> heatblast();
        };
    }
}
