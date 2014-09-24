package game.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Unit
{
	private Sprite sprite;
	private TextureRegion originalTexture;
	
	private TileSprite terrain;
	
	//TODO turn these into an Enum
	private int health = 100;
	private int attack = 5;
	private int speed = 6;
	private int defense = 10;
	private int movement = 10;
	
	public Unit(TextureRegion region)
	{
		sprite = new Sprite(region);
		originalTexture = region;
	}
	
	public void draw(Batch batch)
	{
		sprite.draw(batch);
		setCenter();
	}
	
	public void setTerrain(TileSprite newTerr)
	{
		if(terrain != null)
			terrain.currentUnit = null;
		
		terrain = newTerr;
		terrain.currentUnit = this;
	}
	
	public Vector2 getTerrainLocation()
	{
		return new Vector2(terrain.x, terrain.y);
	}
	
	public void setCenter()
	{
		//TODO remove magic numbers
		sprite.setCenter(terrain.x*64, terrain.y*64);
	}
	
	public int getMovement()
	{
		return movement;
	}

	public void moveTo(int x, int y)
	{
		// TODO Auto-generated method stub
		
	}
}
