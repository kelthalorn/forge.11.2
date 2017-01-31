package kelthalorn.settlersmod.items;

import kelthalorn.settlersmod.Reference;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ResourceLocation;

/**
 * A pickaxe
 * @author CJMinecraft
 *
 */
public class ItemModPickaxe extends ItemPickaxe {

	public ItemModPickaxe(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
	}

}
