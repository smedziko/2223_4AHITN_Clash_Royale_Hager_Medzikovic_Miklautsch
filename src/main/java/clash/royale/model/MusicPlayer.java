package clash.royale.model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author elias
 * startet die Musik
 */
public class MusicPlayer {
    private AdvancedPlayer player;

    public MusicPlayer() {
        player = null;
    }

    /**
     * @author elias
     * spielt die Musik ab und falls es ein Problem gibt, wird es abgefangen
     */

    public void playFile(String filename) {
        try {
            preparePlayer(filename);
            player.play();
        } catch (JavaLayerException e) {
            System.out.println("Error");
        }
    }

    /**
     * @author elias
     * setzt den Player, der das Spiel starten soll und wird auch abgefangen falls es einen Fehler gibt
     */
    private void preparePlayer(String filename) {
        try {
            InputStream is = getInputStream(filename);
            player = new AdvancedPlayer(is, createAudioDevice());
        } catch (IOException | JavaLayerException e) {
            System.out.println("Error");
        }
    }


    /**
     * @author elias
     * setzt den InputStream
     */
    private InputStream getInputStream(String filename)
            throws IOException {
        return new BufferedInputStream(
                new FileInputStream(filename));
    }
    /**
     * @author elias
     * erstellt ein Audio Device
     */
    private AudioDevice createAudioDevice()
            throws JavaLayerException {
        return FactoryRegistry.systemRegistry().createAudioDevice();
    }
}
