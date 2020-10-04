package ru.alfomine.afmtm.registry;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = "afmtm")
public class RegistryListener {
    @SubscribeEvent
    public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
        SoundRegistry.init();

        event.getRegistry().registerAll(SoundRegistry.DOUBLE_JUMP);
    }
}
