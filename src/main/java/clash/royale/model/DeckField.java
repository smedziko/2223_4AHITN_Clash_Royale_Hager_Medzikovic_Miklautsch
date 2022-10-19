package clash.royale.model;

import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class DeckField {
    public Pane background;

    public DeckField(Pane background){
        this.background = background;
        ListView<Rectangle> lv = new ListView<>();

        Rectangle r = new Rectangle();
        r.setWidth(10);
        r.setHeight(10);
        lv.getItems().add(r);
        lv.getItems().add(r);
        lv.setStyle(".list-cell {-fx-background-color: transparent;} .list-view { -fx-background-color: transparent}");

        lv.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        background.getChildren().add(lv);




    }
}
