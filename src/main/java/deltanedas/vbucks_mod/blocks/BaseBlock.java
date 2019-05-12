package deltanedas.vbucks_mod.blocks;

import deltanedas.vbucks_mod.BaseModel;
import deltanedas.vbucks_mod.VBucksMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BaseBlock extends Block implements BaseModel {
	public BaseBlock(String name, Material mat, float light) {
		super(mat);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(VBucksMod.modTab);
		setLightLevel(light);
		blockHardness = 5.0F;
		blockResistance = 15.0F;
		setHarvestLevel("Pickaxe", 3);
		
		VBucksMod.BLOCKS.add(this);
		VBucksMod.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() {
		VBucksMod.proxy.registerItemRender(Item.getItemFromBlock(this), 0);
	}
}
