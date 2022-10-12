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


public class ControllerSettings {
        @FXML
        private Button btn_save;

        @FXML
        private RadioButton choice_music_on;

        @FXML
        private RadioButton choice_music_off;

        @FXML
        private ChoiceBox<String> choice_music;


        Settings settings = new Settings();


        public void initialize() {

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


            choice_music.setValue(settings.getMusicplaying());

            choice_music_on.setSelected(settings.getMusiconoff());
            choice_music_off.setSelected(!settings.getMusiconoff());

        }

        @FXML
        void choice_music_press_off(ActionEvent event) {
            choice_music_on.setSelected(false);
        }


        @FXML
        void choice_music_press_on(ActionEvent event) {
            choice_music_off.setSelected(false);
        }


    }


