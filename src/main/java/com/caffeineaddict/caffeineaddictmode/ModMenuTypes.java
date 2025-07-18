package com.caffeineaddict.caffeineaddictmode;

import com.caffeineaddict.caffeineaddictmode.blocks.CoffeeMachine.CoffeeMachineMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, CaffeineAddictMode.MOD_ID);

    public static final RegistryObject<MenuType<CoffeeMachineMenu>> COFFEE_MACHINE_MENU =
            MENU_TYPES.register("coffee_machine_menu",
                    () -> IForgeMenuType.create(CoffeeMachineMenu::new));

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }
}
