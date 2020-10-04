package ru.alfomine.afmtm.world;

import net.minecraft.entity.Entity;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.alfomine.afmtm.registry.WorldRegistry;
import ru.alfomine.afmtm.render.RenderBlank;
import ru.alfomine.afmtm.render.RenderColiseumSky;

public class TestDimWorldProvider extends WorldProvider {
    public TestDimWorldProvider() {
        biomeProvider = new BiomeProviderSingle(Biomes.VOID);
        nether = false;
    }

    // Небо

    @Override
    public Vec3d getSkyColor(Entity cameraEntity, float partialTicks) {
        setCloudRenderer(RenderBlank.getInstance());
        setSkyRenderer(RenderColiseumSky.getInstance());

        return new Vec3d(0.0D, 0.0D, 0.0D);
    }

    @Override
    protected void init() {
        super.init();

        world.setSeaLevel(0);
    }

    @Override
    public DimensionType getDimensionType() {
        return WorldRegistry.TEST_DIM_TYPE;
    }

    @Override
    public boolean isSurfaceWorld() {
        return true;
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
    }

    @Override
    public int getAverageGroundLevel() {
        return 1;
    }

    @Override
    public double getHorizon() {
        return -256;
    }

    @Override
    public Biome getBiomeForCoords(final BlockPos blockPos) {
        return Biomes.VOID;
    }

    @Override
    public float calculateCelestialAngle(final long time, final float partialTick) {
        return 0.0F;
    }

    @Override
    protected void generateLightBrightnessTable() {
        final float ambient = 0.0F;

        for (int i = 0; i <= 15; ++i) {
            final float f1 = 1.0F - i / 15.0F;
            lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - ambient) + ambient;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isSkyColored() {
        return false;
    }

    @Override
    public boolean isDaytime() {
        return true;
    }

    @Override
    public boolean canDoLightning(final Chunk chunk) {
        return false;
    }

    @Override
    public boolean canSnowAt(BlockPos pos, boolean checkLight) {
        return false;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new TestDimChunkGenerator(world);
    }
}
