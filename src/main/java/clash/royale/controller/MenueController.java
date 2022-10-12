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

public class MenueController {

    @FXML
    private Pane background;

    @FXML
    private Button credits_button;

    @FXML
    private Button start_game;

    @FXML
    private Button btn_settings;


    public void initialize() {
        startMusic startMusic = new startMusic();
        startMusic.start();
        credits_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    ChangeScene.change_scene("credits", credits_button);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        start_game.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    ChangeScene.change_scene("hello-view", start_game);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_settings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ChangeScene.change_scene("settingsmenue", btn_settings);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



    }



}
