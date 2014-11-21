package game.world;

import game.helpers.AssetLoader;
import game.helpers.Constants;
import game.objects.TileSprite;
import game.objects.Unit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameRenderer
{
	private GameMap map;
	private OrthographicCamera cam;
	private Stage stage;

	// private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;

	private TextureRegion tile;

	private Sprite sp;
	private TileSprite[][] currentMap;
	private Unit[][] currentUnits;
	boolean showFPS;

	public GameRenderer(GameMap map, int gameWidth, int gameHeight, Stage stage)
	{
		this.map = map;

		cam = new OrthographicCamera();
		cam.setToOrtho(true, gameWidth, gameHeight);

		batcher = new SpriteBatch();
		// Attach batcher to camera
		batcher.setProjectionMatrix(cam.combined);

		// shapeRenderer = new ShapeRenderer();
		// shapeRenderer.setProjectionMatrix(cam.combined);

		tile = AssetLoader.basicTile;

		sp = new Sprite(tile);

		currentMap = map.getTileMap();
		currentUnits = map.getUnits();

//		this.stage = stage;
//		stage.getViewport().setCamera(cam);
	}

	public void render(float delta)
	{
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batcher.setProjectionMatrix(cam.combined);
		batcher.begin();
		batcher.enableBlending();

		
		
		drawMap();
		drawUnits();

		if (showFPS)
		{
			System.err.println(1 / delta);
		}

		batcher.end();
	}

	public void drawMap()
	{
		for (int x = 0; x < currentMap.length; x++)
		{
			for (int y = 0; y < currentMap[x].length; y++)
			{
				if (cam.frustum.boundsInFrustum(currentMap[x][y].getCenter(),
						new Vector3(Constants.mapHeight*2, Constants.mapWidth*2, 0)))
				{
					currentMap[x][y].draw(batcher);
//					currentMap[x][y].setCenter(x * 64, y * 64);
				}
			}
		}
	}
	
	public void drawUnits()
	{
		for(Unit[] ua : currentUnits)
		{
			for(Unit u : ua)
			{
				u.draw(batcher);
			}
		}
	}

	public OrthographicCamera getCam()
	{
		return cam;
	}

	public void toggleFPS()
	{
		showFPS = !showFPS;
	}

	public void selectTile(int x, int y)
	{
		map.selectTile(x, y);
	}
}
