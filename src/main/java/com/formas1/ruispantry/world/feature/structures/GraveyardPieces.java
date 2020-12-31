package com.formas1.ruispantry.world.feature.structures;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.init.FeatureInit;
import com.google.common.collect.ImmutableMap;

import io.netty.handler.codec.http2.Http2FrameLogger.Direction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.client.renderer.entity.layers.CatCollarLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.IProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class GraveyardPieces {
	private static final ResourceLocation PART_1 = new ResourceLocation(RuisPantry.MOD_ID, "graveyard/fountain");
	private static final ResourceLocation PART_2 = new ResourceLocation(RuisPantry.MOD_ID, "graveyard/tombstone1");
			
	private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(PART_1, new BlockPos(0, 1, 0), PART_2, new BlockPos(16, 1, 0));
	//private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(PART_1, new BlockPos(0, 1, 0));
	
	//
	
	private static final String[] names = {"António", "José", "Carlos", "Pedro", "Artur", "Jeremias", "Joaquim", "Vicente", "Dolores", "Judite", "Gertrudes", "Maria", "Vanessa"};
			
	public static void start(TemplateManager manager, ChunkGenerator<?> generator, BlockPos pos, Rotation rot, List<StructurePiece> Pieces, Random rand)
	{
		int x = pos.getX();
		int z = pos.getZ();
		
		BlockPos rotationOffset = new BlockPos(0, 0, 0).rotate(rot);
		//BlockPos blockPos = rotationOffset.add(x, pos.getY(), z);
		BlockPos blockPos1 = rotationOffset.add(x, generator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG) - 2, z);
		BlockPos blockPos2 = rotationOffset.add(x + 6, generator.getHeight(x + 6, z, Heightmap.Type.WORLD_SURFACE_WG) - 3, z);
		Pieces.add(new GraveyardPieces.Piece(manager, PART_1, blockPos1, rot));
		Pieces.add(new GraveyardPieces.Piece(manager, PART_2, blockPos2, Rotation.randomRotation(rand)));
	}
	
	public static class Piece extends TemplateStructurePiece {
		private ResourceLocation resourceLocation;
		private Rotation rotation;

		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos,
				Rotation rotationIn) {
			super(FeatureInit.GRAVEYARD_PIECE, 0);
			this.resourceLocation = resourceLocationIn;
			BlockPos blockpos = GraveyardPieces.OFFSET.get(resourceLocation);
			this.templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
			this.rotation = rotationIn;
			this.setupPiece(templateManagerIn);
		}

		public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
			super(FeatureInit.GRAVEYARD_PIECE, tagCompound);
			this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
			this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
			this.setupPiece(templateManagerIn);
		}

		private void setupPiece(TemplateManager templateManager) {
			Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation)
					.setMirror(Mirror.NONE);
			this.setup(template, this.templatePosition, placementsettings);
		}

		@Override
		protected void readAdditional(CompoundNBT tagCompound) {
			super.readAdditional(tagCompound);
			tagCompound.putString("Template", this.resourceLocation.toString());
			tagCompound.putString("Rot", this.rotation.name());
		}

		@Override
		protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand,
				MutableBoundingBox sbb) {
			ITextComponent[] signText = new ITextComponent[]{new StringTextComponent("R.I.P."), new StringTextComponent(names[rand.nextInt(names.length)])};
			if ("wheat".equals(function)) {
				if(rand.nextInt(10) > 4)
				{
				worldIn.setBlockState(pos, Blocks.WHEAT.getDefaultState().with(BlockStateProperties.AGE_0_7, rand.nextInt(7)), 2);
				worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.FARMLAND.getDefaultState(), 2);
				worldIn.getBlockState(pos).updateNeighbors(worldIn, pos, 1);
				} else {
					worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
					worldIn.getBlockState(pos).updateNeighbors(worldIn, pos, 1);
				}
			}
			
			if ("flower".equals(function)) {
				if(rand.nextInt(10) < 5)
				{
				worldIn.setBlockState(pos, Blocks.RED_TULIP.getDefaultState(), 2);
				worldIn.getBlockState(pos).updateNeighbors(worldIn, pos, 1);
				} else {
					worldIn.setBlockState(pos, Blocks.WHITE_TULIP.getDefaultState(), 2);
					worldIn.getBlockState(pos).updateNeighbors(worldIn, pos, 1);
				}
			}
			
			if ("crain".equals(function)) {
				if(rand.nextInt(10) < 5)
				{
				worldIn.setBlockState(pos, Blocks.SKELETON_SKULL.getDefaultState().rotate(Rotation.randomRotation(rand)), 2);
				worldIn.getBlockState(pos).updateNeighbors(worldIn, pos, 1);
				} else {
					worldIn.setBlockState(pos, Blocks.WHITE_TULIP.getDefaultState(), 2);
					worldIn.getBlockState(pos).updateNeighbors(worldIn, pos, 1);
				}
			}
			
			if ("sign".equals(function))
			{
				SignTileEntity tileentity = (SignTileEntity) worldIn.getTileEntity(new BlockPos(pos.getX(), pos.getY() -1, pos.getZ()));
				
				if(tileentity instanceof SignTileEntity)
				{
					tileentity.setText(1, signText[0]);
					tileentity.setText(2, signText[1]);
				} else {
					worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), Blocks.AIR.getDefaultState(), 2);
				}
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
				worldIn.getBlockState(pos).updateNeighbors(worldIn, pos, 1);
			}
		}

		//create
		@Override
		public boolean create(IWorld worldIn, ChunkGenerator<?> generator, Random randomIn,
				MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPos) {
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation)
					.setMirror(Mirror.NONE);
			BlockPos blockpos = GraveyardPieces.OFFSET.get(this.resourceLocation);
			this.templatePosition.add(Template.transformedBlockPos(placementsettings,
			new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));

			return super.create(worldIn, generator, randomIn, structureBoundingBoxIn, chunkPos);
		}
	}
}
