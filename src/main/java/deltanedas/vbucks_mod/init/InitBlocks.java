package deltanedas.vbucks_mod.init;

import deltanedas.vbucks_mod.blocks.BaseBlock;
import deltanedas.vbucks_mod.blocks.BlockVBuck;
import deltanedas.vbucks_mod.blocks.BlockVinderiumOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class InitBlocks {
	public static Block vbuckGlowing;
	public static Block vbuckShardBlock;
	public static Block vbuckShardRadiantBlock;
	public static Block vbuckShardWhiteBlock;
	public static Block vinderiumOre;
	public static Block vinderiumBlock;
	
	public InitBlocks() {
		vbuckGlowing = new BlockVBuck("vbuck_glowing", 10 / 16.0F);
		vbuckShardBlock = new BaseBlock("vbuck_shard_block", Material.IRON, 0.0F);
		vbuckShardRadiantBlock = new BaseBlock("vbuck_shard_radiant_block", Material.GLASS, 1.0F);
		vbuckShardWhiteBlock = new BaseBlock("vbuck_shard_white_block", Material.IRON, 9 / 16.0F);
		vinderiumOre = new BlockVinderiumOre();
		vinderiumBlock = new BaseBlock("vinderium_block", Material.IRON, 0.0F);
	}
}
