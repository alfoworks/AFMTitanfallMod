package ru.alfomine.afmtm.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundRegistry {
    public static SoundEvent DOUBLE_JUMP;
    public static SoundEvent JUMP_FAIL;
    public static SoundEvent JUMPPAD_LAUNCH;

    public static void init() {
        DOUBLE_JUMP = getSoundEvent("double_jump");
        JUMP_FAIL = getSoundEvent("jump_fail");
        JUMPPAD_LAUNCH = getSoundEvent("jumppad_launch");
    }

    private static SoundEvent getSoundEvent(String soundId) {
        ResourceLocation soundLocation = new ResourceLocation("afmtm", soundId);

        SoundEvent soundEvent = new SoundEvent(soundLocation);
        soundEvent.setRegistryName(soundLocation);

        return soundEvent;
    }
}
