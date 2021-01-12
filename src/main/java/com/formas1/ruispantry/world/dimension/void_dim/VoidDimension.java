package com.formas1.ruispantry.world.dimension.void_dim;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

public class VoidDimension extends Dimension
{

	public VoidDimension(World world, DimensionType type)
	{
		super(world, type, 0.0F);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator()
	{
		return new VoidChunkGenerator(world, new VoidBiomeProvider(), new VoidGenSettings());
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid)
	{
		return null;
	}

	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid)
	{
		return null;
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks)
	{
		/*int j = 6000;
		float f1 = (j + partialTicks) / 24000.0f - 0.25f;
		if (f1 < 0.0f) {
			f1 += 1.0f;
		}

		if (f1 > 1.0f) {
			f1 -= 1.0f;
		}

		float f2 = f1;
		f1 = 1.0f - (float) ((Math.cos(f1 * Math.PI) + 1.0d) / 2.0d);
		f1 = f2 + (f1 - f2) / 3.0f;
		return f1;*/
		double d0 = MathHelper.frac((double)worldTime / 24000.0D - 0.25D);
	    double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
	    return (float)(d0 * 2.0D + d1) / 3.0F;
	}

	@Override
	public boolean isSurfaceWorld()
	{
		return false;
	}

	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks)
	{
		float f = MathHelper.cos(celestialAngle * ((float)Math.PI * 2F)) * 2.0F + 0.5F;
	    f = MathHelper.clamp(f, 0.0F, 1.0F);
	    float f1 = 1.0F;
	    float f2 = 0.82352941F;
	    float f3 = 0.77254901F;
	    f1 = f1 * (f * 0.94F + 0.06F);
	    f2 = f2 * (f * 0.94F + 0.06F);
	    f3 = f3 * (f * 0.91F + 0.09F);
	    return new Vec3d((double)f1, (double)f2, (double)f3);
	}

	@Override
	public boolean canRespawnHere()
	{
		return true;
	}

	@Override
	public boolean doesXZShowFog(int x, int z)
	{
		return false;
	}
	
	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos)
	{
		return SleepResult.ALLOW;
	}
	
	@Override
	public int getActualHeight()
	{
		return 256;
	}

}
