package ru.alfomine.afmtm.movement;

import net.minecraft.client.Minecraft;
import ru.alfomine.afmtm.network.AFMTMPacketHandler;
import ru.alfomine.afmtm.network.massage.MessageDoubleJump;
import ru.alfomine.afmtm.registry.SoundRegistry;

public class ClientMovementManager {
    public static void triggerDoubleJump() {
        Minecraft mc = Minecraft.getMinecraft();

        if (ClientMovementData.DOUBLE_JUMP) {
            mc.player.playSound(SoundRegistry.DOUBLE_JUMP, 1, 1);

            AFMTMPacketHandler.INSTANCE.sendToServer(new MessageDoubleJump());
            ClientMovementData.DOUBLE_JUMP = false;
            mc.player.onGround = false;
        } else {
            mc.player.playSound(SoundRegistry.JUMP_FAIL, 1, 1);
        }
    }
}
