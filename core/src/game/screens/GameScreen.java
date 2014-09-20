package game.screens;

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
	
	public GameScreen()
	{
		// TODO Auto-generated constructor stub
		map = new GameMap();
		renderer = new GameRenderer(map, 1000, 1000);
		input = new MapInputHandler(renderer);
		
		Gdx.input.setInputProcessor(input);
	}
	
	@Override
	public void render(float delta)
	{
		// TODO Auto-generated method stub
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

}
