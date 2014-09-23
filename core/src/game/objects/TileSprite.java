package game.objects;

import game.helpers.AssetLoader;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TileSprite// extends Actor
{
	private Sprite sprite;
	private TextureRegion originalTexture;

	public int movementCost = 1;
	private int defenseBonus = 0;
	private int attackBonus = 0;
	protected Unit currentUnit = null;
	protected int x;
	protected int y;
	private boolean isSelected = false;
	private boolean selected = false;

	public TileSprite(TextureRegion region, int x, int y)
	{
		sprite = new Sprite(region);
		originalTexture = region;
		this.x = x;
		this.y = y;
	}

	public void draw(Batch batch)
	{
		sprite.draw(batch);
		setCenter();
	}

	public void setCenter()
	{
		//TODO remove magic numbers
		sprite.setCenter(x*64, y*64);
	}

	public void resetTexture()
	{
		sprite.setRegion(originalTexture);
	}

	public void changeTexture(TextureRegion region)
	{
		sprite.setRegion(region);
	}

	public void selectNormal()
	{
		if (isSelected)
			resetTexture();
		else
			changeTexture(AssetLoader.basicInvert);

		isSelected = !isSelected;
	}

	public void selectMovement()
	{
		// TODO change this
		changeTexture(AssetLoader.basicInvert);
		selected = true;
	}

	public void selectAttackRange()
	{
		// TODO change this
		changeTexture(AssetLoader.basicInvert);
	}

	public boolean setUnit(Unit newUnit)
	{
		if (currentUnit != null)
		{
			System.err.println("MULTIPLE UNITS ON ONE TILE");
			return false;
		}
		currentUnit = newUnit;
		return true;
	}

	public Unit getUnit()
	{
		return currentUnit;
	}

	public boolean isSelected()
	{
		return isSelected;
	}
	
	public Vector3 getCenter()
	{
		return new Vector3(sprite.getX(), sprite.getY(), 0);
	}

	public int getMovementCost()
	{
		// TODO Auto-generated method stub
		return movementCost;
	}
	
	public boolean getMovementSelected()
	{
		return selected;
	}
}
