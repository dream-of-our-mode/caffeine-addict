package com.caffeineaddict.caffeineaddictmode;

import static com.caffeineaddict.caffeineaddictmode.ModBlocks.COFFEE_MACHINE_BLOCK;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "caffeineaddictmode");

    public static final RegistryObject<Item> COFFEE_MACHINE_ITEM =
            ModItems.ITEMS.register("coffee_machine", () ->
                    new BlockItem(COFFEE_MACHINE_BLOCK.get(), new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB)));

    public static RegistryObject<Item> getCoffeeMachine(){
        return COFFEE_MACHINE_ITEM;
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
