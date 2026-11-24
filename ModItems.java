package com.omnitrix.mod;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OmnitrixMod.MODID);
    public static final RegistryObject<Item> OMNITRIX = ITEMS.register("omnitrix",
            () -> new OmnitrixItem(new Item.Properties().stacksTo(1).fireResistant()));
}
