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
	
	private int previousSelectX;
	private int previousSelectY;
	private boolean tileIsSelected= false;
	
	public GameMap()
	{
		mapGen = new MapGenerator();
		tileMap = mapGen.generate(512, 512);
		System.out.println(tileMap[0][0].getCenter());
		//stage = mapGen.createActorListeners(tileMap);
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
		
		try
		{
		tileMap[x][y].selectNormal();
		}
		catch(IndexOutOfBoundsException e)
		{
//			e.printStackTrace();
			System.err.println("PLEASE SELECT A VALID TILE DUM DUM");
		}
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
