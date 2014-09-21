package game.world;

import game.helpers.AssetLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class GameRenderer 
{
	private GameMap map;
	private OrthographicCamera cam;
	
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;
	
	private TextureRegion tile;
	
	private int originX = 0, originY = 0;
	
	private Sprite sp;
	
	private Sprite[][] currentMap;
	
	private boolean showFPS;
	
	public GameRenderer(GameMap map, int gameWidth, int gameHeight)
	{
		this.map = map;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, gameWidth, gameHeight);

		batcher = new SpriteBatch();
		// Attach batcher to camera
		batcher.setProjectionMatrix(cam.combined);

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		tile = AssetLoader.basicTile;
		
		sp = new Sprite(tile);
		
		currentMap = map.getTileMap();
	}
	
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batcher.setProjectionMatrix(cam.combined);
		batcher.begin();
		batcher.disableBlending();
		
//		batcher.draw(tile, originX, originY, 64, 64);
//		batcher.draw(tile, originX+64, originY, 64, 64);
//		batcher.draw(tile, originX, originY+64, 64, 64);
//		batcher.draw(tile, originX+64, originY+64, 64, 64);
		
//		sp.draw(batcher);
//		sp.setCenter(32, 32);
		
		for(int x = 0; x < currentMap.length; x++)
		{
			for(int y = 0; y < currentMap.length; y++)
			{
				currentMap[x][y].draw(batcher);
				currentMap[x][y].setCenter(32+x*64, 32+y*64);
			}
		}
		if(showFPS)
		{
			System.err.println(1/delta);
		}
		batcher.end();
	}
	
	public void drawMap()
	{
	}
	
	public OrthographicCamera getCam()
	{
		return cam;
	}

	public void toggleFPS()
	{
		showFPS = !showFPS;
	}
}
