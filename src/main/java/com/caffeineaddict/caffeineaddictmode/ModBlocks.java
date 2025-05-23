package com.caffeineaddict.caffeineaddictmode;

import com.caffeineaddict.caffeineaddictmode.blocks.CoffeeMachine.CoffeeMachineBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            CaffeineAddictMode.MOD_ID);

    public static final RegistryObject<Block> COFFEE_MACHINE_BLOCK = BLOCKS.register("coffee_machine",
            () -> new CoffeeMachineBlock(Properties.of(Material.STONE).strength(2.0f)));

    public static void register(IEventBus modEventBus){
        BLOCKS.register(modEventBus);
    }
}
