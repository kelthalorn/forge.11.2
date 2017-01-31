package kelthalorn.settlersmod.proxy;

import kelthalorn.settlersmod.SettlersMod;
import kelthalorn.settlersmod.Reference;
import kelthalorn.settlersmod.client.gui.GuiHandler;
import kelthalorn.settlersmod.init.ModArmour;
import kelthalorn.settlersmod.init.ModBlocks;
import kelthalorn.settlersmod.init.ModItems;
import kelthalorn.settlersmod.init.ModTools;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * This class handles everything on the client side like the {@link ModelBakery} and the render of items
 * @author CJMinecraft
 *
 */
public class ClientProxy extends CommonProxy {
	
	@Override
	public void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(SettlersMod.instance, new GuiHandler());
	}
	
	/**
	 * Registers the renders
	 */
	@Override
	public void registerRenders() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		ModTools.registerRenders();
		ModArmour.registerRenders();
	}
	
	/**
	 * Adds the item variant renders
	 */
	@Override
	public void registerModelBakeryStuff() {
		ModelBakery.registerItemVariants(ModItems.chip, new ResourceLocation(Reference.MODID, "chip_basic"), new ResourceLocation(Reference.MODID, "chip_advanced"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.breaker), new ResourceLocation(Reference.MODID, "block_breaker_basic"), new ResourceLocation(Reference.MODID, "block_breaker_advanced"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.tinOre), new ResourceLocation(Reference.MODID, "tin_ore_overworld"), new ResourceLocation(Reference.MODID, "tin_ore_nether"), new ResourceLocation(Reference.MODID, "tin_ore_end"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.machineFrame), new ResourceLocation(Reference.MODID, "machine_frame_basic"), new ResourceLocation(Reference.MODID, "machine_frame_advanced"));
	}

}
