package ru.alfomine.afmtm.item;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import ru.alfomine.afmtm.AFMTitanfallMod;
import ru.alfomine.afmtm.registry.BlockRegistry;

public class ItemJumpKit extends ItemArmor {

    public static final ArmorMaterial TUTORIAL_ARMOR = EnumHelper.addArmorMaterial(
            AFMTitanfallMod.MOD_ID + ":" + "tutorial_armor",
            AFMTitanfallMod.MOD_ID + ":tutorial",
            16, new int[]{2, 5, 6, 3},
            0,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
            0);

    public ItemJumpKit(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, 0, equipmentSlotIn);

        this.setTranslationKey("armor.jumpkit");
        this.setRegistryName("jumpkit");
        this.setCreativeTab(BlockRegistry.tab);
    }
}
