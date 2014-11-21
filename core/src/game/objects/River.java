package game.objects;

import game.helpers.AssetLoader;

public class River extends TileSprite {

    
    
    public River(int x, int y) {
        super(AssetLoader.river, x, y);
        movementCost = 2;
        defenseBonus = 0;
        attackBonus = 0;
    }

}
