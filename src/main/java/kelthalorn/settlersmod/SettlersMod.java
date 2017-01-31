package kelthalorn.settlersmod;

import kelthalorn.settlersmod.creativetabs.TabSettlersMod;
import kelthalorn.settlersmod.creativetabs.TabSettlersModItems;
import kelthalorn.settlersmod.handlers.AchievementHandler;
import kelthalorn.settlersmod.handlers.FuelHandler;
import kelthalorn.settlersmod.handlers.OreDictionaryHandler;
import kelthalorn.settlersmod.handlers.RecipeHandler;
import kelthalorn.settlersmod.init.ModArmour;
import kelthalorn.settlersmod.init.ModBlocks;
import kelthalorn.settlersmod.init.ModItems;
import kelthalorn.settlersmod.init.ModTools;
import kelthalorn.settlersmod.proxy.CommonProxy;
import kelthalorn.settlersmod.util.Utils;
import kelthalorn.settlersmod.worldgen.OreGen;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;
import java.io.FileInputStream;

/**
 * The main class. This class registers the blocks and items and makes sure
 * everything our mod does works
 * 
 * @author CJMinecraft
 */
@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class SettlersMod {

	/**
	 * Our creative tabs
	 */
	public static final CreativeTabs blocks = new TabSettlersMod();
	public static final CreativeTabs items = new TabSettlersModItems();

	/**
	 * Handles the events
	 */
	kelthalorn.settlersmod.handlers.EventHandler eventHandler = new kelthalorn.settlersmod.handlers.EventHandler();

	/**
	 * Used for GUI stuff
	 */
	@Mod.Instance(Reference.MODID)
	public static SettlersMod instance;

	/**
	 * Proxy so that we register the correct things on server and client side.
	 * Client side handles the model bakery
	 * Server side handles tile entities and world generation
	 */
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	/**
	 * Called first. Should initialize everything and register everything
	 * @param event The event (you probably wont use this)
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModTools.init();
		ModArmour.init();
		ModBlocks.init();
		ModItems.register();
		ModTools.register();
		ModArmour.register();
		ModBlocks.register();

		proxy.registerRenders();
		proxy.registerTileEntities();

		AchievementHandler.registerAchievements();
	}

	/**
	 * Called to register recipes and events
	 * @param event The event (you probably wont use this)
	 */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		GameRegistry.registerFuelHandler(new FuelHandler());
		OreDictionaryHandler.registerOreDictionary();
		proxy.registerModelBakeryStuff();
		eventHandler.registerEvents();
		RecipeHandler.registerCraftingRecipes();
		RecipeHandler.registerFurnaceRecipes();
	}

	/**
	 * Called after everything. Should be used for mod integration
	 * @param event The event (you probably wont use this)
	 */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		File dir = Minecraft.getMinecraft().mcDataDir;

		try {
            File file = new File(dir.getCanonicalPath() + "/schematics/test.schematic");
            try {
                NBTTagCompound nbt = CompressedStreamTools.read(file);
            } catch (final Exception ex) {
                Utils.getLogger().info("Failed compressed read, trying normal read..." + ex);
            }
        } catch (final Exception ex) {}

		//readSchematicFile.readFile(in);
	}

}
