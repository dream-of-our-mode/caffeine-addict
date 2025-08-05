package com.caffeineaddict.caffeineaddictmode;

import com.caffeineaddict.caffeineaddictmode.blocks.CoffeeMachine.CoffeeMachineScreen;
import com.caffeineaddict.caffeineaddictmode.blocks.IceMaker.network.PacketHandler;
import com.caffeineaddict.caffeineaddictmode.registry.ModBlockEntities;
import com.caffeineaddict.caffeineaddictmode.registry.ModBlocks;
import com.caffeineaddict.caffeineaddictmode.registry.ModItems;
import com.caffeineaddict.caffeineaddictmode.registry.ModMenus;
import com.caffeineaddict.caffeineaddictmode.registry.ModSoundEvents;
import com.caffeineaddict.caffeineaddictmode.blocks.Grinder.GrinderScreen;
import com.caffeineaddict.caffeineaddictmode.blocks.IceMaker.IceMakerScreen;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CaffeineAddictMode.MOD_ID)
public class CaffeineAddictMode {
    public static final String MOD_ID = "caffeineaddictmode";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CaffeineAddictMode() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenus.register(modEventBus);
        ModSoundEvents.register(modEventBus);

        FMLJavaModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(PacketHandler::register);
    }
  
    @Mod.EventBusSubscriber(modid = CaffeineAddictMode.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(final FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                //MenuScreens.register(ModMenus.WATER_DISPENSER.get(), WaterDispenserScreen::new);
                MenuScreens.register(ModMenus.GRINDER_MENU.get(), GrinderScreen::new);
                MenuScreens.register(ModMenus.ICE_MAKER_MENU.get(), IceMakerScreen::new);
                MenuScreens.register(ModMenus.COFFEE_MACHINE_MENU.get(), CoffeeMachineScreen::new);
            });
        }
    }
}
