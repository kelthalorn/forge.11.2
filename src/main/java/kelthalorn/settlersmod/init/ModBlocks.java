package kelthalorn.settlersmod.init;

import kelthalorn.settlersmod.SettlersMod;
import kelthalorn.settlersmod.Reference;
import kelthalorn.settlersmod.blocks.BlockBreaker;
import kelthalorn.settlersmod.blocks.BlockGamemodeDetector;
import kelthalorn.settlersmod.blocks.BlockMachineFrame;
import kelthalorn.settlersmod.blocks.BlockTinBlock;
import kelthalorn.settlersmod.blocks.BlockTinOre;
import kelthalorn.settlersmod.blocks.BlockTinSlabDouble;
import kelthalorn.settlersmod.blocks.BlockTinSlabHalf;
import kelthalorn.settlersmod.blocks.BlockTinStairs;
import kelthalorn.settlersmod.blocks.item.ItemBlockBreaker;
import kelthalorn.settlersmod.blocks.item.ItemBlockMeta;
import kelthalorn.settlersmod.handlers.EnumHandler;
import kelthalorn.settlersmod.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class handles the registration of our blocks and also the rendering of them
 * @author CJMinecraft
 *
 */
public class ModBlocks {

	/**
	 * State our blocks
	 */
	public static Block tinOre;
	public static Block tinBlock;
	public static Block breaker;
	public static Block gamemodeDetector;
	public static Block machineFrame;
	public static BlockTinSlabHalf tinSlabHalf;
	public static BlockTinSlabDouble tinSlabDouble;
	public static BlockTinStairs tinStairs;
	
	/**
	 * Initialize the blocks
	 */
	public static void init() {
		tinOre = new BlockTinOre("tin_ore", "tin_ore");
		breaker = new BlockBreaker("block_breaker");
		gamemodeDetector = new BlockGamemodeDetector("gamemode_detector");
		machineFrame = new BlockMachineFrame("machine_frame");
		tinBlock = new BlockTinBlock("tin_block");
		tinSlabHalf = new BlockTinSlabHalf("tin_slab_half");
		tinSlabDouble = new BlockTinSlabDouble("tin_slab_double");
		tinStairs = new BlockTinStairs("tin_stairs", tinBlock.getDefaultState());
	}
	
	/**
	 * Register the blocks
	 */
	public static void register() {
		registerBlock(tinOre, new ItemBlockMeta(tinOre)); //Says that the block uses the ItemBlockMeta as the item block
		registerBlock(breaker, new ItemBlockBreaker(breaker));
		registerBlock(gamemodeDetector);
		registerBlock(machineFrame, new ItemBlockMeta(machineFrame));
		registerBlock(tinBlock);
		registerBlock(tinSlabHalf, new ItemSlab(tinSlabHalf, tinSlabHalf, tinSlabDouble));
		GameRegistry.register(tinSlabDouble); //Doesn't need an item
		registerBlock(tinStairs);
	}
	
	/**
	 * Register the renders for the block
	 */
	public static void registerRenders() {
		for(int i = 0; i < EnumHandler.OreType.values().length; i++) {
			registerRender(tinOre, i, "tin_ore_" + EnumHandler.OreType.values()[i].getName());
		}
		for(int i = 0; i < EnumHandler.ChipTypes.values().length; i++) {
			registerRender(breaker, i, "block_breaker_" + EnumHandler.ChipTypes.values()[i].getName());
			registerRender(machineFrame, i, "machine_frame_" + EnumHandler.ChipTypes.values()[i].getName());
		}
		registerRender(gamemodeDetector);
		registerRender(tinBlock);
		registerRender(tinSlabHalf);
		registerRender(tinStairs);
	}
	
	/**
	 * Registers the block
	 * @param block The block to register
	 */
	public static void registerBlock(Block block) {
		block.setCreativeTab(SettlersMod.blocks);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Registers the block with a custom {@link ItemBlock}
	 * @param block The block
	 * @param itemBlock The {@link ItemBlock}
	 */
	public static void registerBlock(Block block, ItemBlock itemBlock) {
		block.setCreativeTab(SettlersMod.blocks);
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Registers the blocks renders
	 * @param block The block
	 */
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered render for " + block.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Registers the blocks renders even if it has meta data
	 * @param block The block
	 * @param meta The blocks meta data
	 * @param fileName The file name
	 */
	public static void registerRender(Block block, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
		Utils.getLogger().info("Register render for " + block.getUnlocalizedName().substring(5));
	}
	
}
