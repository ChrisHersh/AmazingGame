package game.world;

import game.helpers.AssetLoader;
import game.objects.TileSprite;

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

		if (showFPS)
		{
			System.err.println(1 / delta);
		}

		batcher.end();
	}

	public void drawMap()
	{
		// Vector3 position = cam.position;
		// float width = cam.viewportWidth;
		// float height = cam.viewportHeight;
		//
		// int lowX = (int)(position.x-width/2)-10;
		// int highX = (int)(position.x+width/2)+10;
		// int lowY = (int)(position.x-height/2)-10;
		// int highY = (int)(position.x+height/2)+10;
		//
		// if(highX >= currentMap.length) highX = currentMap.length-1;
		// if(lowX < 0) lowX = 0;
		// if(highY >= currentMap[0].length) highY = currentMap[0].length-1;
		// if(lowY < 0) lowY = 0;
		//
		// for(int x = lowX; x < highX; x++)
		// {
		// for(int y = lowY; y < highY; y++)
		// {
		// //TODO remove magic numbers (64)
		// currentMap[x][y].draw(batcher);
		// currentMap[x][y].setCenter(x*64, y*64);
		// }
		// }

		for (int x = 0; x < currentMap.length; x++)
		{
			for (int y = 0; y < currentMap[x].length; y++)
			{
				// TODO remove magic numbers (64)
				if (cam.frustum.boundsInFrustum(currentMap[x][y].getCenter(),
						new Vector3(64*2, 64*2, 0)))
				{
					currentMap[x][y].draw(batcher);
					currentMap[x][y].setCenter(x * 64, y * 64);
				}
			}
		}
	}

	public void drawUnits()
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

	public void selectTile(int x, int y)
	{
		System.out.println("x " + x);
		System.out.println("y " + y);
		map.selectTile(x, y);
	}

	public void recieveMessage(String msg)
	{
		// TODO Auto-generated method stub

	}
}
