package clash.royale.model;

public class startMusic {
    musicThread thread = new musicThread("src/indila-tourner-dans-le-vide-alphagospelmusiccom_N1IdhcRU.mp3");
    Thread thread2 = new Thread(thread);
    public void start() {
            thread2.start();
    }
}
