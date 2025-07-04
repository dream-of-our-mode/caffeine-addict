package com.caffeineaddict.caffeineaddictmode;

import com.caffeineaddict.caffeineaddictmode.CaffeineAddictMode;
import net.minecraft.world.item.CreativeModeTab;
import com.caffeineaddict.caffeineaddictmode.registry.ModBlocks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final String MOD_ID = CaffeineAddictMode.MOD_ID;

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Item> PLACEHOLDER_ITEM = ITEMS.register(
            "placeholder_item",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB))
    );

    public static final RegistryObject<Item> GROUND_COFFEE =
            ITEMS.register("ground_coffee", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB)));

//    public static RegistryObject<Item> getGrinderItem() {
//        return ModBlocks.GRINDER_ITEM;
//    }
    public static final RegistryObject<Item> GRINDER_ITEM =
            ModItems.ITEMS.register("grinder", () ->
                    new BlockItem(ModBlocks.GRINDER_BLOCK.get(), new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB))
            );
    /**
     * Ingredients
     */
    public static final RegistryObject<Item> COFFEE_BEAN = ITEMS.register(
            "coffee_bean",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB))
    );

    public static final RegistryObject<Item> ROASTED_COFFEE_BEAN = ITEMS.register(
            "roasted_coffee_bean",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB))
    );

    public static final RegistryObject<Item> COFFEE_POWDER = ITEMS.register(
            "coffee_powder",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB))
    );

    public static final RegistryObject<Item> MILK = ITEMS.register(
            "milk",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB))
    );

    public static final RegistryObject<Item> ICE = ITEMS.register(
            "ice",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB))
    );

    public static final RegistryObject<Item> HOT_WATER = ITEMS.register(
            "hot_water",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB))
    );

    public static final RegistryObject<Item> COOL_WATER = ITEMS.register(
            "cool_water",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB))
    );

    public static final RegistryObject<Item> CUP = ITEMS.register(
            "cup",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB))
    );

    /**
     * Drink
     */
    public static final RegistryObject<Item> ESPRESSO = ITEMS.register(
            "espresso",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeTab.CAFFEINE_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationMod(0.3f)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15 * 20, 0), 1.0f)
                            .alwaysEat()
                            .build()
                    )
            )
    );

    public static final RegistryObject<Item> ICE_WATER = ITEMS.register(
            "ice_water",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeTab.CAFFEINE_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationMod(0.3f)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15 * 20, 0), 1.0f)
                            .alwaysEat()
                            .build()
                    )
            )
    );

    public static final RegistryObject<Item> AMERICANO = ITEMS.register(
            "americano",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeTab.CAFFEINE_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationMod(0.3f)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15 * 20, 0), 1.0f)
                            .alwaysEat()
                            .build()
                    )
            )
    );

    public static final RegistryObject<Item> ICE_AMERICANO = ITEMS.register(
            "ice_americano",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeTab.CAFFEINE_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationMod(0.3f)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15 * 20, 0), 1.0f)
                            .alwaysEat()
                            .build()
                    )
            )
    );

    public static final RegistryObject<Item> LATTE = ITEMS.register(
            "latte",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeTab.CAFFEINE_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationMod(0.3f)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15 * 20, 0), 1.0f)
                            .alwaysEat()
                            .build()
                    )
            )
    );

    public static final RegistryObject<Item> ICE_LATTE = ITEMS.register(
            "ice_latte",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeTab.CAFFEINE_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationMod(0.3f)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15 * 20, 0), 1.0f)
                            .alwaysEat()
                            .build()
                    )
            )
    );

    /**
     * Block
     */
    public static final RegistryObject<Item> WATER_DISPENSER_ITEM =
            ITEMS.register("water_dispenser", () ->
                    new BlockItem(ModBlocks.WATER_DISPENSER.get(),
                            new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB))
            );

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    /**
     * dried tea leaf
     */
    public static final RegistryObject<Item> DRIED_DANDELION_LEAF =
            ITEMS.register("dried_dandelion_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_BlUE_ORCHID_LEAF =
            ITEMS.register("dried_blue_orchid_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_ALLIUM_LEAF =
            ITEMS.register("dried_allium_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_AZURE_BLUET_LEAF =
            ITEMS.register("dried_azure_bluet_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_RED_TULIP_LEAF =
            ITEMS.register("dried_red_tulip_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_ORANGE_TULIP_LEAF =
            ITEMS.register("dried_orange_tulip_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_WHITE_TULIP_LEAF =
            ITEMS.register("dried_white_tulip_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_PINK_TULIP_LEAF =
            ITEMS.register("dried_pink_tulip_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_OXEYE_DAISY_LEAF =
            ITEMS.register("dried_oxeye_daisy_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_CORNFLOWER_LEAF =
            ITEMS.register("dried_cornflower_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_SUNFLOWER_LEAF =
            ITEMS.register("dried_sunflower_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_LILAC_LEAF =
            ITEMS.register("dried_lilac_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_ROSE_BUSH_LEAF =
            ITEMS.register("dried_rose_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_PEONY_LEAF =
            ITEMS.register("dried_peony_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    /**
     * tea
     */
    public class ModTea {
        public static final FoodProperties RELAXING_TEA = new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3F)
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1.0F) // 효과, 시간, 레벨
                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0), 1.0F) // 릴렉스 느낌
                .build();
    }

    public static final RegistryObject<Item> DANDELION_TEA =
            ITEMS.register("dandelion_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> BlUE_ORCHID_TEA =
            ITEMS.register("blue_orchid_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> ALLIUM_TEA =
            ITEMS.register("allium_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> AZURE_BLUET_TEA =
            ITEMS.register("azure_bluet_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> RED_TULIP_TEA =
            ITEMS.register("red_tulip_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> ORANGE_TULIP_TEA =
            ITEMS.register("orange_tulip_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> WHITE_TULIP_TEA =
            ITEMS.register("white_tulip_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> PINK_TULIP_TEA =
            ITEMS.register("pink_tulip_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> OXEYE_DAISY_TEA =
            ITEMS.register("oxeye_daisy_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> CORNFLOWER_TEA =
            ITEMS.register("cornflower_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> SUNFLOWER_TEA =
            ITEMS.register("sunflower_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> LILAC_TEA =
            ITEMS.register("lilac_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> ROSE_TEA =
            ITEMS.register("rose_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));

    public static final RegistryObject<Item> PEONY_TEA =
            ITEMS.register("peony_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(ModTea.RELAXING_TEA)));
}