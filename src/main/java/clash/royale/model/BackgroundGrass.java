package clash.royale.model;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.*;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class BackgroundGrass{

    static AnchorPane anchorPane;
    public static AnchorPane playfield = new AnchorPane();
    public static StackPane stack = new StackPane();
    public static Pane playable = new Pane();
    final static int Gridend = 450;
    final static int Grid_Rectangle = 30;
    int grid_change = 0;

    public BackgroundGrass(AnchorPane a){
        ActiveCards.active.clear();
        Tower.friendlytowers.clear();
        Tower.enemytowers.clear();
        EnemyGenerator.enemies.clear();
        Tower.enemytowers.clear();
        Tower.friendlytowers.clear();
            anchorPane = a;
            stack.getChildren().clear();
            playfield.getChildren().clear();
            playable.getChildren().clear();
            InputStream is = BackgroundGrass.class.getResourceAsStream("characters.json");
            if (is == null) {
                throw new NullPointerException("Cannot find resource file characters.json");
            }

            JSONTokener tokener = new JSONTokener(is);
            JSONObject object = new JSONObject(tokener);
            final JSONArray characterData;
            characterData = (JSONArray) object.get("characters");


            playfield.setPrefWidth(560);
            playfield.setPrefHeight(330);
            playfield.setLayoutX(120);
            playfield.setLayoutY(60);
            playable.setPrefWidth(560);
            playable.setPrefHeight(330);
            playable.setLayoutX(120);
            playable.setLayoutY(60);
            // playable.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            stack.setPrefWidth(560);
            stack.setPrefHeight(330);
            stack.setLayoutX(120);
            stack.setLayoutY(60);


            for (int i = 0; i < Gridend; i = i + Grid_Rectangle) {
                HBox h = new HBox();
                h.setLayoutX(0);
                h.setLayoutY(i);
                h.setPrefHeight(Grid_Rectangle);
                h.setPrefWidth(a.getPrefWidth());

                for (int j = 0; j <= 740; j = j + Grid_Rectangle) {
                    Rectangle r = new Rectangle();
                    r.setX(j);
                    r.setY(h.getLayoutY());
                    r.setWidth(Grid_Rectangle);
                    r.setHeight(Grid_Rectangle);

                    if (grid_change % 2 == 0) {
                        r.setFill(Color.web("#bac869"));
                    } else {
                        r.setFill(Color.web("#b0C468"));
                    }
                    grid_change++;
                    h.getChildren().add(r);
                }
                a.getChildren().add(h);
            }

            for (int i = 0; i < playfield.getPrefHeight(); i = i + Grid_Rectangle) {
                HBox h = new HBox();
                h.setLayoutX(0);
                h.setLayoutY(i);
                h.setPrefHeight(Grid_Rectangle);
                h.setPrefWidth(playfield.getPrefWidth());


                for (int j = 0; j <= playfield.getPrefWidth() - 20; j = j + Grid_Rectangle) {
                    Rectangle r = new Rectangle();
                    if (j != 270) {
                        r.setX(j);
                        r.setY(h.getLayoutY());
                        r.setWidth(Grid_Rectangle);
                        r.setHeight(Grid_Rectangle);

                        playable.setOnDragEntered(new EventHandler<DragEvent>() {
                            public void handle(DragEvent event) {
                                /* the drag-and-drop gesture entered the target */
                                /* show to the user that it is an actual gesture target */
                                if (event.getGestureSource() != r &&
                                        event.getDragboard().hasImage()) {
                                }

                                event.consume();
                            }
                        });

                        playable.setOnDragDropped(new EventHandler<DragEvent>() {
                            public void handle(DragEvent event) {
                                if (event.getSceneX() < 385 && event.getSceneY() > 60 && event.getSceneY() < 380) {

                                    Iterator i = characterData.iterator();
                                    while (i.hasNext()) {
                                        JSONObject j = (JSONObject) i.next();
                                        if (event.getDragboard().getString().compareTo(String.valueOf(j.get("name"))) == 0) {
                                            ActiveCards s = new ActiveCards(j.getInt("health"), j.getInt("damage"), event.getDragboard().getImage(), event.getSceneX(), event.getSceneY(), playable, "friendly");
                                            s.move.start();
                                        }
                                    }
                                }
                                event.consume();
                            }
                        });

                        playable.setOnDragOver(new EventHandler<DragEvent>() {
                            public void handle(DragEvent event) {
                                event.acceptTransferModes(TransferMode.MOVE);
                                event.consume();
                            }
                        });


                        if (grid_change % 2 == 0) {
                            Image img = new Image(String.valueOf(BackgroundGrass.class.getResource("grass_tile1.jpg")));
                            r.setFill(new ImagePattern(img));
                        } else {
                            Image img = new Image(String.valueOf(BackgroundGrass.class.getResource("grass_tile2.png")));
                            r.setFill(new ImagePattern(img));
                        }
                        grid_change++;
                        h.getChildren().add(r);
                    } else {
                        r.setX(j);
                        r.setY(h.getLayoutY());
                        r.setWidth(Grid_Rectangle * 3);
                        r.setHeight(Grid_Rectangle);
                        if (h.getLayoutY() == 60 || h.getLayoutY() == 240) {
                            Image img = new Image(String.valueOf(BackgroundGrass.class.getResource("bridge.png")));
                            r.setFill(new ImagePattern(img));
                        } else {
                            Image img = new Image(String.valueOf(BackgroundGrass.class.getResource("river.png")));
                            r.setFill(new ImagePattern(img));
                        }
                        grid_change = grid_change + 3;
                        h.getChildren().add(r);
                    }


                }
                playfield.getChildren().add(h);
            }

            stack.getChildren().add(playfield);
            stack.getChildren().add(playable);
            anchorPane.getChildren().add(stack);
        }


}
