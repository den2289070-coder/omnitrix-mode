package com.omnitrix.mod;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/** Невидимый эффект: амплификатор = номер пришельца. Эффекты сами синхронизируются с клиентом. */
public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, OmnitrixMod.MODID);
    public static final RegistryObject<MobEffect> FORM = EFFECTS.register("alien_form", FormEffect::new);

    public static class FormEffect extends MobEffect {
        public FormEffect() { super(MobEffectCategory.NEUTRAL, 0x6CFF00); }
    }
}
