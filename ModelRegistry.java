package com.omnitrix.mod.client;

import com.omnitrix.mod.Alien;
import com.omnitrix.mod.OmnitrixMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OmnitrixMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModelRegistry {
    public static ModelLayerLocation layer(Alien a) {
        return new ModelLayerLocation(new ResourceLocation(OmnitrixMod.MODID, a.key()), "main");
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions e) {
        for (Alien a : Alien.values()) {
            final int i = a.ordinal();
            e.registerLayerDefinition(layer(a), () -> AlienModelData.create(i));
        }
    }
}
