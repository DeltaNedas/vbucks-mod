package deltanedas.vbucks_mod;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import deltanedas.vbucks_mod.blocks.BlockVBuck;
import deltanedas.vbucks_mod.init.InitBlocks;
import deltanedas.vbucks_mod.init.InitConfig;
import deltanedas.vbucks_mod.init.InitItems;
import deltanedas.vbucks_mod.init.InitRecipes;
import deltanedas.vbucks_mod.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
	modid = Constants.MOD_ID,
	name = Constants.MOD_NAME,
	version = Constants.MOD_VERSION,
	acceptedMinecraftVersions = Constants.MC_VERSIONS
)
public class VBucksMod {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static Block vbuck = new BlockVBuck("vbuck", 0.0F);
	
	public static final CreativeTabs modTab = (new CreativeTabs("tabVBucksMod") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(vbuck);
		}
	});	
	
	@Instance
	public static VBucksMod instance;
	
	@SidedProxy(
		clientSide = Constants.CLIENT_PROXY,
		serverSide = Constants.COMMON_PROXY
	)
	public static CommonProxy proxy;
	public static Logger logger;
	public static Level level = Level.INFO;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		vbuck.setCreativeTab(modTab);
		new InitConfig();							// Does config stuff
		new InitItems();							// Creates the Items
		new InitBlocks();							// Creates the Blocks
		
		// Generate the Vinderium Ores
		GameRegistry.registerWorldGenerator(new OreGen(), 10);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		new InitRecipes();						// Sets the smelting recipes
	}
	
	public static void log(String text) {
		if (logger != null) {
			logger.log(level, text);
		}
	}
}
