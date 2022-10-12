package clash.royale.model;

import clash.royale.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * @author elias
 * Scene wird gewechselt
 */
public class ChangeScene {
    /**
     * @author elias
     * wechselt in eine andere Scene
     * String game: gibt an in welche Scene gewechselt wird
     * Button button: zur hilfestellung, um zu wissen welches die aktuelle Scene ist und um sie zu schließen
     */
    public static void change_scene(String game, Button button) throws IOException {
        Stage stage = new Stage();

        Stage stageclose = (Stage) button.getScene().getWindow();
        stageclose.close();
        final FXMLLoader fxmlLoader = new FXMLLoader();
        URL u = HelloApplication.class.getResource(game + ".fxml");

        fxmlLoader.setLocation(u);
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle(game);
        stage.setScene(scene);
        stage.show();
    }
}
