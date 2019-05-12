package deltanedas.vbucks_mod;

import de.ellpeck.actuallyadditions.api.ActuallyAdditionsAPI;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.registries.GameData;

public class Recipes {
	public static void addSmelting(Block input, int inputCount, Item output, int outputCount, float xp) {
		Smelting.add(input, inputCount, output, outputCount, xp);
	}
	
	public static void addSmelting(Item input, int inputCount, Item output, int outputCount, float xp) {
		Smelting.add(input, inputCount, output, outputCount, xp);
	}
	
	public static void addShaped(Item output, int outputCount, Object... params) {
		ItemStack outputStack = new ItemStack(output, outputCount);
		ResourceLocation location = getNameForRecipe(outputStack);
		CraftingHelper.ShapedPrimer primer = CraftingHelper.parseShaped(params);
		ShapedRecipes recipe = new ShapedRecipes(output.getRegistryName().toString(), primer.width, primer.height, primer.input, outputStack);
		recipe.setRegistryName(location);
		GameData.register_impl(recipe);
	}
	
	public static void addShapeless(Item output, int outputCount, Object... input) {
		ItemStack outputStack = new ItemStack(output, outputCount);
		ResourceLocation location = getNameForRecipe(outputStack);
		ShapelessRecipes recipe = new ShapelessRecipes(location.getResourceDomain(), outputStack, buildInput(input));
		recipe.setRegistryName(location);
		GameData.register_impl(recipe);
	}
	
	public static void addCompress(Block output, Item inputs) {
		addShaped(Item.getItemFromBlock(output), 1, 
			"III",
			"III",
			"III",
			'I', new ItemStack(inputs, 1, 0)
		);
	}
	
	public static void addDecompress(Item outputs, Block input) {
		addShapeless(outputs, 9,
			new ItemStack(input, 1, 0)
		);
	}
	
	public static void addEmpowering(Item output, Item infused, Item input1, Item input2, Item input3, Item input4, int rf, int seconds) {
		ActuallyAdditionsAPI.addEmpowererRecipe(Ingredient.fromItem(infused),
			new ItemStack(output, 1, 0), 
			Ingredient.fromItem(input1),
			Ingredient.fromItem(input2),
			Ingredient.fromItem(input3),
			Ingredient.fromItem(input4),
			rf, seconds, new float[]{0F, 0F, 0F});
	}
	
	private static ResourceLocation getNameForRecipe(ItemStack output) {
		ModContainer activeContainer = Loader.instance().activeModContainer();
		ResourceLocation baseLoc = new ResourceLocation(activeContainer.getModId(), output.getItem().getRegistryName().getResourcePath());
		ResourceLocation recipeLoc = baseLoc;
		int index = 0;
		while (CraftingManager.REGISTRY.containsKey(recipeLoc)) {
			index++;
			recipeLoc = new ResourceLocation(activeContainer.getModId(), baseLoc.getResourcePath() + "_" + index);
		}
		return recipeLoc;
	}
	
	private static NonNullList<Ingredient> buildInput(Object[] input) {
		NonNullList<Ingredient> list = NonNullList.create();
		for (Object obj : input) {
			if (obj instanceof Ingredient) {
				list.add((Ingredient) obj);
			} else {
				Ingredient ingredient = CraftingHelper.getIngredient(obj);
				if (ingredient == null) {
					ingredient = Ingredient.EMPTY;
				}
				list.add(ingredient);
			}
		}
		return list;
	}
}
