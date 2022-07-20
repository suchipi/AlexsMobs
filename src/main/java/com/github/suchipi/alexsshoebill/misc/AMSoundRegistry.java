package com.github.suchipi.alexsshoebill.misc;

import com.github.suchipi.alexsshoebill.AlexsShoebill;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = AlexsShoebill.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AMSoundRegistry {

    public static final SoundEvent SHOBILL_RATTLE = createSoundEvent("shoebill_rattle");

    private static SoundEvent createSoundEvent(final String soundName) {
        final ResourceLocation soundID = new ResourceLocation(AlexsShoebill.MODID, soundName);
        return new SoundEvent(soundID).setRegistryName(soundID);
    }

    @SubscribeEvent
    public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event) {
        try {
            for (Field f : AMSoundRegistry.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof SoundEvent) {
                    event.getRegistry().register((SoundEvent) obj);
                } else if (obj instanceof SoundEvent[]) {
                    for (SoundEvent soundEvent : (SoundEvent[]) obj) {
                        event.getRegistry().register(soundEvent);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
