package ru.alfomine.afmtm.world;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;

import java.util.ArrayList;
import java.util.List;

public class TestDimChunkGenerator implements IChunkGenerator {

    private final World world;

    public TestDimChunkGenerator(World world) {
        this.world = world;
    }

    @Override
    public Chunk generateChunk(int x, int z) {
        final ChunkPrimer chunkprimer = new ChunkPrimer();
        final Chunk chunk = new Chunk(world, chunkprimer, x, z);

        final byte[] byteBiomes = chunk.getBiomeArray();
        for (int i = 0; i < byteBiomes.length; ++i) {
            byteBiomes[i] = (byte) Biome.getIdForBiome(Biomes.VOID);
        }

        chunk.generateSkylightMap();

        return chunk;
    }

    @Override
    public void populate(int x, int z) {

    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z) {
        return false;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        return new ArrayList<>();
    }

    @Override
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z) {

    }

    @Override
    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
        return false;
    }
}
