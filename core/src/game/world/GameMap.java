package game.world;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

import game.generator.MapGenerator;
import game.helpers.AssetLoader;
import game.objects.TileSprite;

public class GameMap
{
	private MapGenerator mapGen;
	private TileSprite[][] tileMap;
	private Stage stage;
	
	public GameMap()
	{
		mapGen = new MapGenerator();
		tileMap = mapGen.generate(128, 80);
		stage = mapGen.createActorListeners(tileMap);
	}
	
	public void update(float delta)
	{
//		System.out.println(1/delta);
	}
	
	public TileSprite[][] getTileMap()
	{
		return tileMap;
	}
	
	public void getUnitMap()
	{
		
	}

	public void selectTile(int x, int y)
	{
		// TODO Auto-generated method stub
		tileMap[x][y].selectNormal();
	}

	public void recieveMessage(String msg)
	{
		// TODO Auto-generated method stub
		
	}
	
	public Stage getStage()
	{
		return stage;
	}
}
