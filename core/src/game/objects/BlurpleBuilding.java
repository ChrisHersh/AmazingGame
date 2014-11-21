package game.objects;

import game.helpers.AssetLoader;


public class BlurpleBuilding extends TileSprite {

    
    
    public BlurpleBuilding(int x, int y) {
        super(AssetLoader.blurpleBuilding, x, y);
        movementCost = 1;
        defenseBonus = 2;
        attackBonus = 2;
    }

}
