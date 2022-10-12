package clash.royale.model;
/**
 * @author elias
 * Musik wird abgespielt
 */
public class musicThread implements Runnable {
    private String tone;
    /**
     * @author elias
     * setzt das File für die Musik
     */
    public musicThread(String s) {
        tone = s;
    }

    /**
     * @author elias
     * startet den musicplayer
     */
    @Override
    public void run() {
        MusicPlayer musicplayer = new MusicPlayer();
        musicplayer.playFile(tone);
    }
}
