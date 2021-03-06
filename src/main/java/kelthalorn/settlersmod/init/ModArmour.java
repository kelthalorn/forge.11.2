package kelthalorn.settlersmod.init;

import kelthalorn.settlersmod.SettlersMod;
import kelthalorn.settlersmod.Reference;
import kelthalorn.settlersmod.items.ItemModArmour;
import kelthalorn.settlersmod.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class handles all of our armour registration and render
 * @author CJMinecraft
 *
 */
public class ModArmour {
	
	/**
	 * The armour material
	 */
	public static ArmorMaterial tinMaterial = EnumHelper.addArmorMaterial("tin", Reference.MODID + ":tin", 15, new int[] {2,6,5,2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
	
	/**
	 * Each armour piece
	 */
	public static ItemArmor tinHelmet;
	public static ItemArmor tinChestplate;
	public static ItemArmor tinLeggings;
	public static ItemArmor tinBoots;
	
	/**
	 * Initializes our armour
	 */
	public static void init() {
		tinHelmet = new ItemModArmour(tinMaterial, 1, EntityEquipmentSlot.HEAD, "tin_helmet");
		tinChestplate = new ItemModArmour(tinMaterial, 1, EntityEquipmentSlot.CHEST, "tin_chestplate");
		tinLeggings = new ItemModArmour(tinMaterial, 2, EntityEquipmentSlot.LEGS, "tin_leggings");
		tinBoots = new ItemModArmour(tinMaterial, 1, EntityEquipmentSlot.FEET, "tin_boots");
	}
	
	/**
	 * Registers our armour
	 */
	public static void register() {
		registerItem(tinHelmet);
		registerItem(tinChestplate);
		registerItem(tinLeggings);
		registerItem(tinBoots);
	}
	
	/**
	 * Registers the render for the armour
	 */
	public static void registerRenders() {
		registerRender(tinHelmet);
		registerRender(tinChestplate);
		registerRender(tinLeggings);
		registerRender(tinBoots);
	}
	
	/**
	 * Registers a item and logs that it has been registered to the console
	 * @param item The item to register
	 */
	public static void registerItem(Item item) {
		item.setCreativeTab(SettlersMod.items);
		GameRegistry.register(item);
		Utils.getLogger().info("Registered item: " + item.getUnlocalizedName().substring(5));
	}
	
	/**
	 * Registers an item render and logs that is has been registered to the console
	 * @param item The item to register the render for
	 */
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Register render for " + item.getUnlocalizedName().substring(5));
	}

}
