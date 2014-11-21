package game.objects;

import game.helpers.AssetLoader;
import game.helpers.Constants;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TileSprite// extends Actor
{
	private Sprite sprite;
	private TextureRegion originalTexture;
	private Sprite attackOverlay;
	private Sprite movementOverlay;

	public int movementCost = 1;
	protected int defenseBonus = 0;
	protected int attackBonus = 0;
	protected Unit currentUnit = null;
	protected int x;
	protected int y;
	private boolean isSelected = false;
	private boolean movementSelected = false;
	private boolean attackSelected = false;

	public TileSprite(TextureRegion region, int x, int y)
	{
		sprite = new Sprite(region);
		attackOverlay = new Sprite(AssetLoader.redOverlay);
		movementOverlay = new Sprite(AssetLoader.greenOverlay);
		originalTexture = region;
		this.x = x;
		this.y = y;
	}

	public void draw(Batch batch)
	{
		sprite.draw(batch);
		if(movementSelected)
			movementOverlay.draw(batch);
		else if(attackSelected)
			attackOverlay.draw(batch);
		setCenter();
	}

	private void setCenter()
	{
		sprite.setCenter(x*Constants.mapWidth, y*Constants.mapHeight);
		if(movementSelected)
			movementOverlay.setCenter(x*Constants.mapWidth, y*Constants.mapHeight);
		else if(attackSelected)
			attackOverlay.setCenter(x*Constants.mapWidth, y*Constants.mapHeight);
	}

	private void resetTexture()
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
		if (isSelected)
			resetTexture();
		else
		{
			changeTexture(AssetLoader.basicInvert);
			isSelected = true;
		}

	}
	
	public void unSelectNormal()
	{
		resetTexture();
	}

	public void selectMovement()
	{
		movementSelected = true;
	}
	
	public void unSelectMovement()
	{
		movementSelected = false;
	}

	public void selectAttackRange()
	{
		// TODO change this
		attackSelected = true;
	}
	
	public void unSelectAttack()
	{
		attackSelected = false;
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
			currentUnit = null;
		}
		else
		{
    		currentUnit = newUnit;
    		currentUnit.setTerrain(this);
		}
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
		return movementCost;
	}
	
	public boolean isMovementSelected()
	{
		return movementSelected;
	}
	
	public boolean isAttackSelected()
	{
		return attackSelected;
	}
	
	@Override
	public String toString()
	{
		return "("+x+","+y+")";
	}

    public int getDefenseBonus() {
        return defenseBonus;
    }
    
    public int getAttackBonus() {
        return attackBonus;
    }

}
