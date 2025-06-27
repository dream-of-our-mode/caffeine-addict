package com.caffeineaddict.caffeineaddictmode;

import com.caffeineaddict.caffeineaddictmode.block.entity.GrinderBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CaffeineAddictMode.MOD_ID);

    // 그라인더 블록 등록
//    public static final RegistryObject<Block> GRINDER_BLOCK =
//            BLOCKS.register("grinder", () ->
//                    new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0f)));
    public static final RegistryObject<Block> GRINDER_BLOCK =
            BLOCKS.register("grinder", () ->
                    new GrinderBlock());

    // 그라인더 블록 아이템 등록
    public static final RegistryObject<Item> GRINDER_ITEM =
            ModItems.ITEMS.register("grinder", () ->
                    new BlockItem(GRINDER_BLOCK.get(), new Item.Properties().tab(ModCreativeTab.CAFFEINE_TAB)));

    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}