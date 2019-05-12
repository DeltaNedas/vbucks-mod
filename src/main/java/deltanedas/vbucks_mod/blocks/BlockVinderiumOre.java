 package deltanedas.vbucks_mod.blocks;

import java.util.Random;

import deltanedas.vbucks_mod.init.InitItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockVinderiumOre extends BaseBlock {
	public BlockVinderiumOre() {
		super("vinderium_ore", Material.IRON, 0.0F);
		blockHardness = 10.0F;
		blockResistance = 5.0F;
		setHarvestLevel("Pickaxe", 3);
	}
	
	public int quantityDroppedWithBonus(int fortune, Random random) {
		return this.quantityDropped(random) + random.nextInt(fortune + 1);
	}
	
	public int quantityDropped(Random random) {
		return 2 + random.nextInt(2);
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return InitItems.vinderiumChunk;
	}
	
	public boolean canSilkHarvest() {
		return true;
	}
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		return 10 + RANDOM.nextInt(5);
	}
}
