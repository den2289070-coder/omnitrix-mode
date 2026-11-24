package com.omnitrix.mod;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OmnitrixMod.MODID)
public class OmnitrixMod {
    public static final String MODID = "omnitrix";

    public OmnitrixMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModEffects.EFFECTS.register(bus);
        bus.addListener(this::addToTab);
    }

    private void addToTab(BuildCreativeModeTabContentsEvent e) {
        if (e.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) e.accept(ModItems.OMNITRIX);
    }
}
