package clash.royale.model;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Tower {
    int health;
    ProgressBar healthshow = new ProgressBar();

    public Tower(AnchorPane p){
        Pane r = new Pane();
        r.setPrefWidth(90);
        r.setPrefHeight(90);
        r.setLayoutY(182);
        r.setLayoutX(54);
        Image img = new Image(String.valueOf(BackgroundGrass.class.getResource("tower.png")));
        ImageView iv = new ImageView();
        iv.setImage(img);
        iv.setFitWidth(90);
        iv.setFitHeight(90);
        r.getChildren().add(iv);
        p.getChildren().add(r);

        Pane r2 = new Pane();
        r2.setPrefWidth(90);
        r2.setPrefHeight(90);
        r2.setLayoutY(182);
        r2.setLayoutX(474);
        Image img2 = new Image(String.valueOf(BackgroundGrass.class.getResource("tower.png")));
        ImageView iv2 = new ImageView();
        iv2.setImage(img2);
        iv2.setFitWidth(90);
        iv2.setFitHeight(90);
        r2.getChildren().add(iv2);
        p.getChildren().add(r2);

        Pane r3 = new Pane();
        r3.setPrefWidth(90);
        r3.setPrefHeight(90);
        r3.setLayoutY(2);
        r3.setLayoutX(474);
        Image img3 = new Image(String.valueOf(BackgroundGrass.class.getResource("tower.png")));
        ImageView iv3 = new ImageView();
        iv3.setImage(img3);
        iv3.setFitWidth(90);
        iv3.setFitHeight(90);
        r3.getChildren().add(iv3);
        p.getChildren().add(r3);

        Pane r4 = new Pane();
        r4.setPrefWidth(90);
        r4.setPrefHeight(90);
        r4.setLayoutY(2);
        r4.setLayoutX(54);
        Image img4 = new Image(String.valueOf(BackgroundGrass.class.getResource("tower.png")));
        ImageView iv4 = new ImageView();
        iv4.setImage(img4);
        iv4.setFitWidth(90);
        iv4.setFitHeight(90);
        r4.getChildren().add(iv4);
        p.getChildren().add(r4);



    }
}
