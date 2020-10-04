package ru.alfomine.afmtm.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.alfomine.afmtm.registry.BlockRegistry;
import ru.alfomine.afmtm.registry.SoundRegistry;

import javax.vecmath.Vector3d;

public class BlockJumpPad extends Block {

    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);

    public BlockJumpPad() {
        super(Material.IRON);

        setTranslationKey("jumppad");
        setRegistryName("jumppad");
        setCreativeTab(BlockRegistry.tab);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return AABB;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return AABB;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        System.out.println("123");

        if (worldIn.isRemote) {
            Minecraft.getMinecraft().player.playSound(SoundRegistry.JUMPPAD_LAUNCH, 1, 1);
        } else {
            double yaw = entityIn.rotationYaw + 180;
            double velX = Math.sin(Math.toRadians(yaw));
            double velZ = -1 * Math.cos(Math.toRadians(yaw));

            entityIn.addVelocity(velX * 1.5, 1, velZ * 1.5);
            entityIn.velocityChanged = true;
        }
    }
}
