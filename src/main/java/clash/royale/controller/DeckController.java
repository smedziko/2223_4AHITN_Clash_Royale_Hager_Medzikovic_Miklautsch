package clash.royale.controller;
import clash.royale.model.ChangeScene;
import clash.royale.model.startMusic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DeckController {
    @FXML
    private Pane background;

    @FXML
    private Button back_button;


    /**
     * @author elias
     * Klick auf den Button verweist auf das Main-Game
     */
    public void initialize() {
        back_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    ChangeScene.change_scene("menu", back_button);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
