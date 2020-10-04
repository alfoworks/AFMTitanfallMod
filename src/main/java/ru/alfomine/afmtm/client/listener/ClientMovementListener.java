package ru.alfomine.afmtm.client.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import ru.alfomine.afmtm.movement.ClientMovementData;
import ru.alfomine.afmtm.movement.ClientMovementManager;

public class ClientMovementListener {
    @SubscribeEvent
    public void onUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();

            if (!ClientMovementData.DOUBLE_JUMP && player.onGround) {
                ClientMovementData.DOUBLE_JUMP = true;
            }
        }
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getMinecraft();

        if (mc.gameSettings.keyBindJump.isKeyDown()) {
            if (!mc.player.onGround) {
                ClientMovementManager.triggerDoubleJump();
            }
        }
    }
}
