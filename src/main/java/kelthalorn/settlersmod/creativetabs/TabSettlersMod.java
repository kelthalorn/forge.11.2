package kelthalorn.settlersmod.creativetabs;

import kelthalorn.settlersmod.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * The creative tab for blocks from our mod
 * @author CJMinecraft
 *
 */
public class TabSettlersMod extends CreativeTabs {

	/**
	 * Just says the unlocalized name of our creative tab
	 */
	public TabSettlersMod() {
		super("settlersmod_blocks");
	}

	/**
	 * Gets the item that will appear as the tabs icon
	 */
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Blocks.COMMAND_BLOCK);
	}

}
