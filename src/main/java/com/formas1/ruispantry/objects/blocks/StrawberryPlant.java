package com.formas1.ruispantry.objects.blocks;

import java.util.Random;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.init.BlockInit;
import com.formas1.ruispantry.init.ItemInit;
import com.mojang.realmsclient.gui.screens.RealmsResetWorldScreen.ResetWorldInfo;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.settings.ParticleStatus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = RuisPantry.MOD_ID, bus = Bus.FORGE)
public class StrawberryPlant extends SweetBerryBushBlock
{

	public StrawberryPlant(Properties p_i49971_1_)
	{
		super(p_i49971_1_);
	}
	
	@Override
	public boolean ticksRandomly(BlockState state)
	{
		return true;
	}
	
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand)
	{
		super.tick(state, worldIn, pos, rand);
		
		if(state.get(AGE) >= 2 && worldIn.getBlockState(pos.up()).getBlock() != BlockInit.strawberry_plant && worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState())
		{
			if(worldIn.getBlockState(pos.down()).getBlock() == Blocks.FARMLAND)
			{
			worldIn.setBlockState(pos.up(), state);
			} else if ( worldIn.getBlockState(pos.down()).getBlock() == BlockInit.strawberry_plant && worldIn.getBlockState(pos.down().down()).getBlock() == Blocks.FARMLAND) {
				worldIn.setBlockState(pos.up(), BlockInit.big_strawberry.getDefaultState());
			}
		}
		
		if(worldIn.getBlockState(pos.down()).getBlock() instanceof StrawberryPlant)
		{
			if(worldIn.getBlockState(pos.down()).get(BlockStateProperties.AGE_0_3) <= 1)
			{
				worldIn.destroyBlock(pos, true);
			}
		}
		
		/*if(worldIn.getBlockState(pos.down()).getBlock() != BlockInit.strawberry_plant && worldIn.getBlockState(pos.down()).getBlock() != Blocks.FARMLAND && worldIn.getBlockState(pos.down()).getBlock() != Blocks.GRASS_BLOCK)
		{
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}*/
			
	}
	
	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos)
	{
		 Block block = state.getBlock();
	     return block == Blocks.FARMLAND || block == BlockInit.strawberry_plant || block == Blocks.GRASS;
	}
	
	@SubscribeEvent
	public static void onBonemeal(BonemealEvent event)
	{
		BlockState state = event.getBlock();
		World worldIn = event.getWorld();
		BlockPos pos = event.getPos();
		if(state.getBlock() instanceof StrawberryPlant)
		{
			if(state.get(AGE) >= 2 && worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState())
			{
				if(worldIn.getRandom().nextInt(100) >= 80)
				{
					if(worldIn.getBlockState(pos.down()) == Blocks.FARMLAND.getDefaultState())
					{
						worldIn.setBlockState(pos.up(), BlockInit.strawberry_plant.getDefaultState().with(BlockStateProperties.AGE_0_3, 2));
					} else if (worldIn.getBlockState(pos.down()).getBlock() == BlockInit.strawberry_plant && worldIn.getBlockState(pos.down().down()).getBlock() == Blocks.FARMLAND) {
						worldIn.setBlockState(pos.up(), BlockInit.big_strawberry.getDefaultState());
					}
				}
			}
		}
		//event.setResult(Event.Result.ALLOW);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		 if(stateIn.get(AGE) >= 2)
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
	
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state)
	{
		return new ItemStack(this);
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack)
	{
		  BlockPos groundpos = pos.down();
		  Block groundblock = worldIn.getBlockState(groundpos).getBlock();
		  if(groundblock != Blocks.FARMLAND)
		  {
			  worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			  spawnAsEntity(worldIn, pos, new ItemStack(BlockInit.strawberry_plant, 1));
		  }
				  
	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn)
	{
		if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.FOX && entityIn.getType() != EntityType.BEE)
		{
			entityIn.setMotionMultiplier(state, new Vec3d((double)0.8F, 0.75D, (double)0.8F));
		}
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
		return Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
	{	
	      int i = state.get(AGE);
	      boolean flag = i == 3;
	      if (!flag && player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
	         return ActionResultType.PASS;
	      } else if (i > 2) {
	         int j = 1 + worldIn.rand.nextInt(2);
	         spawnAsEntity(worldIn, pos, new ItemStack(ItemInit.strawberry, j + (flag ? 1 : 0)));
	         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
	         worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(1)), 2);
	         if(worldIn.getBlockState(pos.up()).getBlock() instanceof StrawberryPlant || worldIn.getBlockState(pos.up()).getBlock() instanceof BigStrawberry)
	         {
	        	 worldIn.destroyBlock(pos.up(), true);
	         }
	         return ActionResultType.SUCCESS;
	      } else if (i == 2) {
		         int j = 1 + worldIn.rand.nextInt(2);
		         spawnAsEntity(worldIn, pos, new ItemStack(BlockInit.strawberry_plant, j));
		         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
		         worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(1)), 2);
		         if(worldIn.getBlockState(pos.up()).getBlock() instanceof StrawberryPlant || worldIn.getBlockState(pos.up()).getBlock() instanceof BigStrawberry)
		         {
		        	 worldIn.destroyBlock(pos.up(), true);
		         }
		         return ActionResultType.SUCCESS;
		      } else {
	         return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	      }
	}
}
