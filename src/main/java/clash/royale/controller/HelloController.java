package clash.royale.controller;

import clash.royale.model.*;
import javafx.animation.KeyValue;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HelloController {

    @FXML
    private AnchorPane background;

    @FXML
    private AnchorPane playfield;

    public void initialize() throws IOException {

        background.getChildren().clear();
        BackgroundGrass b = new BackgroundGrass(background);

        Cards c = new Cards(background);
        EnemyGenerator eg = new EnemyGenerator(BackgroundGrass.playable);
        Tower friendly1 = new Tower(BackgroundGrass.playable, 2, 54, "friendly");
        Tower friendly2 = new Tower(BackgroundGrass.playable, 182, 54, "friendly");
        Tower enemy1 = new Tower(BackgroundGrass.playable, 2, 474, "enemy");
        Tower enemy2 = new Tower(BackgroundGrass.playable, 182, 474, "enemy");


    }


}