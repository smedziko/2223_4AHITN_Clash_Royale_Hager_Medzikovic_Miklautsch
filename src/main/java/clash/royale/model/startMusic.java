package clash.royale.model;
/**
 * @author elias
 * startet die Musik, bei Aufruf der start()-Funktion
 */
public class startMusic {
    musicThread thread = new musicThread("src/indila-tourner-dans-le-vide-alphagospelmusiccom_N1IdhcRU.mp3");
    Thread thread2 = new Thread(thread);
    /**
     * @author elias
     * startet die Musik
     */
    public void start() {
            thread2.start();
    }
}
