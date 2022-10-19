package clash.royale.controller;
import clash.royale.model.BackgroundGrass;
import clash.royale.model.ChangeScene;
import clash.royale.model.DeckField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class DeckController {
    @FXML
    private Pane background;

    @FXML
    private Button back_button;

    @FXML
    private ListView listView;

    @FXML
    private HBox hbox1;

    @FXML
    private HBox hbox2;

    @FXML
    private HBox hbox3;

    @FXML
    private HBox hbox4;

    @FXML
    private HBox hbox5;

    @FXML
    private HBox hbox6;






    /**
     * @author elias
     * Klick auf den Button verweist auf das Start-Menu
     */
    public void initialize() {

        DeckField df = new DeckField(background);
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
