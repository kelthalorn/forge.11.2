package kelthalorn.settlersmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class handles all of our constants about the mod and its details
 * 
 * @author CJMinecraft
 *
 */
public class Reference {

	/**
	 * Generic modid used for models and registering textures
	 */
	public static final String MODID = "settlersmod";
	/**
	 * The mod's name
	 */
	public static final String NAME = "SettlersMod";
	/**
	 * Current version TODO Update version
	 */
	public static final String VERSION = "0.0.1";
	/**
	 * Where the server proxy is found
	 */
	public static final String SERVER_PROXY_CLASS = "kelthalorn.settlersmod.proxy.CommonProxy";
	/**
	 * Where the client proxy is found
	 */
	public static final String CLIENT_PROXY_CLASS = "kelthalorn.settlersmod.proxy.ClientProxy";

}
