package game.input;

import game.world.GameMap;
import game.world.GameRenderer;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class MapInputHandler implements InputProcessor
{
	private GameRenderer renderer;
	private GameMap map;
	
	private boolean mouseDown = false;
	private long downStartTime = 0;
	
	private int mouseMoveX;
	private int mouseMoveY;
	
	private OrthographicCamera cam;
	
	public MapInputHandler(GameRenderer renderer, GameMap map)
	{
		this.renderer = renderer;
		this.map = map;
		cam = renderer.getCam();
	}
	
	@Override
	public boolean keyDown(int keycode)
	{
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		return false;
	}

	@Override
	public boolean keyTyped(char character)
	{
		if(character == 'f')
		{
			renderer.toggleFPS();
		}
		else if(character == ' ')
		{
			map.endTurn();
		}
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		mouseDown = true;
		downStartTime = System.nanoTime();
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		long endTime = System.nanoTime();
		if((endTime-downStartTime) <= (.25*1000*1000*1000) && mouseDown)
		{
			if(button == 0)
			{
				Vector3 v3 = new Vector3(screenX, screenY, 0);
				renderer.getCam().unproject(v3);
				map.selectTile((int)(v3.x+32)/64, (int)(v3.y+32)/64);
				mouseDown = false;
			}
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
//		System.out.println("X - > " + (screenX-mouseMoveX) + " Y - > " + (screenY-mouseMoveY));
		
		cam.translate((screenX-mouseMoveX)*-1, (screenY-mouseMoveY)*-1);
		cam.update();
		mouseMoveX= screenX;
		mouseMoveY = screenY;
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		mouseMoveX= screenX;
		mouseMoveY = screenY;
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{		
		if(amount == -1)
			cam.zoom -= (cam.zoom*.1) + .1;
		if(amount == 1)
			cam.zoom += (cam.zoom*.1) + .1;
//		System.out.println(cam.zoom);
		cam.update();
		return false;
	}

}
