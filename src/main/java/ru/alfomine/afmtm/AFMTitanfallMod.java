package ru.alfomine.afmtm;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import ru.alfomine.afmtm.command.CommandTestDimTeleport;
import ru.alfomine.afmtm.listener.MovementListener;
import ru.alfomine.afmtm.network.AFMTMPacketHandler;
import ru.alfomine.afmtm.proxy.IProxy;
import ru.alfomine.afmtm.registry.WorldRegistry;

@Mod(
        modid = AFMTitanfallMod.MOD_ID,
        name = AFMTitanfallMod.MOD_NAME,
        version = AFMTitanfallMod.VERSION
)
public class AFMTitanfallMod {

    public static final String MOD_ID = "afmtm";
    public static final String MOD_NAME = "AFMTitanfallMod";
    public static final String VERSION = "0.1-BETA";

    @SidedProxy(clientSide = "ru.alfomine.afmtm.proxy.ClientProxy", serverSide = "ru.alfomine.afmtm.proxy.CommonProxy")
    public static IProxy proxy;

    @Mod.Instance(MOD_ID)
    public static AFMTitanfallMod INSTANCE;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new MovementListener());

        AFMTMPacketHandler.init();
        WorldRegistry.init();

        DimensionManager.registerDimension(WorldRegistry.TEST_DIM_TYPE.getId(), WorldRegistry.TEST_DIM_TYPE);

        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandTestDimTeleport());
    }
}
