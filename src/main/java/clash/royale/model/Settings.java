package clash.royale.model;

public class Settings {
    private static boolean musiconoff = true;
    private static String musicplaying = "music";

    public static boolean getMusiconoff() {
        return musiconoff;
    }

    public void setMusiconoff(boolean musiconoff) {
        Settings.musiconoff = musiconoff;
    }

    public String getMusicplaying() {
        return musicplaying;
    }

    public void setMusicplaying(String musicplaying) {
        Settings.musicplaying = musicplaying;
    }
}