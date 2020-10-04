package ru.alfomine.afmtm.registry;

import net.minecraft.world.DimensionType;
import ru.alfomine.afmtm.world.TestDimWorldProvider;

public class WorldRegistry {
    public static DimensionType TEST_DIM_TYPE;

    public static void init() {
        TEST_DIM_TYPE = DimensionType.register("testdim", "_testdim", -1203, TestDimWorldProvider.class, true);
    }
}
