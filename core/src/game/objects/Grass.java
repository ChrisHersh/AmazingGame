package game.objects;

import game.helpers.AssetLoader;

public class Grass extends TileSprite {

    
    
    public Grass(int x, int y) {
        super(AssetLoader.grass, x, y);
        movementCost = 1;
        defenseBonus = 0;
        attackBonus = 0;
    }

}
