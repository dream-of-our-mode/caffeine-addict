package com.caffeineaddict.caffeineaddictmode.registry;

import com.caffeineaddict.caffeineaddictmode.CaffeineAddictMode;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CaffeineAddictMode.MOD_ID);

    public static final RegistryObject<SoundEvent> GRINDER_SOUND =
            SOUNDS.register("block.grinder",
                    () -> new SoundEvent(new ResourceLocation(CaffeineAddictMode.MOD_ID, "block.grinder")));

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }

}