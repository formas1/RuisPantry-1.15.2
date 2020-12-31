package com.formas1.ruispantry.objects.blocks;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.formas1.ruispantry.init.BlockInit;
import com.formas1.ruispantry.init.ItemInit;
import com.google.common.collect.Lists;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.state.IProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.BeaconTileEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext.Builder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BigStrawberry extends BushBlock
{

	public BigStrawberry(Properties properties)
	{
		super(properties);
	}
	
	@Override
	public boolean ticksRandomly(BlockState state)
	{
		return true;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
	}
	
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos)
	{
		return false;
	}
	
	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos)
	{
		 Block block = state.getBlock();
	     return block == Blocks.FARMLAND || block == BlockInit.strawberry_plant.getDefaultState().with(BlockStateProperties.AGE_0_3, 3).getBlock() || block == Blocks.GRASS;
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand)
	{
		 BlockPos groundpos = pos.down();
		  Block groundblock = worldIn.getBlockState(groundpos).getBlock();
		  if(groundblock != BlockInit.strawberry_plant)
		  {
			  //spawnAsEntity(worldIn, pos, new ItemStack(BlockInit.strawberry_plant, 1));
			  worldIn.destroyBlock(pos, true);
		  }
	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn)
	{
		
		if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.FOX && entityIn.getType() != EntityType.BEE)
		{
			entityIn.setMotionMultiplier(state, new Vec3d((double)0.8F, 0.75D, (double)0.8F));
			((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.HASTE, 200));
		}
	}
	
	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos)
	{
		return 0;
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack)
	{
		  BlockPos groundpos = pos.down();
		  Block groundblock = worldIn.getBlockState(groundpos).getBlock();
		  if(groundblock != BlockInit.strawberry_plant)
		  {
			  //spawnAsEntity(worldIn, pos, new ItemStack(BlockInit.strawberry_plant, 1));
			  worldIn.destroyBlock(pos, false);
		  }
				  
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
			 double d0 = (double)pos.getX() + rand.nextDouble();
			 double d1 = (double)pos.getY() + rand.nextDouble();
			 double d2 = (double)pos.getZ() + rand.nextDouble();
		     
			 if(d0 <= (double)pos.getX() + 0.2D || d0 >= (double)pos.getX() + 0.8D)
			 {
				 d0 = (double)pos.getX() + rand.nextDouble();
			 } else if(d2 <= (double)pos.getZ() + 0.2D || d2 >= (double)pos.getZ() + 0.8D)
			 {
				 d2 = (double)pos.getZ() + rand.nextDouble();
			 } else if(d1 <= (double)pos.getY() + 0.2D || d1 >= (double)pos.getY() + 0.8D)
			 {
				 d1 = (double)pos.getY() + rand.nextDouble();
			 } else {
		     worldIn.addParticle(ParticleTypes.FALLING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			 }
		 }

}
