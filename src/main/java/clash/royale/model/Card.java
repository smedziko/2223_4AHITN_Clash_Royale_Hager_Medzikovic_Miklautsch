package clash.royale.model;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Card {
    private static Card cards;
    Image picture;
    Label cost;
    Circle background;
    boolean active = false;
    StackPane whole = new StackPane();

    public Card(String picture, int cost, Color p){
        background = new Circle();


        background.setFill(Color.BLUE);
        background.setRadius(44);

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);
        background.setEffect(ds);


        whole.setAlignment(Pos.CENTER);
        whole.getChildren().add(background);

        Image img = new Image(String.valueOf(BackgroundGrass.class.getResource("pekka.png")));

        ImageView iv = new ImageView();
        iv.setFitHeight(50);
        iv.setFitWidth(70);

        iv.setImage(img);
        whole.getChildren().add(iv);

        whole.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start a drag-and-drop gesture*/
                /* allow any transfer mode */
                Dragboard db = background.startDragAndDrop(TransferMode.ANY);

                /* Put a string on a dragboard */
                Image img = new Image(String.valueOf(BackgroundGrass.class.getResource("pekka.png")));
                ClipboardContent content = new ClipboardContent();
                content.putImage(img);
                db.setContent(content);

                event.consume();
            }
        });

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                iv.startDragAndDrop();


                background.setFill(Color.DARKSLATEBLUE);
            }
        };

        whole.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);



    }


}
