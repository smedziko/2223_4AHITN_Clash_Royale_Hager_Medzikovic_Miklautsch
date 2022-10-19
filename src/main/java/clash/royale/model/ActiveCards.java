package clash.royale.model;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ActiveCards extends Thread {
    double health;
    double damage;
    int path = 0;
    ProgressBar healthBar;

    Label healthshow;

    Pane whole = new Pane();
    static ArrayList<ActiveCards> active = new ArrayList<>();
    boolean enemydetected = false;
    boolean samewidths;
    boolean sameheights;
    Pane enemie;
    boolean exit = false;

    boolean started = false;

    ActiveCards enemy;

    String type;

    ImageView picture;

    boolean attackingTower = false;
    Tower attackTower;


    ArrayList<ActiveCards> enemylist;

    ArrayList<Tower> towers;

    boolean attack = false;

    static boolean ended = false;




    ArrayList onBoardCards;
    Pane playfield;

    AnimationTimer move = new AnimationTimer() {
        private long lastUpdate = 0;
        private long walk = 0;

        @Override
        public void handle(long l) {

            if (l - walk >= 800_000_000.0) {
                if (whole.getRotate() == -3 || whole.getRotate() == 0 && !enemydetected) {
                    whole.setRotate(5);
                } else if (whole.getRotate() == 5) {
                    whole.setRotate(-3);
                }
                walk = l;
            }

            if (l - lastUpdate >= 12_000_000) {

                if (!enemydetected) {

                    //
                    if (Objects.equals(type, "enemy") && whole.getLayoutX() <= 150 && !attack) {
                        towers = Tower.friendlytowers;
                        System.out.println("enemytowers");
                        attack = true;
                    } else if (whole.getLayoutX() >= 485 && !attack) {
                        towers = Tower.enemytowers;
                        attack = true;
                    }


                    if (attack) {
                        if (whole.getRotate() == 5 || whole.getRotate() == -5) {
                            whole.setRotate(0);
                        }
                        if (towers.size() > 0) {
                            if (whole.getLayoutY() < 205 && !attackingTower) {
                                attackTower = towers.get(0);

                                if (attackTower.health > 0) {
                                    attackingTower = true;
                                    fight();
                                } else {
                                    path = 240;
                                }
                            } else if (!attackingTower) {
                                attackTower = towers.get(1);

                                if (attackTower.health > 0) {
                                    attackingTower = true;
                                    fight();
                                } else {
                                    path = 60;
                                }
                            }
                        }
                    }





                    if(Objects.equals(type, "enemy")){
                        if (whole.getLayoutX() > 240) {
                            whole.setLayoutX(whole.getLayoutX() - 1.5);
                        }
                    }else {
                        if(whole.getLayoutX() < 240){
                            whole.setLayoutX(whole.getLayoutX() + 1.5);
                        }
                    }

                    if (whole.getLayoutY() <= 150 && path == 0) {
                        path = 60;
                    } else if (whole.getLayoutY() > 150 && path == 0) {
                        path = 240;
                    }

                    if (whole.getLayoutY() > path - 2 && whole.getLayoutY() < path + 1) {
                        if(Objects.equals(type, "enemy")) {
                            if (whole.getLayoutX() > 130 && whole.getLayoutX() <= 240) {
                                whole.setLayoutX(whole.getLayoutX() - 1.5);
                            }
                        }else {
                                if (whole.getLayoutX() < 500 && whole.getLayoutX() >= 240) {
                                    whole.setLayoutX(whole.getLayoutX() + 1.5);
                                }
                            }

                    } else if (whole.getLayoutY() < path) {
                        whole.setLayoutY(whole.getLayoutY() + 1.5);
                    } else if (whole.getLayoutY() > path) {
                        whole.setLayoutY(whole.getLayoutY() - 1.5);
                    }


                    findenemy();
                }

                if (enemydetected) {
                    if (whole.getRotate() == 5 || enemie.getRotate() == -5 || whole.getRotate() == -5 || enemie.getRotate() == 5) {
                        whole.setRotate(0);
                        enemie.setRotate(0);
                    }

                    if (whole.getLayoutY() < enemie.getLayoutY() - 1) {
                        whole.setLayoutY(whole.getLayoutY() + 1);
                    } else if (whole.getLayoutY() > enemie.getLayoutY() + 1) {
                        whole.setLayoutY(whole.getLayoutY() - 1);
                    } else {
                        samewidths = true;
                    }


                    if (whole.getLayoutX() < enemie.getLayoutX() - 32) {
                        whole.setLayoutX(whole.getLayoutX() + 1);
                    } else if (whole.getLayoutX() > enemie.getLayoutX() + 32) {
                        whole.setLayoutX(whole.getLayoutX() - 1);
                    } else {
                        sameheights = true;
                    }

                    if (sameheights && samewidths && !started) {
                        started = true;
                        if(Objects.equals(type, "friendly")){
                            onBoardCards = EnemyGenerator.enemies;
                        }else {
                                onBoardCards = active;
                        }

                        synchronized (this) {
                            attackingTower = false;
                        }
                        fight();


                    }
                }
            }

            lastUpdate = l;
        }
    };

    public void fight() {
        this.resume();
    }

    public void findenemy(){

        if(Objects.equals(type, "friendly")) {
            enemylist = EnemyGenerator.enemies;
        }else {
            enemylist = active;
        }

        for (ActiveCards a : enemylist) {
            double underX = whole.getLayoutX() - 95;
            double overY = whole.getLayoutY() - 95;
            double overX = whole.getLayoutX() + 95;
            double underY = whole.getLayoutY() + 95;

            if (a.whole != whole && !a.enemydetected && !enemydetected) {
                if (a.whole.getLayoutY() >= overY && a.whole.getLayoutY() <= whole.getLayoutY() && a.whole.getLayoutX() >= underX && a.whole.getLayoutX() <= overX) {
                    enemydetected = true;
                    synchronized (a) {
                        a.enemydetected = true;
                    }
                    a.started = true;
                    enemie = a.whole;
                    a.enemie = whole;
                    synchronized (a) {
                        a.attackingTower = false;
                    }
                } else if (a.whole.getLayoutY() <= underY && a.whole.getLayoutY() >= whole.getLayoutY() && a.whole.getLayoutX() >= underX && a.whole.getLayoutX() <= overX) {
                    enemydetected = true;
                    synchronized (a) {
                        a.enemydetected = true;
                    }
                    enemie = a.whole;
                    a.enemie = whole;
                    a.started = true;
                    synchronized (a) {
                        a.attackingTower = false;
                    }
                }
            }


        }
    }


    ActiveCards(int health, int damage, Image p, double x, double y, Pane playable, String type) {
        picture = new ImageView();
        picture.setImage(p);
        if(Objects.equals(type, "friendly")) {
            active.add(this);
        }
        picture.setFitHeight(30);
        picture.setFitWidth(30);
        whole.setPrefWidth(30);
        whole.setPrefHeight(30);
        whole.setLayoutX(x - 130);
        whole.setLayoutY(y - 70);

        healthBar = new ProgressBar();
        healthshow = new Label();
        healthBar.setLayoutY(33);
        healthshow.setLayoutY(-10);
        healthBar.setPrefHeight(10);
        healthBar.setPrefWidth(32);
        healthBar.setProgress(1);
        healthshow.setFont(new Font("Arial", 8));
        healthshow.setLayoutX(4);
        healthshow.setText("100%");
        healthshow.setTextFill(Color.WHITE);


        whole.getChildren().add(healthBar);
        whole.getChildren().add(healthshow);
        whole.getChildren().add(picture);


        playfield = playable;
        playable.getChildren().add(whole);
        playable.toFront();
        this.health = health;
        this.damage = damage;
        this.type = type;

        if(Objects.equals(type, "friendly")){
            onBoardCards = EnemyGenerator.enemies;
        }else {
            onBoardCards = active;

        }
        findenemy();

        this.start();
    }

    public void stopGame(){

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Button s = new Button();
                s.setVisible(false);
                playfield.getChildren().add(s);


                try {
                    ChangeScene.change_scene("deathpage", s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        ArrayList<ActiveCards> cards;
        cards = ActiveCards.active;
        for (ActiveCards e: cards) {
            if(e.whole != whole) {
                e.move.stop();
                e.whole.setVisible(false);
                e.whole.setDisable(true);
            }
        }

        cards = EnemyGenerator.enemies;
        for (ActiveCards e:
                cards) {
            if(e.whole != whole) {
                e.whole.setDisable(true);
                e.move.stop();
                e.whole.setVisible(false);
            }
        }

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                move.stop();
                playfield.getChildren().clear();
                ended = false;
            }
        });

    }


    public void run() {
        DecimalFormat df = new DecimalFormat("##.00");
        while (true) {
            int i = 0;
            if(attackingTower){
                while(towers.size() > i && !exit) {
                    Tower t = towers.get(i);
                    i++;
                    if(t == attackTower){
                        double setHealthBar2 = damage / attackTower.health;
                        double setHealthBar3 = attackTower.damage / health;
                        while(attackTower.health > 0 && health > 0 && attackingTower){
                            attackTower.health = attackTower.health - damage;
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    attackTower.healthbar.setProgress(attackTower.healthbar.getProgress() - setHealthBar2);
                                    picture.setRotate(0);
                                    attackTower.healshow.setText(df.format(attackTower.healthbar.getProgress() * 100) + "%");
                                }
                            });
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            health = health - attackTower.damage;
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    healthBar.setProgress(healthBar.getProgress() - setHealthBar3);
                                    picture.setRotate(15);
                                    healthshow.setText(df.format(healthBar.getProgress() * 100) + "%");
                                }
                            });
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        if (t.health <= 0) {
                            Image img = new Image(String.valueOf(BackgroundGrass.class.getResource("fire.png")));
                            t.healthbar.setVisible(false);
                            t.healshow.setVisible(false);
                            t.picture.setImage(img);
                            t.whole.setDisable(true);
                            this.started = false;
                            exit = true;
                            attackingTower = false;

                            int count = 0;
                            ArrayList<Tower> towers1;
                            if (Objects.equals(type, "friendly")) {
                                towers1 = Tower.enemytowers;
                            } else {
                                towers1 = Tower.friendlytowers;
                            }
                            for (Tower t2 : towers1) {
                                if (t2.health <= 0) {
                                    count++;
                                }
                            }

                            if (count == 2 && !ended) {
                                synchronized (active){
                                    stopGame();
                                }
                                ended = true;
                            }
                        }
                        if (health <= 0) {
                            whole.setVisible(false);
                            whole.setDisable(true);
                            whole.setRotate(0);
                            if(Objects.equals(type, "friendly")) {
                                synchronized (active) {
                                    active.remove(this);
                                }
                            }else {
                                synchronized (EnemyGenerator.enemies){
                                    EnemyGenerator.enemies.remove(this);
                                }
                            }
                            move.stop();
                            exit = true;
                        }



                    }
                }
            }else {
                    while (onBoardCards.size() > i && !exit) {
                        ActiveCards a = (ActiveCards) onBoardCards.get(i);
                        i++;
                        if (a.whole == enemie) {
                            double setHealthBar = damage / a.health;
                            double setHealthBarThis = a.damage / health;
                            while (a.health > 0 && health > 0) {
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        a.healthBar.setProgress(a.healthBar.getProgress() - setHealthBar);
                                        picture.setRotate(0);
                                        a.picture.setRotate(15);
                                        a.healthshow.setText(df.format(a.healthBar.getProgress() * 100) + "%");
                                    }
                                });

                                a.health = a.health - damage;
                                try {
                                    TimeUnit.SECONDS.sleep(1);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }

                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        healthBar.setProgress(healthBar.getProgress() - setHealthBarThis);
                                        picture.setRotate(-15);
                                        a.picture.setRotate(0);
                                        healthshow.setText(df.format(healthBar.getProgress() * 100) + "%");
                                    }
                                });
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
                                if (Objects.equals(type, "friendly")) {
                                    synchronized (active) {
                                        active.remove(a);
                                    }
                                } else {
                                    synchronized (EnemyGenerator.enemies) {
                                        EnemyGenerator.enemies.remove(a);
                                    }
                                }
                                enemydetected = false;
                                this.started = false;
                                exit = true;
                                attackingTower = false;
                            }
                            if (health <= 0) {
                                whole.setVisible(false);
                                whole.setDisable(true);
                                if (Objects.equals(type, "friendly")) {
                                    synchronized (active) {
                                        active.remove(this);
                                    }
                                } else {
                                    synchronized (EnemyGenerator.enemies) {
                                        EnemyGenerator.enemies.remove(this);
                                    }
                                }
                                move.stop();
                                a.enemydetected = false;
                                a.started = false;
                                exit = true;
                                a.attackingTower = false;
                            }
                        }
                    }
                }

            //Gewinnstatistik Konsolenausgabe (Für Sichtbarkeit)
            exit = false;
            attack = false;
            this.suspend();
        }
    }
}

