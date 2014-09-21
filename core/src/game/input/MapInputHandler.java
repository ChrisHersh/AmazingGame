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
//		if(mouseDown)
//		{
//    		long totalDownTime = System.nanoTime() - downStartTime;
//    		if(totalDownTime >= 1*1000*1000*1000)
//    		{
//    			renderer.moveMap(screenX-mouseDownX, screenY-mouseDownY);
//    		}
//    		mouseDown = false;
//    		downStartTime = 0l;
//		}
		
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		
//		System.out.println("X - > " + screenX + " Y - > " + screenY);
//		renderer.moveMap(screenX, screenY);
		System.out.println("X - > " + (screenX-mouseMoveX) + " Y - > " + (screenY-mouseMoveY));
		
		cam.translate((screenX-cam.position.x)/100, (screenY-cam.position.y)/100);
		cam.update();
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		// TODO Auto-generated method stub
		mouseMoveX = screenX;
		mouseMoveY = screenY;
		
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		// TODO Auto-generated method stub
		if(amount == -1)
			cam.zoom -= .1;
		if(amount == 1)
			cam.zoom += .1;
		cam.update();
		System.out.println(amount);
		return false;
	}

}
