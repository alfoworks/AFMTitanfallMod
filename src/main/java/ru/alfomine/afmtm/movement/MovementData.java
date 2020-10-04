package ru.alfomine.afmtm.movement;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.HashMap;

public class MovementData {
    private static HashMap<EntityPlayer, Boolean> DOUBLE_JUMP_DATA = new HashMap<>();

    public static boolean getDoubleJumpData(EntityPlayer player) {
        if (!DOUBLE_JUMP_DATA.containsKey(player)) {
            DOUBLE_JUMP_DATA.put(player, false);

            return false;
        }

        return DOUBLE_JUMP_DATA.get(player);
    }

    public static void setDoubleJumpData(EntityPlayerMP player, boolean data) {
        DOUBLE_JUMP_DATA.put(player, data);
    }
}
