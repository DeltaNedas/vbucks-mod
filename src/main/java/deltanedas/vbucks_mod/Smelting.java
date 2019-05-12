package deltanedas.vbucks_mod;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class Smelting {
	public static void add(Item input, int inputCount, Item output, int outputCount, float xp) {
		FurnaceRecipes.instance().addSmeltingRecipe(
			new ItemStack(
				input,
				inputCount),
			new ItemStack(
				output,
				outputCount),
			xp);
	}
	
	public static void add(Block input, int inputCount, Item output, int outputCount, float xp) {
		FurnaceRecipes.instance().addSmeltingRecipe(
			new ItemStack(
				input,
				inputCount),
			new ItemStack(
				output,
				outputCount),
			xp);
	}
}