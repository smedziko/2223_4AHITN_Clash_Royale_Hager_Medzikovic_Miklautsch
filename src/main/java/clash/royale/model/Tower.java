package clash.royale.model;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Tower {

    private static final int TOWER_MEASURE = 90;
    double health = 2000;
    boolean exit = false;
    ImageView picture = new ImageView();

    int damage = 10;

    Pane whole = new Pane();

    ProgressBar healthbar;

    static ArrayList<Tower> enemytowers = new ArrayList<>();
    static ArrayList<Tower> friendlytowers = new ArrayList<>();

    Label healshow = new Label();

    public Tower(Pane p, int y, int x, String type) {
        whole.setPrefWidth(TOWER_MEASURE);
        whole.setPrefHeight(TOWER_MEASURE);
        whole.setLayoutY(y);
        whole.setLayoutX(x);
        Image img = new Image(String.valueOf(BackgroundGrass.class.getResource("tower.png")));
        picture.setImage(img);
        picture.setFitWidth(TOWER_MEASURE);
        picture.setFitHeight(TOWER_MEASURE);

        healthbar = new ProgressBar();
        healthbar.setProgress(1);
        healthbar.setPrefHeight(10);
        healthbar.setPrefWidth(80);
        healthbar.setLayoutY(90);
        healthbar.setLayoutX(10);

        healshow.setFont(new Font("Arial", 8));
        healshow.setLayoutX(4);
        healshow.setText("100%");
        healshow.setTextFill(Color.WHITE);

        whole.getChildren().add(picture);
        whole.getChildren().add(healthbar);
        whole.getChildren().add(healshow);
        p.getChildren().add(whole);

        if (Objects.equals(type, "friendly")) {
            friendlytowers.add(this);
        } else {
            enemytowers.add(this);
        }
    }

}

