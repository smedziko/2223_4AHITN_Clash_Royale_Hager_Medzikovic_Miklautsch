package clash.royale.model;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ActiveCards extends Thread {
    double health;
    double damage;
    int path;
    Pane whole = new Pane();
    static ArrayList<ActiveCards> active = new ArrayList<>();
    boolean enemydetected = false;
    boolean samewidths;
    boolean sameheights;
    Pane enemie;
    boolean exit = false;

    boolean started = false;

    Timeline timeline;

    ActiveCards enemy;

    ArrayList<ActiveCards> onBoardCards = new ArrayList<>();

    AnimationTimer move = new AnimationTimer() {
        private long lastUpdate = 0;

        @Override
        public void handle(long l) {
            if (l - lastUpdate >= 12_000_000) {
                //Bewegung
                if (!enemydetected) {
                    if (whole.getLayoutX() < 240) {
                        whole.setLayoutX(whole.getLayoutX() + 1.5);
                    }

                    if (whole.getLayoutY() <= 150) {
                        path = 60;
                    } else if (whole.getLayoutY() > 150) {
                        path = 240;
                    }

                    if (whole.getLayoutY() > path - 2 && whole.getLayoutY() < path + 1) {
                        if (whole.getLayoutX() < 500 && whole.getLayoutX() >= 240) {
                            whole.setLayoutX(whole.getLayoutX() + 1.5);
                        }
                    } else if (whole.getLayoutY() < path) {
                        whole.setLayoutY(whole.getLayoutY() + 1.5);
                    } else if (whole.getLayoutY() > path) {
                        whole.setLayoutY(whole.getLayoutY() - 1.5);
                    }


                    for (ActiveCards a : active) {

                        double underX = whole.getLayoutX() - 95;
                        double overY = whole.getLayoutY() - 95;
                        double overX = whole.getLayoutX() + 95;
                        double underY = whole.getLayoutY() + 95;

                        if (a.whole != whole && !a.enemydetected && !enemydetected) {
                            if (a.whole.getLayoutY() > overY && a.whole.getLayoutY() < whole.getLayoutY() && a.whole.getLayoutX() > underX && a.whole.getLayoutX() < overX) {
                                enemydetected = true;
                                synchronized (a) {
                                    a.enemydetected = true;
                                }
                                a.started = true;
                                enemie = a.whole;
                                a.enemie = whole;
                            } else if (a.whole.getLayoutY() < underY && a.whole.getLayoutY() > whole.getLayoutY() && a.whole.getLayoutX() > underX && a.whole.getLayoutX() < overX) {
                                enemydetected = true;
                                synchronized (a) {
                                    a.enemydetected = true;
                                }
                                enemie = a.whole;
                                a.enemie = whole;
                                a.started = true;
                            }
                        }




                    }
                }

                if (enemydetected) {
                    if (whole.getLayoutY() < enemie.getLayoutY() - 1) {
                        whole.setLayoutY(whole.getLayoutY() + 1);
                    } else if (whole.getLayoutY() > enemie.getLayoutY() + 1) {
                        whole.setLayoutY(whole.getLayoutY() - 1);
                    } else {
                        samewidths = true;
                    }


                    if (whole.getLayoutX() < enemie.getLayoutX() - 1) {
                        whole.setLayoutX(whole.getLayoutX() + 1);
                    } else if (whole.getLayoutX() > enemie.getLayoutX() + 1) {
                        whole.setLayoutX(whole.getLayoutX() - 1);
                    } else {
                        sameheights = true;
                    }

                    if (sameheights && samewidths && !started) {
                            started = true;
                            onBoardCards = active;
                            fight();
                    }
                }
            }

            lastUpdate = l;
        }
    };

    public void fight() {
        System.out.println("Started");
            this.start();
    }


    ActiveCards(int health, int damage, Image p, double x, double y, Pane playable) {
        ImageView iv = new ImageView();
        iv.setImage(p);
        iv.setFitHeight(30);
        iv.setFitWidth(30);
        whole.setPrefWidth(30);
        whole.setPrefHeight(30);
        whole.setLayoutX(x - 130);
        whole.setLayoutY(y - 70);
        whole.getChildren().add(iv);
        //playable.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY,Insets.EMPTY)));

        playable.getChildren().add(whole);
        playable.toFront();
        this.health = health;
        this.damage = damage;
    }


    public void run() {
        synchronized (onBoardCards) {
            int i = 0;
            while(onBoardCards.size() > i && !exit){
                ActiveCards a = onBoardCards.get(i);
                i++;
                if (a.whole == enemie) {
                    a.health = 100;
                    health = 10;
                    damage = 13;
                    a.damage = 10;
                    while (a.health > 0 && health > 0) {
                        a.health = a.health - damage;
                        health = health - a.damage;
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (a.health <= 0) {
                        a.whole.setVisible(false);
                        a.whole.setDisable(true);
                        a.move.stop();
                        active.remove(a);
                        enemydetected = false;
                        this.started = false;
                        exit = true;
                    }
                    if (health <= 0) {
                        whole.setVisible(false);
                        whole.setDisable(true);
                        active.remove(this);
                        move.stop();
                        a.enemydetected = false;
                        a.started = false;
                        exit = true;
                    }
                }
            }
            System.out.println("Stopped");
        }
    }
}

