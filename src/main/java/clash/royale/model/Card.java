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

    public Card(String picture, int cost, Color color){
        background = new Circle();



        background.setFill(color);
        background.setRadius(45);

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);
        background.setEffect(ds);


        whole.setAlignment(Pos.CENTER);
        whole.getChildren().add(background);

        Image img = new Image(String.valueOf(BackgroundGrass.class.getResource(picture + ".png")));

        ImageView iv = new ImageView();
        iv.setFitHeight(55);
        iv.setFitWidth(65);

        iv.setImage(img);
        whole.getChildren().add(iv);

        whole.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start a drag-and-drop gesture*/
                /* allow any transfer mode */
                Dragboard db = background.startDragAndDrop(TransferMode.ANY);

                /* Put a string on a dragboard */
                Image img = new Image(String.valueOf(BackgroundGrass.class.getResource(picture + ".png")));
                ClipboardContent content = new ClipboardContent();
                content.putString(picture);
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
