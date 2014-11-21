package game.screens;

import game.MyGdxGame;
import game.input.MapInputHandler;
import game.world.GameMap;
import game.world.GameRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen
{
	private GameMap map;
	private GameRenderer renderer;
	private MapInputHandler input;

	
	public GameScreen(int numPlayers, MyGdxGame currentGame)
	{
		map = new GameMap(numPlayers);
		renderer = new GameRenderer(map, 1000, 1000, map.getStage());
		input = new MapInputHandler(renderer, map);

		
		Gdx.input.setInputProcessor(input);
		
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
		
	}

	@Override
	public void show()
	{
		
	}

	@Override
	public void hide()
	{
		
	}

	@Override
	public void pause()
	{
		
	}

	@Override
	public void resume()
	{
		
	}

	@Override
	public void dispose()
	{
		
	}


	public void winningPlayer(int i)
	{
		
	}

	public void noWinningPlayer()
	{
		
	}

}
