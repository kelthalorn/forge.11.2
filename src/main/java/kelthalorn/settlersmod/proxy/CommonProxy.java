package kelthalorn.settlersmod.proxy;

import kelthalorn.settlersmod.Reference;
import kelthalorn.settlersmod.tileentity.TileEntityBlockBreaker;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class handles everything on the server side
 * @author CJMinecraft
 *
 */
public class CommonProxy {
	
	/**
	 * Called on the initialization phase of the game loading
	 */
	public void init() {
		//MOVED THESE TO MAIN CLASS - FIX FOR MC 1.11.2
	}
	
	/**
	 * Registers our tile entities
	 */
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityBlockBreaker.class, Reference.MODID + ":block_breaker");
	}
	
	/**
	 * Registers the renders - refer to the {@link ClientProxy}
	 */
	public void registerRenders() {
		
	}
	
	public void registerModelBakeryStuff() {
		
	}

}
