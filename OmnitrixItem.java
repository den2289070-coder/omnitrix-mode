package com.omnitrix.mod;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Управление:
 *  - не превращён: ПКМ = превратиться, Shift+ПКМ = выбрать следующего пришельца
 *  - превращён:    ПКМ = способность, Shift+ПКМ = вернуться в человека
 */
public class OmnitrixItem extends Item {
    public static final int FORM_DURATION = 2400;   // 2 минуты
    public static final int RECHARGE = 200;         // 10 секунд после возврата

    public OmnitrixItem(Properties p) { super(p); }

    public static int selected(ItemStack s) {
        int v = s.hasTag() ? s.getTag().getInt("Alien") : 0;
        return Math.floorMod(v, Alien.values().length);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (level.isClientSide || !(player instanceof ServerPlayer sp)) return InteractionResultHolder.success(stack);

        int form = OmnitrixHandler.getForm(sp);
        boolean sneak = sp.isShiftKeyDown();

        if (form < 0) {
            if (sneak) {
                int next = (selected(stack) + 1) % Alien.values().length;
                stack.getOrCreateTag().putInt("Alien", next);
                sp.displayClientMessage(Component.translatable("msg.omnitrix.selected",
                        Component.translatable(Alien.values()[next].nameKey())), true);
                level.playSound(null, sp.blockPosition(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 1f, 1.5f);
            } else {
                int idx = selected(stack);
                sp.addEffect(new MobEffectInstance(ModEffects.FORM.get(), FORM_DURATION, idx, false, false, false));
                sp.serverLevel().sendParticles(ParticleTypes.END_ROD, sp.getX(), sp.getY() + 1, sp.getZ(), 50, 0.4, 0.8, 0.4, 0.15);
                level.playSound(null, sp.blockPosition(), SoundEvents.BEACON_ACTIVATE, SoundSource.PLAYERS, 1f, 1.2f);
                sp.displayClientMessage(Component.translatable(Alien.values()[idx].nameKey()), true);
            }
        } else {
            if (sneak) {
                sp.removeEffect(ModEffects.FORM.get()); // остальное сделает OmnitrixHandler
            } else {
                Abilities.use(sp, Alien.values()[form]);
            }
        }
        return InteractionResultHolder.success(stack);
    }
}
