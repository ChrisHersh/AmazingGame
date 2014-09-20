package game.generator;

import game.helpers.AssetLoader;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MapGenerator
{
	public TextureRegion[][] generate(int tileLengthX, int tileLengthY)
	{
		TextureRegion[][] map = new TextureRegion[tileLengthX][tileLengthY];
		
		TextureRegion basicTile = AssetLoader.basicTile;
		
		for(int x = 0; x < tileLengthX; x++)
		{
			for(int y = 0; y < tileLengthX; y++)
			{
				map[x][y] = basicTile;
			}
		}
		
		return map;
	}
}
