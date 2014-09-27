package game.generator;

import game.helpers.AssetLoader;
import game.objects.TileClickListener;
import game.objects.TileSprite;
import game.objects.Unit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MapGenerator
{
	private TileSprite[][] terrainMap;
	
	public TileSprite[][] generate(int tileLengthX, int tileLengthY)
	{
		TileSprite[][] map = new TileSprite[tileLengthX][tileLengthY];
		
		TextureRegion basicTile = AssetLoader.basicTile;
		
		for(int x = 0; x < tileLengthX; x++)
		{
			for(int y = 0; y < tileLengthY; y++)
			{
				map[x][y] = new TileSprite(basicTile, x, y);
			}
		}
		
		//TODO remove this
//		map[1][3].movementCost = 3;
		
		terrainMap = map;
		return map;
	}
	
	public Unit[] generateRedTeamUnits()
	{
		//TODO generate the real read team
		Unit[] units = new Unit[6];
		units[0] = new Unit(AssetLoader.snorlax, 0);
		units[0].setTerrain(terrainMap[1][1]);
		
		units[1] = new Unit(AssetLoader.snorlax, 1);
		units[1].setTerrain(terrainMap[10][10]);
		
		units[2] = new Unit(AssetLoader.snorlax, 1);
		units[2].setTerrain(terrainMap[10][9]);
		
		units[3] = new Unit(AssetLoader.snorlax, 1);
		units[3].setTerrain(terrainMap[10][8]);
		
		units[4] = new Unit(AssetLoader.snorlax, 1);
		units[4].setTerrain(terrainMap[10][7]);
		
		units[5] = new Unit(AssetLoader.snorlax, 1);
		units[5].setTerrain(terrainMap[10][6]);
		return units;
	}
	
//	public Unit[] generateBlueTeamUnits()
//	{
//		//TODO generate the blue team
//	}
	
	public Unit[] generateGreenTeamUnits()
	{
		//They all teamkilled themselves, none are left
		return new Unit[0];
	}
	
//	public Stage createActorListeners(TileSprite[][] map)
//	{
//		Stage stage = new Stage(new ScreenViewport());
//		
//		for(int x = 0; x < map.length; x++)
//		{
//			for(int y = 0; y < map[x].length; y++)
//			{
//				//TODO remove magic numbers (64)
//                map[x][y].setBounds(x * 64, y * 64, 64, 64);
//                stage.addActor(map[x][y]);
//                EventListener eventListener = new TileClickListener(map[x][y]);
//                map[x][y].addListener(eventListener);
//			}
//		}
//		return stage;
//		
//	}
}
