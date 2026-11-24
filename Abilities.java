package com.omnitrix.mod;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class Abilities {

    public static void use(ServerPlayer p, Alien a) {
        long now = p.level().getGameTime();
        long ready = p.getPersistentData().getLong("omni_ready");
        if (now < ready) {
            p.displayClientMessage(Component.translatable("msg.omnitrix.cooldown", (ready - now + 19) / 20), true);
            return;
        }
        Vec3 look = p.getLookAngle();
        switch (a) {
            case HEATBLAST -> {
                for (int i = -1; i <= 1; i++) {
                    Vec3 d = look.yRot(i * 0.15f);
                    SmallFireball f = new SmallFireball(p.level(), p, d.x, d.y, d.z);
                    f.setPos(p.getX() + d.x, p.getEyeY() - 0.2, p.getZ() + d.z);
                    p.level().addFreshEntity(f);
                }
                sound(p, SoundEvents.BLAZE_SHOOT);
            }
            case WILDMUTT -> {
                p.setDeltaMovement(look.x * 1.3, 0.35, look.z * 1.3);
                p.hurtMarked = true;
                for (LivingEntity e : cone(p, 5, 0.5)) {
                    e.hurt(p.damageSources().playerAttack(p), 9f);
                    e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
                }
                sound(p, SoundEvents.WOLF_GROWL);
            }
            case DIAMONDHEAD -> {
                for (int i = -2; i <= 2; i++) {
                    Arrow ar = new Arrow(p.level(), p);
                    ar.shootFromRotation(p, p.getXRot(), p.getYRot() + i * 5f, 0f, 3.2f, 1f);
                    ar.setBaseDamage(5);
                    ar.setCritArrow(true);
                    ar.pickup = AbstractArrow.Pickup.DISALLOWED;
                    p.level().addFreshEntity(ar);
                }
                sound(p, SoundEvents.AMETHYST_BLOCK_BREAK);
            }
            case XLR8 -> {
                p.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 4));
                p.setDeltaMovement(look.x * 1.5, 0.1, look.z * 1.5);
                p.hurtMarked = true;
                fx(p, ParticleTypes.CLOUD, 30, 0.4);
                sound(p, SoundEvents.FIREWORK_ROCKET_LAUNCH);
            }
            case GREY_MATTER -> {
                p.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0, false, false));
                p.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
                fx(p, ParticleTypes.POOF, 15, 0.2);
            }
            case FOUR_ARMS -> {
                for (LivingEntity e : around(p, 6)) {
                    e.hurt(p.damageSources().playerAttack(p), 10f);
                    Vec3 v = e.position().subtract(p.position()).normalize();
                    e.setDeltaMovement(v.x * 1.2, 0.7, v.z * 1.2);
                    e.hurtMarked = true;
                }
                fx(p, ParticleTypes.EXPLOSION, 8, 2.5);
                sound(p, SoundEvents.GENERIC_EXPLODE);
            }
            case STINKFLY -> {
                for (LivingEntity e : cone(p, 8, 0.8)) {
                    e.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1));
                    e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
                    e.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 0));
                }
                trail(p, ParticleTypes.ITEM_SLIME, 8);
                sound(p, SoundEvents.SLIME_SQUISH);
            }
            case RIPJAWS -> {
                for (LivingEntity e : cone(p, 9, 0.85)) {
                    e.hurt(p.damageSources().playerAttack(p), 5f);
                    e.setDeltaMovement(look.x * 1.5, 0.25, look.z * 1.5);
                    e.hurtMarked = true;
                    e.clearFire();
                }
                p.clearFire();
                p.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 100, 0));
                trail(p, ParticleTypes.SPLASH, 9);
                sound(p, SoundEvents.PLAYER_SPLASH_HIGH_SPEED);
            }
            case UPGRADE -> {
                for (LivingEntity e : around(p, 12)) {
                    e.hurt(p.damageSources().playerAttack(p), 4f);
                    e.addEffect(new MobEffectInstance(MobEffects.GLOWING, 300, 0));
                    e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2));
                }
                p.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 1));
                p.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
                fx(p, ParticleTypes.ELECTRIC_SPARK, 40, 1.5);
                sound(p, SoundEvents.BEACON_POWER_SELECT);
            }
            case GHOSTFREAK -> {
                for (LivingEntity e : around(p, 8)) {
                    e.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0));
                    e.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
                }
                p.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0, false, false));
                p.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 2));
                fx(p, ParticleTypes.SOUL, 30, 1.2);
                sound(p, SoundEvents.SOUL_ESCAPE);
            }
        }
        p.getPersistentData().putLong("omni_ready", now + a.cooldown);
        p.displayClientMessage(Component.translatable(a.abilityKey()), true);
    }

    private static List<LivingEntity> around(ServerPlayer p, double r) {
        return p.level().getEntitiesOfClass(LivingEntity.class, p.getBoundingBox().inflate(r),
                e -> e != p && e.isAlive() && e.distanceTo(p) <= r);
    }

    private static List<LivingEntity> cone(ServerPlayer p, double range, double minDot) {
        Vec3 eye = p.getEyePosition();
        Vec3 look = p.getLookAngle();
        return p.level().getEntitiesOfClass(LivingEntity.class, p.getBoundingBox().inflate(range), e -> {
            if (e == p || !e.isAlive()) return false;
            Vec3 d = e.getBoundingBox().getCenter().subtract(eye);
            return d.length() <= range && d.normalize().dot(look) >= minDot;
        });
    }

    private static void fx(ServerPlayer p, ParticleOptions o, int n, double spread) {
        p.serverLevel().sendParticles(o, p.getX(), p.getY() + p.getBbHeight() / 2, p.getZ(), n, spread, spread / 2, spread, 0.05);
    }

    private static void trail(ServerPlayer p, ParticleOptions o, double len) {
        Vec3 eye = p.getEyePosition(), look = p.getLookAngle();
        for (double t = 1; t <= len; t += 0.5) {
            Vec3 pos = eye.add(look.scale(t));
            p.serverLevel().sendParticles(o, pos.x, pos.y - 0.2, pos.z, 3, 0.15, 0.15, 0.15, 0.02);
        }
    }

    private static void sound(ServerPlayer p, SoundEvent s) {
        p.level().playSound(null, p.blockPosition(), s, SoundSource.PLAYERS, 1f, 1f);
    }
}
