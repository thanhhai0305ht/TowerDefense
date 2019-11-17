package sample.GameEntities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Config;

public class Map {

    public static final String[][] MAP_SPRITES = new String[][] {
            { "129", "129", "303", "129", "079", "080", "080", "080", "080", "080", "080", "080", "081", "129", "129", "129", "509", "511", "129", "129" },
            { "701", "129", "129", "129", "102", "034", "034", "734", "034", "034", "034", "034", "104", "039", "129", "129", "129", "129", "129", "129" },
            { "129", "129", "129", "701", "102", "034", "082", "126", "126", "126", "083", "034", "173", "198", "601", "198", "198", "198", "602", "198" },
            { "302", "129", "509", "129", "102", "034", "104", "129", "129", "129", "171", "034", "173", "702", "198", "198", "600", "198", "198", "198" },
            { "129", "129", "079", "080", "106", "034", "104", "129", "129", "129", "171", "034", "173", "198", "198", "700", "198", "800", "198", "198" },
            { "129", "511", "102", "034", "034", "034", "104", "041", "129", "129", "171", "034", "173", "108", "804", "198", "801", "198", "198", "198" },
            { "129", "129", "102", "034", "082", "126", "127", "041", "129", "129", "171", "034", "174", "805", "149", "149", "149", "149", "149", "149" },
            { "079", "080", "106", "034", "104", "129", "129", "129", "129", "129", "171", "034", "034", "034", "734", "034", "034", "034", "034", "034" },
            { "552", "034", "734", "034", "104", "129", "304", "129", "500", "129", "194", "195", "195", "195", "195", "195", "195", "195", "195", "195" },
            { "102", "034", "082", "126", "127", "301", "129", "551", "129", "129", "198", "198", "198", "110", "198", "110", "198", "198", "198", "198" },
    };

    public static void drawMap(GraphicsContext gc) {
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                Image image = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile" + MAP_SPRITES[i][j] + ".png");

                gc.drawImage(image, j * Config.tileScale, i * Config.tileScale);
            }
        }
    }
}
