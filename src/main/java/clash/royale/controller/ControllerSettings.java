package clash.royale.controller;

import clash.royale.model.ChangeScene;
import clash.royale.model.Settings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * @author elias
 * Controller für das Settingsmenü
 */
public class ControllerSettings {
        @FXML
        private Button btn_save;

        @FXML
        private RadioButton choice_music_on;

        @FXML
        private RadioButton choice_music_off;

        Settings settings = new Settings();

        public void initialize() {
            /**
             * @author elias
             * Klick auf den Button verweist auf das Menu
             */
            btn_save.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    try {
                        ChangeScene.change_scene("menu", btn_save);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }


