package game.input;

import game.world.GameRenderer;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class MapInputHandler implements InputProcessor
{
	private GameRenderer renderer;
	
	private boolean mouseDown = false;
	private long downStartTime = 0;
	
	private int mouseMoveX;
	private int mouseMoveY;
	
	private OrthographicCamera cam;
	
	public MapInputHandler(GameRenderer renderer)
	{
		this.renderer = renderer;
		cam = renderer.getCam();
	}
	
	@Override
	public boolean keyDown(int keycode)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character)
	{
		// TODO Auto-generated method stub
		if(character == 'f')
		{
			renderer.toggleFPS();
		}
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		// TODO Auto-generated method stub
		mouseDown = true;
		downStartTime = System.nanoTime();
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		// TODO Auto-generated method stub
		
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		//TODO Refine the drag system even more
		System.out.println("X - > " + (screenX-mouseMoveX) + " Y - > " + (screenY-mouseMoveY));
		
		cam.translate((screenX-mouseMoveX)*-1, (screenY-mouseMoveY)*-1);
		cam.update();
		mouseMoveX= screenX;
		mouseMoveY = screenY;
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		// TODO Auto-generated method stub
		mouseMoveX= screenX;
		mouseMoveY = screenY;
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		// TODO Refine the zoom system even more, increment changes depending on current zoom?
		
		if(amount == -1)
			cam.zoom -= .1;
		if(amount == 1)
			cam.zoom += .1;
		System.out.println(cam.zoom);
		cam.update();
		return false;
	}

}
