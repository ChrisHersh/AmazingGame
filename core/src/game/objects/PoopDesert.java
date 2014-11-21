package game.objects;

import game.helpers.AssetLoader;

public class PoopDesert extends TileSprite {

    
    
    public PoopDesert(int x, int y) {
        super(AssetLoader.poopdesert, x, y);
        movementCost = 2;
        defenseBonus = 0;
        attackBonus = 0;
    }

}
