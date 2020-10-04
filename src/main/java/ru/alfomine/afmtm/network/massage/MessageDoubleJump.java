package ru.alfomine.afmtm.network.massage;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import ru.alfomine.afmtm.movement.MovementData;
import ru.alfomine.afmtm.registry.SoundRegistry;

public class MessageDoubleJump implements IMessage, IMessageHandler<MessageDoubleJump, IMessage> {
    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    @Override
    public IMessage onMessage(MessageDoubleJump message, MessageContext ctx) {
        EntityPlayerMP player = ctx.getServerHandler().player;

        if (!MovementData.getDoubleJumpData(player) || player.onGround) {
            return null;
        }

        player.world.playSound(player, player.getPosition(), SoundRegistry.DOUBLE_JUMP, SoundCategory.PLAYERS, 1.0F, 1.0F);

        player.setVelocity(0, 0.5, 0);
        player.velocityChanged = true;

        MovementData.setDoubleJumpData(player, false);

        return null;
    }
}
