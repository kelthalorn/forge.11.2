package kelthalorn.settlersmod.handlers;

import kelthalorn.settlersmod.init.ModBlocks;
import kelthalorn.settlersmod.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * This class handles the registration of our ores to the {@link OreDictionary}
 * @author CJMinecraft
 *
 */
public class OreDictionaryHandler {
	
	/**
	 * Register the ores
	 */
	public static void registerOreDictionary() {
		OreDictionary.registerOre("oreTin", ModBlocks.tinOre);
		OreDictionary.registerOre("ingotTin", ModItems.tinIngot);
		OreDictionary.registerOre("nuggetTin", ModItems.tinNugget);
		OreDictionary.registerOre("blockTin", ModBlocks.tinBlock);
		OreDictionary.registerOre("chipBasic", new ItemStack(ModItems.chip, 1, 0)); //Basic Chip
		OreDictionary.registerOre("chipAdvanced", new ItemStack(ModItems.chip, 1, 1)); //Advanced Chip
	}

}
