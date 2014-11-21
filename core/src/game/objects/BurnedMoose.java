package game.objects;

import game.helpers.AssetLoader;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BurnedMoose extends TileSprite {

    
    
    public BurnedMoose(int x, int y) {
        super(AssetLoader.burnedMoose, x, y);
        movementCost = 3;
        defenseBonus = 0;
        attackBonus = 5;
    }

}
