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
	private Sprite overlay;

	public int movementCost = 1;
	private int defenseBonus = 0;
	private int attackBonus = 0;
	protected Unit currentUnit = null;
	protected int x;
	protected int y;
	private boolean isSelected = false;
	private boolean movementSelected = false;

	public TileSprite(TextureRegion region, int x, int y)
	{
		sprite = new Sprite(region);
		overlay = new Sprite(AssetLoader.redOverlay);
		originalTexture = region;
		this.x = x;
		this.y = y;
	}

	public void draw(Batch batch)
	{
		sprite.draw(batch);
		if(movementSelected)
			overlay.draw(batch);
		setCenter();
	}

	public void setCenter()
	{
		//TODO remove magic numbers
		sprite.setCenter(x*64, y*64);
		if(movementSelected)
			overlay.setCenter(x*64, y*64);
	}

	public void resetTexture()
	{
		sprite.setRegion(originalTexture);
		isSelected = false;
		
	}

	public void changeTexture(TextureRegion region)
	{
		sprite.setRegion(region);
	}

	public void selectNormal()
	{
		System.out.println("Select Normal -> " + isSelected);
		if (isSelected)
			resetTexture();
		else
		{
			changeTexture(AssetLoader.basicInvert);
			isSelected = true;
		}

//		isSelected = !isSelected;
	}

	public void selectMovement()
	{
		// TODO change this
//		changeTexture(AssetLoader.basicInvert);
//		isSelected = true;
		movementSelected = true;
	}
	
	public void unSelectMovement()
	{
		movementSelected = false;
	}

	public void selectAttackRange()
	{
		// TODO change this
		changeTexture(AssetLoader.basicInvert);
		isSelected = true;
	}

	public boolean setUnit(Unit newUnit)
	{
		if (currentUnit != null && newUnit != null)
		{
			System.err.println("MULTIPLE UNITS ON ONE TILE");
			return false;
		}
		if(newUnit == null)
		{
			currentUnit.setTerrain(null);
			currentUnit = null;
		}
		currentUnit = newUnit;
		currentUnit.setTerrain(this);
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

}
