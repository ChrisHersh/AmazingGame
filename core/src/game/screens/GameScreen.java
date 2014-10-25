package game.screens;

import game.GameMessenger;
import game.MyGdxGame;
import game.helpers.TileClickHelper;
import game.input.MapInputHandler;
import game.world.GameMap;
import game.world.GameRenderer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen
{
	private GameMap map;
	private GameRenderer renderer;
	private MapInputHandler input;
	private TileClickHelper clickHelper;
	private static MyGdxGame game;
	
	public GameScreen(int numPlayers, MyGdxGame currentGame)
	{
		map = new GameMap(numPlayers, this);
		renderer = new GameRenderer(map, 1000, 1000, map.getStage());
		input = new MapInputHandler(renderer, map);
		clickHelper = new TileClickHelper(map.getTileMap());
		
		GameMessenger gm = GameMessenger.getInstance();
		gm.setMap(map);
		gm.setRenderer(renderer);
		gm.setScreen(this);
		gm.setTileClickHelper(clickHelper);
		
		Gdx.input.setInputProcessor(input);
		
		game = currentGame;
//		Gdx.input.setInputProcessor(map.getStage());
	}
	
	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0, 0, 1, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		map.update(delta);
		renderer.render(delta);
	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		
	}

	public void recieveMessage(String msg)
	{
		// TODO Messenger system method, may remove later
		
	}

	public static void gameOver(int player)
	{
		// TODO Auto-generated method stub
		game.changeGameScreen(new GameOverScreen(player));
	}

	public void winningPlayer(int i)
	{
		// TODO change gamescreen to say player i won
		
	}

	public void noWinningPlayer()
	{
		// TODO change game screen to say no one won
		
	}

}
