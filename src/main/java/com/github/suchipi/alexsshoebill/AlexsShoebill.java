package com.github.suchipi.alexsshoebill;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.suchipi.alexsshoebill.config.AMConfig;
import com.github.suchipi.alexsshoebill.config.BiomeConfig;
import com.github.suchipi.alexsshoebill.config.ConfigHolder;
import com.github.suchipi.alexsshoebill.entity.AMEntityRegistry;
import com.github.suchipi.alexsshoebill.world.AMWorldRegistry;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

@Mod(AlexsShoebill.MODID)
@Mod.EventBusSubscriber(modid = AlexsShoebill.MODID)
public class AlexsShoebill {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "alexsshoebill";
    public static final SimpleChannel NETWORK_WRAPPER;
    private static final String PROTOCOL_VERSION = Integer.toString(1);
    public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    static {
        NetworkRegistry.ChannelBuilder channel = NetworkRegistry.ChannelBuilder.named(new ResourceLocation("alexsshoebill", "main_channel"));
        String version = PROTOCOL_VERSION;
        version.getClass();
        channel = channel.clientAcceptedVersions(version::equals);
        version = PROTOCOL_VERSION;
        version.getClass();
        NETWORK_WRAPPER = channel.serverAcceptedVersions(version::equals).networkProtocolVersion(() -> {
            return PROTOCOL_VERSION;
        }).simpleChannel();
    }

    public AlexsShoebill() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onModConfigEvent);
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        AMEntityRegistry.DEF_REG.register(FMLJavaModLoadingContext.get().getModEventBus());
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC, "alexsshoebill.toml");
        PROXY.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onModConfigEvent(final ModConfigEvent event) {
        final ModConfig config = event.getConfig();
        // Rebake the configs when they change
        if (config.getSpec() == ConfigHolder.COMMON_SPEC) {
            AMConfig.bake(config);
        }
        BiomeConfig.init();
    }
    @SubscribeEvent
    public void onBiomeLoadFromJSON(BiomeLoadingEvent event) {
        AMWorldRegistry.onBiomesLoad(event);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void setupClient(FMLClientSetupEvent event) {
        PROXY.clientInit();
    }

}
