package game.objects;

import game.helpers.AssetLoader;

public class Tree extends TileSprite {

    
    
    public Tree(int x, int y) {
        super(AssetLoader.tree, x, y);
        movementCost = 2;
        defenseBonus = 3;
        attackBonus = 0;
    }

}
