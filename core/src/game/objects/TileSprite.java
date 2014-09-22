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

	private int movementCost = 1;
	private int defenseBonus = 0;
	private int attackBonus = 0;
	private Unit currentUnit = null;
	private int x;
	private int y;
	private boolean isSelected = false;

	public TileSprite(TextureRegion region, int x, int y)
	{
		// TODO Auto-generated constructor stub
		sprite = new Sprite(region);
		originalTexture = region;
		this.x = x;
		this.y = y;
	}

	public void draw(Batch batch)
	{
		sprite.draw(batch);
	}

	public void setCenter(float x, float y)
	{
		sprite.setCenter(x, y);
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
		// TODO Auto-generated method stub
		return isSelected;
	}
	
	public Vector3 getCenter()
	{
		return new Vector3(sprite.getX(), sprite.getY(), 0);
	}
}
