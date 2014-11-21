package game.objects;

import game.helpers.AssetLoader;

public class Wall extends TileSprite {

    
    
    public Wall(int x, int y) {
        super(AssetLoader.wall, x, y);
        movementCost = 1000;
        defenseBonus = 0;
        attackBonus = 0;
    }

}
