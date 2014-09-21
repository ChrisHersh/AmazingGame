package game.world;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import game.generator.MapGenerator;

public class GameMap
{
	private MapGenerator mapGen;
	private Sprite[][] tileMap;
	
	public GameMap()
	{
		mapGen = new MapGenerator();
		tileMap = mapGen.generate(64, 64);
	}
	
	public void update(float delta)
	{
//		System.out.println(1/delta);
	}
	
	public Sprite[][] getTileMap()
	{
		return tileMap;
	}
	
	public void getUnitMap()
	{
		
	}
}
