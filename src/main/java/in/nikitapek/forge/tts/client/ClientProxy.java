package in.nikitapek.forge.tts.client;

import in.nikitapek.forge.tts.common.CommonProxy;
import in.nikitapek.forge.tts.client.listener.ClientChatEventListener;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers() {
    }

    @Override
    public void registerEventHandlers() {
        MinecraftForge.EVENT_BUS.register(new ClientChatEventListener());
    }
}
