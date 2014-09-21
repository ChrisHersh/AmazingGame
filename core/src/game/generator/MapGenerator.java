package game.generator;

import game.helpers.AssetLoader;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MapGenerator
{
	public Sprite[][] generate(int tileLengthX, int tileLengthY)
	{
		Sprite[][] map = new Sprite[tileLengthX][tileLengthY];
		
		TextureRegion basicTile = AssetLoader.basicTile;
		Sprite bt = new Sprite(basicTile);
		
		for(int x = 0; x < tileLengthX; x++)
		{
			for(int y = 0; y < tileLengthX; y++)
			{
				map[x][y] = bt;
			}
		}
		
		return map;
	}
}
