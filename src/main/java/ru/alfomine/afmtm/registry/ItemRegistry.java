package ru.alfomine.afmtm.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.alfomine.afmtm.block.BlockJumpPad;
import ru.alfomine.afmtm.item.ItemJumpKit;

@Mod.EventBusSubscriber(modid = "afmtm")
public class ItemRegistry {
    @GameRegistry.ObjectHolder("afmtm:jumpkit")
    public static ItemJumpKit jumpkit;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemJumpKit(ItemJumpKit.TUTORIAL_ARMOR, 0, ));
    }
}
