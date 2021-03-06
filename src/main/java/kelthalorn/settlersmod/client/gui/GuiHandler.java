package kelthalorn.settlersmod.client.gui;

import kelthalorn.settlersmod.container.ContainerBlockBreaker;
import kelthalorn.settlersmod.tileentity.TileEntityBlockBreaker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Handles all of the gui's
 * @author CJMinecraft
 *
 */
public class GuiHandler implements IGuiHandler {

	/**
	 * Each gui needs an ID
	 */
	public static final int BLOCK_BREAKER = 0;
	
	/**
	 * Should return the container for that gui. This is called server side because servers handle items in guis
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == BLOCK_BREAKER) {
			return new ContainerBlockBreaker(player.inventory, (TileEntityBlockBreaker) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

	/**
	 * Should return the actual gui. This is called client side as thats where guis are rendered
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == BLOCK_BREAKER) {
			return new GuiBlockBreaker(player.inventory, (TileEntityBlockBreaker) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

}
