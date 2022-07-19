package com.github.alexthe666.alexsmobs.item;

import com.github.alexthe666.alexsmobs.AlexsMobs;
import com.github.alexthe666.alexsmobs.entity.*;

import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

@Mod.EventBusSubscriber(modid = AlexsMobs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AMItemRegistry {
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ForgeSpawnEggItem(AMEntityRegistry.SHOEBILL, 0X828282,0XD5B48A, new Item.Properties().tab(CreativeModeTab.TAB_MISC)).setRegistryName("alexsmobs:spawn_egg_shoebill"));
    }
}
