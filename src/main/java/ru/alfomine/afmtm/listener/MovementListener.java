package ru.alfomine.afmtm.listener;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.alfomine.afmtm.movement.MovementData;

public class MovementListener {
    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (!event.getEntityLiving().world.isRemote && event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayerMP player = (EntityPlayerMP) event.getEntityLiving();

            if (!MovementData.getDoubleJumpData(player) && player.onGround) MovementData.setDoubleJumpData(player, true);
        }
    }
}
