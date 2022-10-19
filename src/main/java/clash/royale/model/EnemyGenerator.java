package clash.royale.model;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;

public class EnemyGenerator {

    Pane background;

    Image img;

    int damage;

    int health;

    int y;
    int x;

    ArrayList<ActiveCards> enemy;

    static ArrayList<ActiveCards> enemies = new ArrayList<>();

    boolean spawnupper = false;


    AnimationTimer create = new AnimationTimer() {
        private long lastUpdate = 0;
        private long walk = 0;

        @Override
        public void handle(long l) {
            if (l - walk >= 3_940_000_000.0) {
                System.out.println("running");
                if (spawnupper) {
                    y = 150;
                    ActiveCards e3 = new ActiveCards(health, damage, img, 603, y, background, "enemy");
                    enemies.add(e3);
                    e3.move.start();
                    spawnupper = false;
                } else {
                    y = 250;
                    ActiveCards e2 = new ActiveCards(health, damage, img, 603, y, background, "enemy");
                    enemies.add(e2);
                    e2.move.start();
                    spawnupper = true;
                }
                walk = l;
            }
            }

    };

    public EnemyGenerator(Pane background){
        this.background = background;
        img = new Image(String.valueOf(BackgroundGrass.class.getResource("giant" + ".png")));
        health = 200;
        damage = 20;
        create.start();
    }

}
