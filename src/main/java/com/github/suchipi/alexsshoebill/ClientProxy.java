package com.github.suchipi.alexsshoebill;

import com.github.suchipi.alexsshoebill.client.render.RenderShoebill;
import com.github.suchipi.alexsshoebill.entity.AMEntityRegistry;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = AlexsShoebill.MODID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {
    public void init() {
    }

    public void clientInit() {
        EntityRenderers.register(AMEntityRegistry.SHOEBILL.get(), RenderShoebill::new);
    }
}
