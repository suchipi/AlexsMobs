package com.github.alexthe666.alexsmobs.misc;

import com.github.alexthe666.alexsmobs.AlexsMobs;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class AMTagRegistry {
    public static final TagKey<Item> SHOEBILL_FOODSTUFFS = registerItemTag("shoebill_foodstuffs");
    
    private static TagKey<Item> registerItemTag(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(AlexsMobs.MODID, name));
    }
}
