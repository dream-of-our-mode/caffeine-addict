package com.caffeineaddict.caffeineaddictmode.items.drink.Coffee;

import com.caffeineaddict.caffeineaddictmode.ModItems;
import com.caffeineaddict.caffeineaddictmode.TagNSpecialConstant;
import com.caffeineaddict.caffeineaddictmode.items.drink.DrinkEffects;
import com.caffeineaddict.caffeineaddictmode.items.drink.DrinkItem;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class Espresso extends DrinkItem {
    public Espresso(Properties properties){
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (!world.isClientSide) {
            assert stack.getTag() != null;
            DrinkEffects.ESPRESSO.applyStar(stack.getTag().getInt(TagNSpecialConstant.QUALITY.getText()), user);
        }

        // If player, trigger criteria (for advancements)
        if (user instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
        }

        // Consume item like potion
        if (user instanceof Player player && !player.getAbilities().instabuild) {
            stack.shrink(1);
            return new ItemStack(ModItems.SHOT_CUP.get()); // Optional
        }

        return super.finishUsingItem(stack, world, user);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        String qualityTag = TagNSpecialConstant.QUALITY.getText();
        String baristaTag = TagNSpecialConstant.BARISTA.getText();

        if (!stack.hasTag()) return;

        if(stack.getTag().contains(qualityTag)) {
            String baristaText = stack.getTag().getString(baristaTag);
            tooltip.add(Component.translatable("tooltip.caffeineaddictmode.barista_desc", baristaText));
        }

        if(stack.getTag().contains(baristaTag)){
            int starCount = stack.getTag().getInt(qualityTag);
            String starText = TagNSpecialConstant.STAR.getRepeatText(starCount);
            tooltip.add(Component.translatable("tooltip.caffeineaddictmode.quality_desc", starText));
        }
    }

}
