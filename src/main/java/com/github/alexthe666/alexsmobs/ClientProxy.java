package com.github.alexthe666.alexsmobs;

import com.github.alexthe666.alexsmobs.client.render.RenderShoebill;
import com.github.alexthe666.alexsmobs.entity.AMEntityRegistry;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = AlexsMobs.MODID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {
    public void init() {
    }

    public void clientInit() {
        EntityRenderers.register(AMEntityRegistry.SHOEBILL.get(), RenderShoebill::new);
    }
}
