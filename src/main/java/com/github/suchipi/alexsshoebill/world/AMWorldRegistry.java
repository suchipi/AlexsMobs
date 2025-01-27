package com.github.suchipi.alexsshoebill.world;

import org.apache.commons.lang3.tuple.Pair;

import com.github.suchipi.alexsshoebill.AlexsShoebill;
import com.github.suchipi.alexsshoebill.config.AMConfig;
import com.github.suchipi.alexsshoebill.config.BiomeConfig;
import com.github.suchipi.alexsshoebill.entity.AMEntityRegistry;
import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AlexsShoebill.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AMWorldRegistry {

    public static boolean initBiomes = false;

    public static void onBiomesLoad(BiomeLoadingEvent event) {
        initBiomes = true;

        if (testBiome(BiomeConfig.shoebill, event.getCategory(), event.getName()) && AMConfig.shoebillSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(AMEntityRegistry.SHOEBILL.get(), AMConfig.shoebillSpawnWeight, 1, 2));
        }
    }

    public static boolean testBiome(Pair<String, SpawnBiomeData> entry, Biome.BiomeCategory category, ResourceLocation registryName) {
        boolean result = false;
        try {
            result = BiomeConfig.test(entry, category, registryName);
        } catch (Exception e) {
            AlexsShoebill.LOGGER.warn("could not test biome config for " + entry.getLeft() + ", defaulting to no spawns for mob");
            result = false;
        }
        return result;
    }

}
