package sample.GameEntities;

import javafx.scene.canvas.GraphicsContext;
import sample.Config;
import sample.GameEntities.Enemy.*;

import java.util.ArrayList;
import java.util.List;

import static sample.Main.*;

public class Spawner extends MovableObject {

    private int delay;
    public int creatingTime;
    private int number;
    public List<BaseEnemy> enemies = new ArrayList<>();
    public int index = 1;
    private boolean check;

    public Spawner(int delay, int creatingTime, int number) {
        this.x = -1;
        this.y = 8;
        this.i = x * Config.tileScale;
        this.j = y * Config.tileScale;
    }

    @Override
    public void render(GraphicsContext gc) {
        enemies.forEach(g -> g.render(gc));
    }

    private void LV(int level) {
        if (level == 1) {
            number = 7;
            creatingTime = 30;
            delay = 20;
            for (int n = 0; n < number; n++) {
                if (tick.getTick() == creatingTime + delay * n) {
                    enemies.add(new NormalEnemy(-1,8));
                }
            }
        }
        else if (level == 2) {
            number=10;

            delay=20;
            for (int n = 0; n < number; n++) {
                if (tick.getTick() == creatingTime + delay * n) {

                    enemies.add(new SmallerEnemy(-1, 8));
                }
            }
        }
        else if (level == 3){
            number=20;

            delay=20;
            for (int n = 0; n < number; n++) {
                if (tick.getTick() == creatingTime + delay * n) {
                    if(check) {
                        check= false;
                        enemies.add(new SmallerEnemy(-1, 8));
                    }
                    else {
                        check=true;
                        enemies.add(new NormalEnemy(-1,8));
                    }

                }
            }
        }
        else if(level == 4){
            number=3;
            delay=20;
            for (int n = 0; n < number; n++) {
                if (tick.getTick() == creatingTime + delay * n) {

                    enemies.add(new TankerEnemy(-1, 8));
                }
            }
        }
        else if(level ==5){
            number=1;
            delay=0;
            for (int n = 0; n < number; n++) {
                if (tick.getTick() == creatingTime + delay * n) {

                    enemies.add(new BossEnemy(-1, 8));
                }
            }
        }
    }

    @Override
    public void update() {
        LV(index);

        if(enemies.isEmpty() && tick.getTick() >= creatingTime) {
            creatingTime = tick.getTick() + 1;
            index ++;
        }
        enemies.forEach(BaseEnemy::update);

    }
}

