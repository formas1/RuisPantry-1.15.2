package com.formas1.ruispantry.objects.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Spinel extends Block{

	public Spinel(Properties properties)
	{
		super(properties);
	}
	
	@Override
	public boolean ticksRandomly(BlockState state)
	{
		return true;
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		if(rand.nextInt(100) <= 5)
		{
		     worldIn.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, pos.getX() + 0.5D, pos.getY() + 0.1D, pos.getZ() + 0.5D, 0.0D, 1.0D, 0.0D);
		}	 
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	{
		worldIn.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, pos.getX() + 0.5D, pos.getY() + 0.1D, pos.getZ() + 0.5D, 0.0D, 1.0D, 0.0D);
	}
}
