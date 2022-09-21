package clash.royale.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MenueController {

    @FXML
    private Pane background;

    @FXML
    private Button credits_button;

    @FXML
    private Button start_game;


    public void initialize() {

        start_game.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                
            }
        });




    }



}
