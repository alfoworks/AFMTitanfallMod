package ru.alfomine.afmtm.registry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.alfomine.afmtm.block.BlockJumpPad;

@Mod.EventBusSubscriber(modid = "afmtm")
public class BlockRegistry {

    public static CreativeTabs tab = new CreativeTabs("afmtm") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Blocks.STONE);
        }
    };

    @GameRegistry.ObjectHolder("afmtm:jumppad")
    public static BlockJumpPad jumppad;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockJumpPad());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(BlockRegistry.jumppad).setRegistryName(BlockRegistry.jumppad.getRegistryName()));
    }
}
