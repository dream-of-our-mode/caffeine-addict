package com.caffeineaddict.caffeineaddictmode.items.drink;

import com.caffeineaddict.caffeineaddictmode.registry.ModCreativeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public class DrinkItemProperties {
    public static Item.Properties espressoProperties(){
        final FoodProperties food = new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.1f).
                alwaysEat()
                .build();

        return new Properties().stacksTo(1).food(food).tab(ModCreativeTab.CAFFEINE_TAB);
    }

    public static Item.Properties americanoProperties(){
        return new Properties().stacksTo(1).tab(ModCreativeTab.CAFFEINE_TAB);
    }
}
