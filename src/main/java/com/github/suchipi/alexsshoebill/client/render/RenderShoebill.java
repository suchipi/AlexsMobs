package com.github.suchipi.alexsshoebill.client.render;

import com.github.suchipi.alexsshoebill.client.model.ModelShoebill;
import com.github.suchipi.alexsshoebill.entity.EntityShoebill;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderShoebill extends MobRenderer<EntityShoebill, ModelShoebill> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("alexsshoebill:textures/entity/shoebill.png");

    public RenderShoebill(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelShoebill(), 0.3F);
    }

    protected void scale(EntityShoebill entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
    }

    public ResourceLocation getTextureLocation(EntityShoebill entity) {
        return TEXTURE;
    }
}
