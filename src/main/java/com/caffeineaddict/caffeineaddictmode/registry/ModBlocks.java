package com.caffeineaddict.caffeineaddictmode.registry;

import com.caffeineaddict.caffeineaddictmode.block.WaterDispenserBlock;
import com.caffeineaddict.caffeineaddictmode.block.entity.GrinderBlock;
import com.caffeineaddict.caffeineaddictmode.block.IceMakerBlock;

import com.caffeineaddict.caffeineaddictmode.CaffeineAddictMode;
import com.caffeineaddict.caffeineaddictmode.blocks.CoffeeMachine.CoffeeMachineBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CaffeineAddictMode.MOD_ID);

    public static final RegistryObject<Block> WATER_DISPENSER =
            BLOCKS.register("water_dispenser",
                    () -> new WaterDispenserBlock(BlockBehaviour.Properties.of(Material.METAL).strength(3.0f)));

    public static final RegistryObject<Block> GRINDER_BLOCK =
            BLOCKS.register("grinder", () ->
                    new GrinderBlock());

    public static final RegistryObject<Block> ICE_MAKER =
            BLOCKS.register("ice_maker", () ->
                    new IceMakerBlock());

    public static final RegistryObject<Block> COFFEE_MACHINE_BLOCK = BLOCKS.register("coffee_machine",
            () -> new CoffeeMachineBlock(Properties.of(Material.STONE).strength(2.0f)));

    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}