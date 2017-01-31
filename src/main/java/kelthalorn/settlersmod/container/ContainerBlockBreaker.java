package kelthalorn.settlersmod.container;

import kelthalorn.settlersmod.container.slots.SlotEnchantedBook;
import kelthalorn.settlersmod.tileentity.TileEntityBlockBreaker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Container which says where the slots are for the inventory to handle it
 * @author CJMinecraft
 *
 */
public class ContainerBlockBreaker extends Container {

	/**
	 * This tile entity and the item handler (inventory)
	 */
	private TileEntityBlockBreaker te;
	private IItemHandler handler;

	/**
	 * Tells the container where the slots are
	 * @param playerInv The player's inventory
	 * @param te The tile entity
	 */
	public ContainerBlockBreaker(IInventory playerInv, TileEntityBlockBreaker te) {
		this.te = te;
		this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null); //Gets the inventory from our tile entity

		//Our tile entity slots
		this.addSlotToContainer(new SlotItemHandler(handler, 0, 11, 98));
		this.addSlotToContainer(new SlotItemHandler(handler, 1, 29, 98));
		this.addSlotToContainer(new SlotItemHandler(handler, 2, 47, 98));
		this.addSlotToContainer(new SlotItemHandler(handler, 3, 65, 98));
		this.addSlotToContainer(new SlotItemHandler(handler, 4, 83, 98));
		this.addSlotToContainer(new SlotItemHandler(handler, 5, 101, 98));

		this.addSlotToContainer(new SlotItemHandler(handler, 6, 11, 116));
		this.addSlotToContainer(new SlotItemHandler(handler, 7, 29, 116));
		this.addSlotToContainer(new SlotItemHandler(handler, 8, 47, 116));
		this.addSlotToContainer(new SlotItemHandler(handler, 9, 65, 116));
		this.addSlotToContainer(new SlotItemHandler(handler, 10, 83, 116));
		this.addSlotToContainer(new SlotItemHandler(handler, 11, 101, 116));

		this.addSlotToContainer(new SlotItemHandler(handler, 12, 11, 134));
		this.addSlotToContainer(new SlotItemHandler(handler, 13, 29, 134));
		this.addSlotToContainer(new SlotItemHandler(handler, 14, 47, 134));
		this.addSlotToContainer(new SlotItemHandler(handler, 15, 65, 134));
		this.addSlotToContainer(new SlotItemHandler(handler, 16, 83, 134));
		this.addSlotToContainer(new SlotItemHandler(handler, 17, 101, 134));

		this.addSlotToContainer(new SlotItemHandler(handler, 18, 11, 152));
		this.addSlotToContainer(new SlotItemHandler(handler, 19, 29, 152));
		this.addSlotToContainer(new SlotItemHandler(handler, 20, 47, 152));
		this.addSlotToContainer(new SlotItemHandler(handler, 21, 65, 152));
		this.addSlotToContainer(new SlotItemHandler(handler, 22, 83, 152));
		this.addSlotToContainer(new SlotItemHandler(handler, 23, 101, 152));

		//The player's inventory slots
		int xPos = 11; //The x position of the top left player inventory slot on our texture
		int yPos = 176; //The y position of the top left player inventory slot on our texture

		//Player slots
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
			}
		}

		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, xPos + x * 18, yPos + 58));
		}
	}

	/**
	 * Checks that the player can put items in and out of the container
	 */
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.te.isUsableByPlayer(player);
	}

	/**
	 * Called when the player presses shift and takes an item out of the container
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
	    ItemStack previous = ItemStack.EMPTY;
	    Slot slot = this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (fromSlot < this.handler.getSlots()) {
	            // From the block breaker inventory to player's inventory
	            if (!this.mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, true))
	                return ItemStack.EMPTY;
	        } else {

	            if (!this.mergeItemStack(current, 0, handler.getSlots(), false))
	                return ItemStack.EMPTY;
	        }

	        if (current.getCount() == 0) //Use func_190916_E() instead of stackSize 1.11 only 1.11.2 use getCount()
	            slot.putStack(ItemStack.EMPTY); //Use ItemStack.field_190927_a instead of (ItemStack)null for a blank item stack. In 1.11.2 use ItemStack.EMPTY
	        else
	            slot.onSlotChanged();

	        if (current.getCount() == previous.getCount())
	            return null;
	        slot.onTake(playerIn, current);
	    }
	    return previous;
	}

}
