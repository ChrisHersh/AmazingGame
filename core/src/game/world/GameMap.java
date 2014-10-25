package game.world;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

import game.generator.MapGenerator;
import game.helpers.AssetLoader;
import game.helpers.MapHelper;
import game.objects.TileSprite;
import game.objects.Unit;
import game.screens.GameScreen;

public class GameMap
{
	private MapGenerator mapGen;
	private TileSprite[][] tileMap;
	private Unit[][] units;
	private Stage stage;
	private MapHelper mapHelper;
	
	private int previousSelectX;
	private int previousSelectY;
	private boolean tileIsSelected= false;
	
	private GameScreen screen;
	
	public GameMap(int numPlayers, GameScreen screen)
	{
		mapGen = new MapGenerator();
		tileMap = mapGen.generate(100, 100);
		
		units = new Unit[numPlayers][];
		for(int i = 0; i < numPlayers; i++)
		{
			units[i] = mapGen.generateUnits(i);
		}
		
		mapHelper = new MapHelper(tileMap);
		System.out.println(tileMap[0][0].getCenter());
		//stage = mapGen.createActorListeners(tileMap);
		
		this.screen = screen;
	}
	
	public void update(float delta)
	{
		boolean living[] = new boolean[units.length];
		
		int numLiving = 0;
		for(int i  = 0; i < units.length; i++)
		{
			boolean dead = true;
			for(int j  = 0; j < units[i].length; j++)
			{
				if(units[i][j].isAlive())
				{
					dead = false;
				}
			}
			if(!dead)
			{
				numLiving++;
				living[i] = true;
			}
		}
		
		if(numLiving == 1)
		{
			int winningPlayer = -1;
			for(int i  = 0; i < living.length; i++)
			{
				if(living[i])
				{
					screen.winningPlayer(i);
				}
			}
		}
		else if(numLiving == 0)
		{
			screen.noWinningPlayer();
		}
	}
	
	public TileSprite[][] getTileMap()
	{
		return tileMap;
	}
	
	public Unit[][] getUnits()
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
