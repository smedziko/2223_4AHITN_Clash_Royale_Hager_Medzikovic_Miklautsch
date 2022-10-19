package clash.royale.model;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Cards {
    static VBox c = new VBox();
    static ArrayList<Card> cards = new ArrayList<>();

    public Cards(AnchorPane a) {


        c.setAlignment(Pos.TOP_CENTER);
        c.setPrefWidth(110);
        c.setLayoutY(20);
        c.setPrefHeight(280);
        c.setLayoutX(5);
        c.setSpacing(15);
       // c.setBackground(new Background(new BackgroundFill(Color.BLACK,
         //       CornerRadii.EMPTY,
           //     Insets.EMPTY)));


        Card s1 = new Card("pekka",2, Color.GREEN);
        Card s2 = new Card("hogrider",2, Color.GREEN);
        Card s3 = new Card("giant",2, Color.BLUE);
        Card s4 = new Card("healer",2, Color.RED);
        c.getChildren().add(s1.whole);
        c.getChildren().add(s2.whole);
        c.getChildren().add(s3.whole);
        c.getChildren().add(s4.whole);
        a.getChildren().add(c);

    }

}
