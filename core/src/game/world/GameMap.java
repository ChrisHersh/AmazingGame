package game.world;

import com.badlogic.gdx.scenes.scene2d.Stage;

import game.generator.MapGenerator;
import game.helpers.MapHelper;
import game.objects.TileSprite;
import game.objects.Unit;

public class GameMap
{
	private MapGenerator mapGen;
	private TileSprite[][] tileMap;
	private Unit[][] units;
	private Stage stage;
	private MapHelper mapHelper;


	public GameMap(int numPlayers)
	{
		mapGen = new MapGenerator();
		tileMap = mapGen.generate(100, 100);

		units = new Unit[numPlayers][];
		for (int i = 0; i < numPlayers; i++)
		{
			units[i] = mapGen.generateUnits(i);
			PlayerManager.addNewPlayer();
		}

		mapHelper = new MapHelper(tileMap);
		System.out.println(tileMap[0][0].getCenter());
		// stage = mapGen.createActorListeners(tileMap);
	}

	public void update(float delta)
	{

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


	public Stage getStage()
	{
		return stage;
	}

	public void endTurn()
	{
		PlayerManager.endTurn();
		for (Unit u : units[PlayerManager.getCurrPlayerTurn()])
		{
			u.resetAttack();
			u.resetMove();
		}
	}
}
