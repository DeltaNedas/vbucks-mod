package deltanedas.vbucks_mod.items;

import deltanedas.vbucks_mod.BaseModel;
import deltanedas.vbucks_mod.VBucksMod;
import net.minecraft.item.Item;

public class BaseItem extends Item implements BaseModel {
	public BaseItem(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(VBucksMod.modTab);
		
		VBucksMod.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		VBucksMod.proxy.registerItemRender(this, 0);
	}
}
