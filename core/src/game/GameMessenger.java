package game;

import game.helpers.TileClickHelper;
import game.screens.GameScreen;
import game.world.GameMap;
import game.world.GameRenderer;

public class GameMessenger
{
	private static GameMessenger me;
	private GameRenderer renderer;
	private GameScreen screen;
	private GameMap map;
	private TileClickHelper clickHelper;
	
	public static GameMessenger getInstance()
	{
		if(me == null)
		{
			me = new GameMessenger();
		}
		return me;
	}
	
	public void sendMessage(Destination dest, String msg)
	{
		System.out.println(dest);
		System.out.println(msg);
		switch (dest)
		{
		case GAME_RENDERER:
			renderer.recieveMessage(msg);
			break;
		case GAME_SCREEN:
			screen.recieveMessage(msg);
			break;
		case GAME_MAP:
			map.recieveMessage(msg);
			break;
		case TILE_CLICK_HELPER:
			clickHelper.recieveMessage(msg);
			break;
		}
			
	}
	
	public void setRenderer(GameRenderer render)
	{
		this.renderer = render;
	}
	
	public void setScreen(GameScreen screen)
	{
		this.screen = screen;
	}
	public void setMap(GameMap map)
	{
		this.map = map;
	}
	public void setTileClickHelper(TileClickHelper clickHelp)
	{
		this.clickHelper = clickHelp;
	}
}
