package com.formas1.ruispantry.client.entity.render;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.client.entity.model.UndeadVindicatorModel;
import com.formas1.ruispantry.entities.UndeadVindicator;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class UndeadVindicatorRender extends MobRenderer<UndeadVindicator, UndeadVindicatorModel<UndeadVindicator>>
{
	protected static final ResourceLocation TEXTURE = new ResourceLocation(RuisPantry.MOD_ID, "textures/entity/undead_vindicator.png");
	
	public UndeadVindicatorRender(EntityRendererManager renderManagerIn)
	{
		super(renderManagerIn, new UndeadVindicatorModel<UndeadVindicator>(), 0.5f);
	}
	
	@Override
	public ResourceLocation getEntityTexture(UndeadVindicator entity)
	{
		return TEXTURE;
	}
}
