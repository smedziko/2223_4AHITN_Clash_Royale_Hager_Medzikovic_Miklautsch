package clash.royale.controller;

import clash.royale.model.ChangeScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;

/**
 * @author elias
 * Controller für das Menü
 */
public class MenueController {

    @FXML
    private Pane background;

    @FXML
    private Button credits_button;

    @FXML
    private Button start_game;

    @FXML
    private Button btn_settings;

    @FXML
    private Button deck;


    public void initialize() {
        /**
         * @author elias
         * Klick auf den Button verweist auf die Credits-Seite
         */
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

        /**
         * @author elias
         * Klick auf den Button verweist auf das Main-Game
         */
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

        /**
         * @author elias
         * Klick auf den Button verweist auf die Settings
         */
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

        /**
         * @author elias
         * Klick auf den Button verweist auf das Kartendeck
         */
        deck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    ChangeScene.change_scene("deck", deck);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        /**
         * @author smedziko
         * Hintergrundmusik wird abgespielt
         *
         */
        String music = "src/indila-tourner-dans-le-vide-alphagospelmusiccom_N1IdhcRU.mp3";
        Media m = new Media(new File(music).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(m);
        mediaPlayer.play();



    }



}
