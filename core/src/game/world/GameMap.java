package game.world;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

import game.generator.MapGenerator;
import game.helpers.AssetLoader;
import game.helpers.MapHelper;
import game.objects.TileSprite;
import game.objects.Unit;

public class GameMap
{
	private MapGenerator mapGen;
	private TileSprite[][] tileMap;
	private Unit[] units;
	private Stage stage;
	private MapHelper mapHelper;
	
	private int previousSelectX;
	private int previousSelectY;
	private boolean tileIsSelected= false;
	
	public GameMap()
	{
		mapGen = new MapGenerator();
		tileMap = mapGen.generate(64, 64);
		units = mapGen.generateRedTeamUnits();
		mapHelper = new MapHelper(tileMap);
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
		mapHelper.selectTile(x, y);
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
