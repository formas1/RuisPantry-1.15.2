package com.formas1.ruispantry.objects.blocks;

import java.util.Random;
import java.util.function.Function;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.init.BlockInit;
import com.formas1.ruispantry.init.DeferredBlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

public class PantryPortalBlock extends Block
{

	public PantryPortalBlock(Properties properties)
	{
		super(properties);
	}
	
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) 
	{
		return false;
	}
	
	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos)
	{
		return 0;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return Block.makeCuboidShape(4.0D, 4.0D, 4.0D, 12.0D, 12.0D, 12.0D);
	}
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		if(worldIn.rand.nextInt(10) >= 8)
		{
		worldIn.addParticle(ParticleTypes.EXPLOSION, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0.00D, 0.00D, 0.00D);
		}
		worldIn.addParticle(ParticleTypes.DAMAGE_INDICATOR, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0.00D, 0.00D, 0.00D);
	}
	
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos)
	{
		return true;
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn)
	{
		if(!worldIn.getDimension().getType().equals(DimensionType.byName(RuisPantry.PANTRY_DIM_TYPE)) && !worldIn.isRemote)
		{
			entityIn.changeDimension(DimensionType.byName(RuisPantry.PANTRY_DIM_TYPE), new ITeleporter() {
                @Override
                public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw,
                        Function<Boolean, Entity> repositionEntity) {
                    Entity tpEntity = entity;
                    tpEntity = repositionEntity.apply(false);
                    tpEntity.setPositionAndUpdate(pos.getX(), 140, pos.getZ());
                    if(tpEntity instanceof PlayerEntity)
                    {
                    	((PlayerEntity) tpEntity).addItemStackToInventory(new ItemStack(DeferredBlockInit.PANTRY_PORTAL.get().asItem(), 1));
                    }
                    if(tpEntity instanceof LivingEntity)
                    {
                    	((LivingEntity) tpEntity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 200, 0));
                    }
                    return tpEntity;
                }
            });
		} else if(worldIn.getDimension().getType().equals(DimensionType.byName(RuisPantry.PANTRY_DIM_TYPE)) && !worldIn.isRemote){
			entityIn.changeDimension(DimensionType.OVERWORLD, new ITeleporter() {
                @Override
                public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw,
                        Function<Boolean, Entity> repositionEntity) {
                    Entity tpEntity = entity;
                    tpEntity = repositionEntity.apply(false);
                    tpEntity.setPositionAndUpdate(pos.getX(), 140, pos.getZ());
                    /*if(tpEntity instanceof PlayerEntity)
                    {
                    	((PlayerEntity) tpEntity).addItemStackToInventory(new ItemStack(DeferredBlockInit.PANTRY_PORTAL.get().asItem(), 1));
                    }*/
                    if(tpEntity instanceof LivingEntity)
                    {
                    	((LivingEntity) tpEntity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 200, 0));
                    }
                    return tpEntity;
                }
            });
		}
	}
}
