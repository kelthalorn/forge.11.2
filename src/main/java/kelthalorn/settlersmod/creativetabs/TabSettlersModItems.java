package kelthalorn.settlersmod.creativetabs;

import kelthalorn.settlersmod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * The creative tab for items from our mod
 * @author CJMinecraft
 *
 */
public class TabSettlersModItems extends CreativeTabs {

	/**
	 * Just says the unlocalized name of our creative tab
	 */
	public TabSettlersModItems() {
		super("settlersmod_items");
	}

	/**
	 * Gets the item that will appear as the tabs icon
	 */
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.tinIngot);
	}

}
