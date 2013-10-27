package in.nikitapek.forge.tts.client.listener;

import in.nikitapek.forge.tts.TextToSpeech;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class ClientChatEventListener {
    @ForgeSubscribe
    public void onClientChatEvent(ClientChatReceivedEvent event){
        new TextToSpeech().speakText(event.message, TextToSpeech.getMaleVoice());
    }
}
