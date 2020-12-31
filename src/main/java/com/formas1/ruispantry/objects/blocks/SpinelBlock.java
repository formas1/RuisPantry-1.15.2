package com.formas1.ruispantry.objects.blocks;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.init.DeferredBlockInit;
import com.formas1.ruispantry.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SpinelBlock extends Block
{
	public SpinelBlock(Properties properties)
	{
		super(properties);
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return Block.makeCuboidShape(1.0D, 1.0D, 1.0D, 15.0D, 15.0D, 15.0D);
	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn)
	{
		if(entityIn instanceof ItemEntity)
		{
			if(((ItemEntity) entityIn).getItem().getItem() == ItemInit.ender_asurite.asItem())
			{
				worldIn.addEntity(new LightningBoltEntity(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), false));
				worldIn.createExplosion(entityIn, pos.getX(), pos.getY(), pos.getZ(), 1.0F, Explosion.Mode.NONE);
				worldIn.setDayTime(13000);
				worldIn.setBlockState(pos, DeferredBlockInit.PANTRY_PORTAL.get().getDefaultState());
			}
		}
	}
}
