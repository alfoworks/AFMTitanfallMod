package ru.alfomine.afmtm.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.server.command.CommandSetDimension;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class CommandTestDimTeleport extends CommandBase {
    @Override
    public String getName()
    {
        return "testdim";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "testdim";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        // args: <entity> <dim> [<x> <y> <z>]
        if (args.length != 2 && args.length != 5)
        {
            throw new WrongUsageException("commands.forge.setdim.usage");
        }
        Entity entity = getEntity(server, sender, args[0]);
        if (!checkEntity(entity))
        {
            throw new CommandException("commands.forge.setdim.invalid.entity", entity.getName());
        }
        int dimension = parseInt(args[1]);
        if (!DimensionManager.isDimensionRegistered(dimension))
        {
            throw new CommandException("commands.forge.setdim.invalid.dim", dimension);
        }
        if (dimension == entity.dimension)
        {
            throw new CommandException("commands.forge.setdim.invalid.nochange", entity.getName(), dimension);
        }
        BlockPos pos = args.length == 5 ? parseBlockPos(sender, args, 2, false) : sender.getPosition();
        entity.changeDimension(dimension, new CommandTeleporter(pos));
    }

    private static boolean checkEntity(Entity entity)
    {
        // use vanilla portal logic, try to avoid doing anything too silly
        return !entity.isRiding() && !entity.isBeingRidden() && entity.isNonBoss();
    }

    private static class CommandTeleporter implements ITeleporter
    {
        private final BlockPos targetPos;

        private CommandTeleporter(BlockPos targetPos)
        {
            this.targetPos = targetPos;
        }

        @Override
        public void placeEntity(World world, Entity entity, float yaw)
        {
            entity.moveToBlockPosAndAngles(targetPos, yaw, entity.rotationPitch);
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }
}
