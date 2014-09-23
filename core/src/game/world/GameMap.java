package game.world;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

import game.generator.MapGenerator;
import game.helpers.AssetLoader;
import game.helpers.UnitController;
import game.objects.TileSprite;
import game.objects.Unit;

public class GameMap
{
	private MapGenerator mapGen;
	private TileSprite[][] tileMap;
	private Unit[] units;
	private Stage stage;
	private UnitController unitCon;
	
	private int previousSelectX;
	private int previousSelectY;
	private boolean tileIsSelected= false;
	
	public GameMap()
	{
		mapGen = new MapGenerator();
		tileMap = mapGen.generate(512, 512);
		units = mapGen.generateRedTeamUnits();
		unitCon = new UnitController();
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
	
	public Unit[] getUnits()
	{
		return units;
	}

	public void selectTile(int x, int y)
	{
		try
		{
			if(tileMap[x][y].getUnit() != null)
			{
				unitCon.selectMovementTiles(tileMap[x][y].getUnit(), tileMap, x, y);
			}
			
			if(!tileIsSelected)
			{
				tileMap[x][y].selectNormal();
				tileIsSelected = true;
			}
			else if(x != previousSelectX || y != previousSelectY)
			{
				tileMap[previousSelectX][previousSelectY].selectNormal();
				tileMap[x][y].selectNormal();
				tileIsSelected = true;
			}
			else
			{
				tileMap[x][y].selectNormal();
				tileIsSelected = false;
			}
			previousSelectX = x;
			previousSelectY = y;
		}
		catch(IndexOutOfBoundsException e)
		{
//			e.printStackTrace();
			System.err.println("PLEASE SELECT A VALID TILE DUM DUM");
		}
	}

	public void recieveMessage(String msg)
	{
		// TODO Messenger system method, may remove later
	}
	
	public Stage getStage()
	{
		return stage;
	}
}
