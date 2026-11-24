package com.omnitrix.mod;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = OmnitrixMod.MODID)
public class OmnitrixHandler {
    private static final UUID ID_HP = UUID.fromString("a1d2c3e4-0001-4000-8000-0000000a1001");
    private static final UUID ID_DMG = UUID.fromString("a1d2c3e4-0002-4000-8000-0000000a1002");
    private static final UUID ID_SPD = UUID.fromString("a1d2c3e4-0003-4000-8000-0000000a1003");
    private static final UUID ID_ARM = UUID.fromString("a1d2c3e4-0004-4000-8000-0000000a1004");
    private static final UUID ID_KB = UUID.fromString("a1d2c3e4-0005-4000-8000-0000000a1005");

    /** -1 = человек, иначе индекс пришельца */
    public static int getForm(Player p) {
        MobEffectInstance i = p.getEffect(ModEffects.FORM.get());
        if (i == null) return -1;
        return Math.min(i.getAmplifier(), Alien.values().length - 1);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (e.phase != TickEvent.Phase.END) return;
        Player p = e.player;
        int form = getForm(p);
        CompoundTag data = p.getPersistentData();
        int last = data.getInt("omni_last") - 1;

        if (form != last) {
            data.putInt("omni_last", form + 1);
            p.refreshDimensions();
            if (p instanceof ServerPlayer sp) onFormChange(sp, last, form);
        }
        if (form >= 0 && p instanceof ServerPlayer sp && sp.tickCount % 20 == 0) passives(sp, Alien.values()[form]);
    }

    private static void onFormChange(ServerPlayer p, int last, int form) {
        float ratio = p.getHealth() / p.getMaxHealth();
        for (Attribute a : new Attribute[]{Attributes.MAX_HEALTH, Attributes.ATTACK_DAMAGE, Attributes.MOVEMENT_SPEED, Attributes.ARMOR, Attributes.KNOCKBACK_RESISTANCE}) {
            AttributeInstance inst = p.getAttribute(a);
            if (inst == null) continue;
            inst.removeModifier(ID_HP); inst.removeModifier(ID_DMG); inst.removeModifier(ID_SPD); inst.removeModifier(ID_ARM); inst.removeModifier(ID_KB);
        }
        if (form >= 0) {
            Alien a = Alien.values()[form];
            add(p, Attributes.MAX_HEALTH, ID_HP, a.health, Operation.ADDITION);
            add(p, Attributes.ATTACK_DAMAGE, ID_DMG, a.damage, Operation.ADDITION);
            add(p, Attributes.MOVEMENT_SPEED, ID_SPD, a.speed, Operation.MULTIPLY_BASE);
            add(p, Attributes.ARMOR, ID_ARM, a.armor, Operation.ADDITION);
            add(p, Attributes.KNOCKBACK_RESISTANCE, ID_KB, a.knockback, Operation.ADDITION);
        }
        if (p.isAlive()) p.setHealth(Math.max(1f, Math.min(ratio * p.getMaxHealth(), p.getMaxHealth())));

        // полёт Вонючки
        int stink = Alien.STINKFLY.ordinal();
        if (form == stink) {
            p.getAbilities().mayfly = true;
            p.onUpdateAbilities();
        } else if (last == stink && !p.isCreative() && !p.isSpectator()) {
            p.getAbilities().mayfly = false;
            p.getAbilities().flying = false;
            p.onUpdateAbilities();
        }

        // возврат в человека -> перезарядка Омнитрикса
        if (form < 0 && last >= 0) {
            p.getCooldowns().addCooldown(ModItems.OMNITRIX.get(), OmnitrixItem.RECHARGE);
            p.level().playSound(null, p.blockPosition(), SoundEvents.BEACON_DEACTIVATE, SoundSource.PLAYERS, 1f, 1.4f);
        }
    }

    private static void add(ServerPlayer p, Attribute attr, UUID id, double v, Operation op) {
        AttributeInstance inst = p.getAttribute(attr);
        if (inst != null && v != 0) inst.addTransientModifier(new AttributeModifier(id, "omnitrix", v, op));
    }

    private static void eff(ServerPlayer p, MobEffect e, int amp) {
        p.addEffect(new MobEffectInstance(e, 330, amp, true, false, false));
    }

    private static void passives(ServerPlayer p, Alien a) {
        switch (a) {
            case HEATBLAST -> eff(p, MobEffects.FIRE_RESISTANCE, 0);
            case WILDMUTT -> { eff(p, MobEffects.NIGHT_VISION, 0); eff(p, MobEffects.JUMP, 1); }
            case DIAMONDHEAD -> eff(p, MobEffects.FIRE_RESISTANCE, 0);
            case XLR8 -> eff(p, MobEffects.JUMP, 1);
            case GREY_MATTER -> { eff(p, MobEffects.DIG_SPEED, 2); eff(p, MobEffects.SLOW_FALLING, 0); eff(p, MobEffects.JUMP, 2); }
            case FOUR_ARMS -> { eff(p, MobEffects.DIG_SPEED, 1); eff(p, MobEffects.JUMP, 1); }
            case STINKFLY -> {
                eff(p, MobEffects.SLOW_FALLING, 0);
                if (!p.getAbilities().mayfly) { p.getAbilities().mayfly = true; p.onUpdateAbilities(); }
            }
            case RIPJAWS -> {
                eff(p, MobEffects.WATER_BREATHING, 0);
                if (p.isInWater()) { eff(p, MobEffects.DOLPHINS_GRACE, 0); eff(p, MobEffects.NIGHT_VISION, 0); eff(p, MobEffects.DAMAGE_BOOST, 0); }
            }
            case UPGRADE -> eff(p, MobEffects.DIG_SPEED, 2);
            case GHOSTFREAK -> { eff(p, MobEffects.SLOW_FALLING, 0); eff(p, MobEffects.NIGHT_VISION, 0); }
        }
    }

    /** Меняем размер хитбокса игрока (и на сервере, и на клиенте). */
    @SubscribeEvent
    public static void onSize(EntityEvent.Size e) {
        if (!(e.getEntity() instanceof Player p)) return;
        try {
            int f = getForm(p);
            if (f >= 0) e.setNewSize(e.getNewSize().scale(Alien.values()[f].scale), true);
        } catch (NullPointerException ignored) { /* игрок ещё создаётся */ }
    }
}
