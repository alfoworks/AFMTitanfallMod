package ru.alfomine.afmtm.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import ru.alfomine.afmtm.network.massage.MessageDoubleJump;

public class AFMTMPacketHandler {
    public static SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("afmtm");
    private static int messageId = 0;

    public static void init() {
        registerMessage(MessageDoubleJump.class, MessageDoubleJump.class, Side.SERVER);
    }

    private static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, Side side) {
        INSTANCE.registerMessage(messageHandler, requestMessageType, messageId++, side);
    }
}
