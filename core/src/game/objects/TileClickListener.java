package game.objects;

import game.Destination;
import game.GameMessenger;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class TileClickListener extends ClickListener
{
	private TileSprite actor;
	
	public TileClickListener(TileSprite act)
	{
		actor = act;
	}
	
	@Override
    public void clicked(InputEvent event, float x, float y) 
	{
		GameMessenger.getInstance().sendMessage(Destination.TILE_CLICK_HELPER,
				"SELECT " + (int)x + " " + (int)y);
    }
}
