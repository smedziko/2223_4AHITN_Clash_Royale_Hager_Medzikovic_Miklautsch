package clash.royale.controller;

import clash.royale.model.BackgroundGrass;
import clash.royale.model.Card;
import clash.royale.model.Cards;
import clash.royale.model.Tower;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;

public class HelloController {

    @FXML
    private AnchorPane background;

    @FXML
    private AnchorPane playfield;

    public void initialize() {

        BackgroundGrass b = new BackgroundGrass(background);
        Cards c = new Cards(background);
        Tower t = new Tower(BackgroundGrass.playfield);


    }


}