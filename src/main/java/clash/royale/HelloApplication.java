package clash.royale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.File;
import java.io.IOException;


public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Crash Croyal");
        stage.setScene(scene);
        stage.show();

        //MediaPlayer sound = new MediaPlayer(new Media("src/indila-tourner-dans-le-vide-alphagospelmusiccom_N1IdhcRU.mp3"));
        //sound.setCycleCount(MediaPlayer.INDEFINITE);
        //sound.play();

         //String path = "src/indila-tourner-dans-le-vide-alphagospelmusiccom_N1IdhcRU.mp3";
         //Media media = new Media(new File(path).toURI().toString());
         //MediaPlayer mediaPlayer = new MediaPlayer(media);
         //mediaPlayer.setAutoPlay(true);

        File f = new File("src/indila-tourner-dans-le-vide-alphagospelmusiccom_N1IdhcRU.mp3");
        Media m = new Media(f.toURI().toString());
        MediaPlayer mp = new MediaPlayer(m);
        mp.play();

    }

    public static void main(String[] args) {
        launch();
    }
}