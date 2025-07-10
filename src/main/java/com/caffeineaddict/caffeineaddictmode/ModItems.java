package com.caffeineaddict.caffeineaddictmode;

import com.caffeineaddict.caffeineaddictmode.CaffeineAddictMode;
import net.minecraft.world.item.CreativeModeTab;
import com.caffeineaddict.caffeineaddictmode.registry.ModBlocks;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
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

import javax.annotation.Nullable;


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

    public static final RegistryObject<Item> DRIED_ALLIUM_LEAF =
            ITEMS.register("dried_allium_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_AZURE_BLUET_LEAF =
            ITEMS.register("dried_azure_bluet_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_CORNFLOWER_LEAF =
            ITEMS.register("dried_cornflower_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_POPPY_LEAF =
            ITEMS.register("dried_poppy_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_WITHER_ROSE_LEAF =
            ITEMS.register("dried_wither_rose_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_FERN_LEAF =
            ITEMS.register("dried_fern_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    public static final RegistryObject<Item> DRIED_WARPED_ROOTS_LEAF =
            ITEMS.register("dried_warped_roots_leaf", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB)));

    /**
     * tea
     */
    public class ModTea {
        // goodEffect 별도 지정 x (기본 적용: 화염저항 60초)
        public static FoodProperties createTeaEffect(
            MobEffect badEffect, int badDuration, int badAmplifier) {
                return createTeaEffect(
                    MobEffects.FIRE_RESISTANCE, 1200, 0,
                    badEffect, badDuration, badAmplifier
            );
        }
        // goodEffect 직접 지정
        public static FoodProperties createTeaEffect(
            MobEffect goodEffect, int goodDuration, int goodAmplifier,
            MobEffect badEffect, int badDuration, int badAmplifier) {
                return new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3F)
                    .effect(() -> new MobEffectInstance(goodEffect, goodDuration, goodAmplifier), 1.0F)
                    .effect(() -> new MobEffectInstance(badEffect, badDuration, badAmplifier), 1.0F)
                    .build();
        }
    }

    public static final RegistryObject<Item> DANDELION_TEA =
        ITEMS.register("dandelion_tea", () ->
                new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(
                        ModTea.createTeaEffect(
                                // mining_fatigue(채굴피로)
                                MobEffects.DIG_SLOWDOWN, 200, 0
                        )
                )));

    public static final RegistryObject<Item> POPPY_TEA =
            ITEMS.register("poppy_tea", () ->
                new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(
                            ModTea.createTeaEffect(
                                    // nausea(멀미)
                                    MobEffects.CONFUSION, 200, 0
                            )
                    )));

    public static final RegistryObject<Item> ALLIUM_TEA =
            ITEMS.register("allium_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(
                            ModTea.createTeaEffect(
                                    // 나약함
                                    MobEffects.WEAKNESS, 400, 0
                            )
                    )));

    public static final RegistryObject<Item> AZURE_BLUET_TEA =
            ITEMS.register("azure_bluet_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(
                            ModTea.createTeaEffect(
                                    // 실명
                                    MobEffects.BLINDNESS, 200, 0
                            )
                    )));

    public static final RegistryObject<Item> CORNFLOWER_TEA =
            ITEMS.register("cornflower_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(
                            ModTea.createTeaEffect(
                                    // 효과 부여 음수로 안된대서 일단 구속 걸어놨어요
                                    MobEffects.MOVEMENT_SLOWDOWN, 200, 0
                            )
                    )));

    public static final RegistryObject<Item> WITHER_ROSE_TEA =
            ITEMS.register("wither_rose_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(
                            ModTea.createTeaEffect(
                                    // 시듦(wither)
                                    MobEffects.WITHER, 200, 0
                            )
                    )));

    public static final RegistryObject<Item> FERN_TEA =
            ITEMS.register("fern_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(
                            ModTea.createTeaEffect(
                                    // poison
                                    MobEffects.POISON, 200, 0
                            )
                    )));

    public static final RegistryObject<Item> WARPED_ROOTS_TEA =
            ITEMS.register("warped_roots_tea", () ->
                    new Item(new Item.Properties().tab(ModCreativeTab.TEA_TAB).food(
                            ModTea.createTeaEffect(
                                    // 즉시 피해
                                    MobEffects.HARM, 1, 0
                            )
                    )));
}