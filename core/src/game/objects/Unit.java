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

	// TODO turn these into an Enum
	private int health = 100;
	private int attack = 5;
	private int speed = 6;
	private int defense = 1;
	private int movement = 10;

	private int attackRange = 2;

	private int teamNum;

	private boolean alive;
	private boolean hasMoved;
	private boolean hasAttacked;

	public Unit(TextureRegion region, int teamNum)
	{
		sprite = new Sprite(region);
		originalTexture = region;
		this.teamNum = teamNum;
		alive = true;
		hasAttacked = false;
		hasMoved = false;
	}

	public void draw(Batch batch)
	{
		if (alive)
		{
			sprite.draw(batch);
			setCenter();
		}
	}

	public void setTerrain(TileSprite newTerr)
	{
		if (terrain != null)

			terrain.currentUnit = null;
		else if (newTerr != null)
		{
			terrain = newTerr;
			terrain.currentUnit = this;
		} else
		{
			terrain = newTerr;
		}
	}

	public Vector2 getTerrainLocation()
	{
		return new Vector2(terrain.x, terrain.y);
	}

	public void setCenter()
	{
		// TODO remove magic numbers
		sprite.setCenter(terrain.x * 64, terrain.y * 64);
	}

	public int getMovement()
	{
		return movement;
	}

	public boolean moveTo(int x, int y, TileSprite targetTile)
	{
		if(!hasMoved)
		{
		if (targetTile.getUnit() != null)
		{
			System.err.println("Multiple Units ERR");
			return false;
		}

		targetTile.setUnit(this);
		terrain.setUnit(null);
		terrain = targetTile;
		hasMoved = true;
		
		return true;
		}
		return false;

	}

	public int getAttackRange()
	{
		return attackRange;
	}

	public int getTeam()
	{
		return teamNum;
	}

	protected void takeHit(int damage)
	{
		int tmp = damage - defense;
		if (tmp < 0)
			tmp = 0;

		health -= tmp;
		System.out.println("New HP: " + health);

		if (health <= 0)
		{
			die();
		}
	}

	protected void die()
	{
		terrain.setUnit(null);
		terrain = null;
		alive = false;
	}

	public void attack(Unit unit)
	{
		if (!hasAttacked)
		{
			unit.takeHit(attack);
			hasAttacked = true;
		}
	}

	public boolean isAlive()
	{
		return alive;
	}
	
	public boolean hasMoved()
	{
		return hasMoved;
	}
	
	public boolean hasAttacked()
	{
		return hasAttacked;
	}
	
	public void resetMove()
	{
		hasMoved = false;
	}
	
	public void resetAttack()
	{
		hasAttacked = false;
	}
}
