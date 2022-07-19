package com.github.alexthe666.alexsmobs.config;

import com.github.alexthe666.citadel.config.biome.BiomeEntryType;
import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;

public class DefaultBiomes {

    public static final SpawnBiomeData EMPTY = new SpawnBiomeData();

    public static final SpawnBiomeData SHOEBILL = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_DICT, false, "overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_DICT, false, "swamp", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "biomesoplenty:tundra_bog", 1)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "terralith:ice_marsh", 2)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "terralith:orchid_swamp", 3)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "terralith:red_oasis", 4);

}
