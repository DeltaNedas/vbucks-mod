package deltanedas.vbucks_mod.init;

import deltanedas.vbucks_mod.items.BaseItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class InitItems {
	public static Item vbuckCore;
	public static Item vbuckShard;
	public static Item vbuckShardRadiant;
	public static Item vbuckShardWhite;
	public static Item vinderiumChunk;
	public static Item mechanicalCore;
	public static Item energeticCore;
	public static Item materialisticCore;
	public static Item arcaneCore;
	
	public static boolean Loaded(String[] mods) {
		boolean loaded = true;
		for (int i = 1; i == mods.length; i++) {
			if (!Loader.isModLoaded(mods[i])) {
				loaded = false;
			}
		}
		return loaded;
	}

	public static String[] deps = { //V-Buck Pack integration dependencies
		"enderio",
		"mekanism",
		"galacticraftcore",
		"rftools",
		"wizardry",
		"psi"
	};
	
	public InitItems() {
		vbuckCore = new BaseItem("vbuck_core");
		vbuckShard = new BaseItem("vbuck_shard");
		vbuckShardRadiant = new BaseItem("vbuck_shard_radiant");
		vbuckShardWhite = new BaseItem("vbuck_shard_white");
		vinderiumChunk = new BaseItem("vinderium_chunk");
		if (InitConfig.vbuckPackIntegration) { //V-Buck Pack stuff
			mechanicalCore = new BaseItem("mechanical_core");
			energeticCore = new BaseItem("energetic_core");
			materialisticCore = new BaseItem("materialistic_core");
			arcaneCore = new BaseItem("arcane_core");
		}
	}
	
	public static Item getModItem(String name) {
		return ForgeRegistries.ITEMS.getValue(new ResourceLocation(name));
	}
}
