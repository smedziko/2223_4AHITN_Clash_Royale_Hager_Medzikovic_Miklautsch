package clash.royale.controller;

import clash.royale.model.ChangeScene;
import clash.royale.model.Settings;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.File;
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

    @FXML
    private ChoiceBox<String> choice_music;

    @FXML
    public Slider VolumeSlider;


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

        /**
         * @author smedziko
         * Hintergrundmusik wird abgespielt
         * Lautstärke einstellbar
         */
        String music = "src/indila-tourner-dans-le-vide-alphagospelmusiccom_N1IdhcRU.mp3";
        Media m = new Media(new File(music).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(m);
        mediaPlayer.play();

        VolumeSlider.setValue(mediaPlayer.getVolume() * 100);
        VolumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaPlayer.setVolume(VolumeSlider.getValue() / 100);
            }
        });

    }
}


