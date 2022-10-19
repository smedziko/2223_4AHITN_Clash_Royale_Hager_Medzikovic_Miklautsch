package clash.royale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

//Wittner schreiben, angebot noch steht / Scrum gemeinsam / Projektideen / Product Owner & Developer / Spielemanager / Jänner Tag der offenen Tür
// Zahl neben der Progressbar, um die Leben besser darzustellen
// Progressbar beim laufen nicht wackeln lassen
// Türme sollten nicht von personen betreten werden
// Türme sollten Schaden machen
//Model View Controller Prinzip
//Type beim Enemygenerator auf enemy setzen
//AnimationTimer verwenden statt thread für longterm use

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Crash Croyal");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}