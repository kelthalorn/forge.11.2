package kelthalorn.settlersmod.items;

import kelthalorn.settlersmod.Reference;
import net.minecraft.item.ItemSpade;
import net.minecraft.util.ResourceLocation;

/**
 * A shovel
 * @author CJMinecraft
 *
 */
public class ItemModShovel extends ItemSpade {

	public ItemModShovel(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
	}

}
