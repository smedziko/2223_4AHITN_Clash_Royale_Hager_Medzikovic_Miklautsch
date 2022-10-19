package clash.royale.controller;

import clash.royale.model.ChangeScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;

public class DeathpageController {
    @FXML
    private javafx.scene.control.Button back_to_the_menu;

    @FXML
    private Button restart_game;

    public void initialize() {
        /**
         * @author elias
         * Klick auf den Button verweist auf das Menu
         */
        back_to_the_menu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    ChangeScene.change_scene("menu", back_to_the_menu);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        /**
         * @author elias
         * Klick auf den Button verweist auf das Main-Game
         */
        restart_game.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    ChangeScene.change_scene("hello-view", restart_game);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
