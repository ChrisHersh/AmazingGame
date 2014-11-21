package game.generator;

import game.helpers.AssetLoader;
import game.helpers.Constants;
import game.objects.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MapGenerator {
    private TileSprite[][] terrainMap;

    public TileSprite[][] generate(int tileLengthX, int tileLengthY) {
        TileSprite[][] map = new TileSprite[tileLengthX][tileLengthY];

        TextureRegion basicTile = AssetLoader.grass;

        // for (int x = 0; x < tileLengthX; x++)
        // {
        // for (int y = 0; y < tileLengthY; y++)
        // {
        // map[x][y] = new TileSprite(basicTile, x, y);
        // }
        // }

        for (int x = 0; x < tileLengthX; x++) {
            for (int y = 0; y < tileLengthY; y++) {

                int tileNum = (int) (Math.random() * Constants.numOfTileTypes);

                switch (tileNum) {
                    case 0:
                        map[x][y] = new Grass(x, y); 
                        break;
                    case 1:
                        map[x][y] = new BlurpleBuilding(x, y); 
                        break;
                    case 2:
                        map[x][y] = new BurnedMoose(x, y); 
                        break;
                    case 3:
                        map[x][y] = new PoopDesert(x, y); 
                        break;
                    case 4:
                        map[x][y] = new River(x, y); 
                        break;
                    case 5:
                        map[x][y] = new Tree(x, y); 
                        break;
                    case 6:
                        map[x][y] = new Wall(x, y); 
                        break;
                    case 7:
                        map[x][y] = new Water(x, y); 
                        break;
                }
            }
        }

        terrainMap = map;
        return map;
    }

    public Unit[] generateRedTeamUnits() {
        // TODO remove this method when implementing random generation
        Unit[] units = new Unit[1];
        units[0] = new Unit(AssetLoader.snorlax, 0);
        units[0].setTerrain(terrainMap[1][1]);

        return units;
    }

    public Unit[] generateBlueTeamUnits() {
        // TODO remove this method when implementing random generation
        Unit[] units = new Unit[5];
        units[0] = new Unit(AssetLoader.snorlax, 1);
        units[0].setTerrain(terrainMap[10][10]);

        units[1] = new Unit(AssetLoader.snorlax, 1);
        units[1].setTerrain(terrainMap[10][9]);

        units[2] = new Unit(AssetLoader.snorlax, 1);
        units[2].setTerrain(terrainMap[10][8]);

        units[3] = new Unit(AssetLoader.snorlax, 1);
        units[3].setTerrain(terrainMap[10][7]);

        units[4] = new Unit(AssetLoader.snorlax, 1);
        units[4].setTerrain(terrainMap[10][6]);

        return units;
    }

    public Unit[] generateGreenTeamUnits() {
        // They all teamkilled themselves, none are left
        return new Unit[0];
    }

    public Unit[] generateUnits(int i) {
        // TODO make this generate random units
        switch (i) {
        case 0:
            return generateRedTeamUnits();
        case 1:
            return generateBlueTeamUnits();
        }
        return new Unit[0];
    }
}
