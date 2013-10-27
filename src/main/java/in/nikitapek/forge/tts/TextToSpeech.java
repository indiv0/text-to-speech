package in.nikitapek.forge.tts;

// Import freeTTS for TTS capability
import com.sun.speech.freetts.*;
import net.minecraft.client.Minecraft;

import java.util.logging.Level;

public class TextToSpeech {
    // This stores the voice to be used and its properties
    private Voice voice = null;
    // This stores the text to be read
    private String text = "";

    // Define a TextReader class to use as a thread to playback the sound
    private class TextReader implements Runnable {
        public void run() {
            try {
                // Allocate any required data for the voice
                voice.allocate();

                // This part actually reads the text
                voice.startBatch();
                voice.setVolume(Minecraft.getMinecraft().gameSettings.soundVolume);
                voice.speak(text);
                voice.endBatch();

                // Deallocate the data
                voice.deallocate();
            } catch (Exception e) { }
        }
    }

    // Gets a male voice to use for playback
    public static Voice getMaleVoice() {
        // TODO: Make this interchangeable
        // This sets the voice to use for playback
        // There are three options: "kevin" (low quality), "kevin16" (medium quality), and "alan" (high quality, requires additional code)
        String voiceName = "kevin16";

        // This instantiates the voiceManager
        VoiceManager voiceManager = VoiceManager.getInstance();
        // This gets the specified voice from the voiceManager
        Voice voice = voiceManager.getVoice(voiceName);

        return voice;
    }

    // Actually reads the text
    public void speakText(String text, Voice voice)
    {
        parseText(text);
        this.voice = voice;

        Thread t = new Thread(new TextReader());
        t.start();
    }

    // Parses the text, removing the player's name
    public void parseText(String text)
    {
        String[] split = text.split("u003e");

        if (split.length > 1) {
            this.text = split[split.length - 1];
        } else {
            split = text.split("§a");
            if (split.length > 1) {
                this.text = split[split.length - 1];
            } else {
                this.text = "";
            }
        }

        if (Reference.ForceDebug) {
            ModTextToSpeech.logger.log(Level.INFO, text);
        }
    }
}

