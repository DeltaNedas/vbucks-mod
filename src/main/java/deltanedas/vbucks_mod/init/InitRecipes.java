package deltanedas.vbucks_mod.init;

import deltanedas.vbucks_mod.Recipes;
import deltanedas.vbucks_mod.VBucksMod;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InitRecipes {
	public InitRecipes() {
		Recipes.addSmelting(InitBlocks.vinderiumOre, 1, InitItems.vinderiumChunk, 1, 5);
		if (!InitConfig.vbuckPackIntegration) { // If it is standalone
			Recipes.addSmelting(InitBlocks.vinderiumBlock, 1, InitItems.vbuckShard, 1, 5);
		} else if (InitItems.Loaded(InitItems.deps)) { // V-Buck Pack!!!! :D
			Recipes.addShaped(InitItems.mechanicalCore, 8,
				"ABC",
				"DVE",
				"FGH",
				'V', new ItemStack(InitBlocks.vinderiumBlock, 1, 0),
				'A', new ItemStack(InitItems.getModItem("galacticraftcore:machine_tiered"), 1, 4),
				'B', new ItemStack(InitItems.getModItem("galacticraftcore:machine_tiered"), 1, 12),
				'C', new ItemStack(InitItems.getModItem("enderio:block_sag_mill"), 1, 0),
				'D', new ItemStack(InitItems.getModItem("rftools:scanner"), 1, 0),
				'E', new ItemStack(InitItems.getModItem("enderio:block_enhanced_sag_mill"), 1, 0),
				'F', new ItemStack(InitItems.getModItem("rftools:builder"), 1, 0),
				'G', new ItemStack(InitItems.getModItem("mekanism:machineblock"), 1, 7),
				'H', new ItemStack(InitItems.getModItem("mekanism:machineblock"), 1, 5)
			);
			Recipes.addShaped(InitItems.energeticCore, 8,
				"ABC",
				"DVE",
				"FGH",
				'V', new ItemStack(InitBlocks.vinderiumBlock, 1, 0),
				'A', new ItemStack(InitItems.getModItem("galacticraftcore:machine_tiered"), 1, 4),
				'B', new ItemStack(InitItems.getModItem("galacticraftcore:machine_tiered"), 1, 12),
				'C', new ItemStack(InitItems.getModItem("enderio:block_cap_bank"), 1, 2),
				'D', new ItemStack(InitItems.getModItem("rftools:powercell_advanced"), 1, 0),
				'E', new ItemStack(InitItems.getModItem("enderio:block_cap_bank"), 1, 3),
				'F', new ItemStack(InitItems.getModItem("rftools:powercell"), 1, 0),
				'G', new ItemStack(InitItems.getModItem("mekanism:energycube"), 1, 0),
				'H', new ItemStack(InitItems.getModItem("mekanism:energytablet"), 1, 0)
			);
			Recipes.addShaped(InitItems.materialisticCore, 4,
				" A ",
				"BVC",
				" D ",
				'V', new ItemStack(InitBlocks.vinderiumBlock, 1, 0),
				'A', new ItemStack(InitItems.getModItem("enderio:block_alloy"), 1, 9),
				'B', new ItemStack(InitItems.getModItem("enderio:block_alloy"), 1, 7),
				'C', new ItemStack(InitItems.getModItem("mekanism:basicblock"), 1, 5),
				'D', new ItemStack(InitItems.getModItem("mekanism:basicblock"), 1, 2)
			);
			Recipes.addShaped(InitItems.arcaneCore, 4,
				" A ",
				"BVC",
				" D ",
				'V', new ItemStack(InitBlocks.vinderiumBlock, 1, 0),
				'A', new ItemStack(InitItems.getModItem("wizardry:mana_battery"), 1, 0),
				'B', new ItemStack(InitItems.getModItem("psi:cad_assembly"), 1, 1),
				'C', new ItemStack(InitItems.getModItem("psi:spell_drive"), 1, 0),
				'D', new ItemStack(InitItems.getModItem("wizardry:halo_fake"), 1, 0)
			);
			
			Recipes.addEmpowering(InitItems.vbuckShard,
				InitItems.vinderiumShard,
				InitItems.mechanicalCore,
				InitItems.energeticCore,
				InitItems.materialisticCore,
				InitItems.arcaneCore,
				80000,
				300
			);
		}
		Recipes.addShaped(Item.getItemFromBlock(VBucksMod.vbuck), 1,
			"RSR",
			"SVS",
			"SRS",
			'R', new ItemStack(InitItems.vbuckShardRadiant, 1, 0),
			'S', new ItemStack(InitItems.vbuckShard, 1, 0),
			'V', new ItemStack(InitItems.vbuckCore, 1, 0)
		);
		Recipes.addShaped(InitItems.vbuckCore, 1,
			"W W",
			"WRW",
			" W ",
			'W', new ItemStack(InitItems.vbuckShardWhite, 1, 0),
			'R', new ItemStack(InitItems.vbuckShardRadiant, 1, 0)
		);
		Recipes.addShapeless(Item.getItemFromBlock(InitBlocks.vbuckGlowing), 1,
			new ItemStack(VBucksMod.vbuck, 1, 0),
			new ItemStack(InitItems.vbuckShardRadiant, 1, 0)
		);
		Recipes.addShaped(InitItems.vbuckShardRadiant, 1,
			"GQG",
			"QWQ",
			"GQG",
			'G', new ItemStack(Items.GLOWSTONE_DUST),
			'Q', new ItemStack(Items.QUARTZ),
			'W', new ItemStack(InitItems.vbuckShardWhite)
		);
		Recipes.addShaped(InitItems.vbuckShardWhite, 1,
			" Q ",
			"QSQ",
			" Q ",
			'Q', new ItemStack(Items.QUARTZ),
			'S', new ItemStack(InitItems.vbuckShard)
		);
		// Compressing recipes
		Recipes.addCompress(InitBlocks.vbuckShardBlock, InitItems.vbuckShard);
		Recipes.addCompress(InitBlocks.vbuckShardRadiantBlock, InitItems.vbuckShardRadiant);
		Recipes.addCompress(InitBlocks.vbuckShardWhiteBlock, InitItems.vbuckShardWhite);
		Recipes.addCompress(InitBlocks.vinderiumBlock, InitItems.vinderiumChunk);
		// Decompressing recipes
		Recipes.addDecompress(InitItems.vbuckShard, InitBlocks.vbuckShardBlock);
		Recipes.addDecompress(InitItems.vbuckShardRadiant, InitBlocks.vbuckShardRadiantBlock);
		Recipes.addDecompress(InitItems.vbuckShardWhite, InitBlocks.vbuckShardWhiteBlock);
		Recipes.addDecompress(InitItems.vinderiumChunk, InitBlocks.vinderiumBlock);
	}
}
