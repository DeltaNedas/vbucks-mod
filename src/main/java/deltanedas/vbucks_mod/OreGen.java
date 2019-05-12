package deltanedas.vbucks_mod;

import java.util.Random;

import com.google.common.base.Predicate;

import deltanedas.vbucks_mod.init.InitBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {
	public void generate(Random random,									//Random
												int chunkX,											//X Chunk
												int chunkY,											//Y (Z in 3D) Chunk
												World worldIn,									//World generating in
												IChunkGenerator chunkGenerator,	//Chunk generator
												IChunkProvider chunkProvider) {	//Chunk provider
		if (worldIn.provider.getDimension() == 0) {
			runGenerator(InitBlocks.vinderiumOre.getDefaultState(), 11, 1, 13, 13, BlockMatcher.forBlock(Blocks.STONE), worldIn, random, chunkX, chunkY);
		}
	}
	
	void runGenerator(IBlockState block,							// Ore to spawn
										int amount,											// How many ores to spawn
										int spawnTimes,									// How many times it will try
										int minHeight,									// Min Height
										int maxHeight,									// Max Height
										Predicate<IBlockState> replacee,// Block to replace
										World worldIn,									// World generating in
										Random random,										// Random
										int chunkX,											// X Chunk
										int chunkY) {										// Y (Z in 3D) Chunk
		WorldGenMinable generator = new WorldGenMinable(block, amount, replacee);
		int heightdiff = maxHeight - minHeight + 1;
		for (int i = 0; i < spawnTimes; i++){
			int x = chunkX * 16 +random.nextInt(16);
			int y = minHeight + random.nextInt(heightdiff);
			int z = chunkY * 16 + random.nextInt(16);
			generator.generate(worldIn, random, new BlockPos(x, y, z));
		}
	}
}
