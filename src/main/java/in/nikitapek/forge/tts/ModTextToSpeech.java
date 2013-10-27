package in.nikitapek.forge.tts;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import in.nikitapek.forge.tts.common.CommonProxy;

import java.util.logging.Logger;

@Mod(modid=Reference.ModID, name=Reference.ModName, version=Reference.ModVersion)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ModTextToSpeech {
    public static Logger logger = Logger.getLogger(Reference.ModID);

    // The instance of the mod that Forge uses.
    @Instance(value=Reference.ModID)
    public static ModTextToSpeech instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide=Reference.ClientProxyClass, serverSide=Reference.ServerProxyClass)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.registerRenderers();
        proxy.registerEventHandlers();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}

