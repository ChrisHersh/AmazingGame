package game.helpers;

import java.util.ArrayList;

import game.objects.TileSprite;
import game.objects.Unit;

public class MapHelper
{
	private TileSprite[][] map;
	private ArrayList<TileSprite> selectedMovementTiles;
	private TileSprite selectedNormalTile;
	private boolean normalTileSelected;
	private ArrayList<TileSprite> selectedAttackTiles;
	
	private Unit lastSelectedUnit;

	private int previousX;
	private int previousY;

	public MapHelper(TileSprite[][] map)
	{
		// TODO Auto-generated constructor stub
		this.map = map;
		normalTileSelected = false;
		selectedAttackTiles = new ArrayList<TileSprite>();
		selectedMovementTiles = new ArrayList<TileSprite>();
		selectedNormalTile = null;

		previousX = -1;
		previousY = -1;
		
		lastSelectedUnit = null;
	}

	private void selectMovementTiles(Unit unit, int x, int y)
	{
		recurseIntoMovement(unit, x, y, unit.getMovement());
	}

	private void recurseIntoMovement(Unit unit, int x, int y, int movementLeft)
	{
		if (movementLeft >= map[x][y].getMovementCost())
		{
			map[x][y].selectMovement();
			selectedMovementTiles.add(map[x][y]);

			try
			// Up
			{
				map[x][y - 1].selectMovement();
				selectedMovementTiles.add(map[x][y - 1]);
				recurseIntoMovement(unit, x, y - 1,
						movementLeft - map[x][y].getMovementCost());
			} catch (IndexOutOfBoundsException e)
			{
			}

			try
			// Down
			{
				map[x][y + 1].selectMovement();
				selectedMovementTiles.add(map[x][y + 1]);
				recurseIntoMovement(unit, x, y + 1,
						movementLeft - map[x][y].getMovementCost());
			} catch (IndexOutOfBoundsException e)
			{
			}

			try
			// Left
			{
				map[x - 1][y].selectMovement();
				selectedMovementTiles.add(map[x - 1][y]);
				recurseIntoMovement(unit, x - 1, y,
						movementLeft - map[x][y].getMovementCost());
			} catch (IndexOutOfBoundsException e)
			{
			}

			try
			// Right
			{
				map[x + 1][y].selectMovement();
				selectedMovementTiles.add(map[x + 1][y]);
				recurseIntoMovement(unit, x + 1, y,
						movementLeft - map[x][y].getMovementCost());
			} catch (IndexOutOfBoundsException e)
			{
			}
		}

		else
		{
			map[x][y].selectMovement();
		}
	}

	public void selectTile(int x, int y)
	//Mayo
	{
		if(!(x < map.length && y < map[0].length && x > -1 && y > -1))
		{
			System.err.println("OutOfBoundsOfMap");
		}
		else if (selectedMovementTiles.contains(map[x][y]))
		{
			unitMove(x, y);
		} else if (selectedAttackTiles.contains(map[x][y]))
		{
			unitAttack(x, y);
		} else
		{
			unSelectTiles();
			selectTileNormal(x, y);
		}
	}

	private void selectTileNormal(int x, int y)
	{
		try
		{
			if (map[x][y].getUnit() != null)
			{
				lastSelectedUnit = map[x][y].getUnit();
				if (normalTileSelected)
					unSelectNormal();
				selectMovementTiles(map[x][y].getUnit(), x, y);
			}

			else if (!normalTileSelected)
			{
				map[x][y].selectNormal();
				normalTileSelected = true;
			}
			else if (x != previousX || y != previousY)
			{
				System.out.println("New Selection");
				map[previousX][previousY].selectNormal();
				map[x][y].selectNormal();
				normalTileSelected = true;
			} else
			{
				map[x][y].selectNormal();
				normalTileSelected = false;
			}
			previousX = x;
			previousY = y;
		} catch (IndexOutOfBoundsException e)
		{
			e.printStackTrace();
			System.err.println("PLEASE SELECT A VALID TILE");
		}
	}

	private void unSelectNormal()
	{
		normalTileSelected = false;
		map[previousX][previousY].selectNormal();
	}

	private void unitMove(int x, int y)
	{
		System.err.println("Unit Moved");
		lastSelectedUnit.setTerrain(map[x][y]);
		unSelectTiles();
		
	}

	private void unitAttack(int x, int y)
	{
		System.err.println("Unit Attacked");
	}

	private void unSelectTiles()
	{
		for (TileSprite ts : selectedMovementTiles)
		{
			ts.unSelectMovement();
		}
		selectedMovementTiles.clear();

		for (TileSprite ts : selectedAttackTiles)
		{
			ts.resetTexture();
		}
		selectedAttackTiles.clear();
	}
}
