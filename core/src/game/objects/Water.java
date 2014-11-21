package game.objects;

import game.helpers.AssetLoader;

public class Water extends TileSprite {

    
    
    public Water(int x, int y) {
        super(AssetLoader.water, x, y);
        movementCost = 5;
        defenseBonus = 0;
        attackBonus = 0;
    }

}
