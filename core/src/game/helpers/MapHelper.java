package game.helpers;

import java.util.ArrayList;
import java.util.HashSet;

import game.objects.TileSprite;
import game.objects.Unit;
import game.world.PlayerManager;

public class MapHelper
{
	private TileSprite[][] map;
	private HashSet<TileSprite> selectedMovementTiles;
	private TileSprite selectedNormalTile;
	private boolean normalTileSelected;
	private HashSet<TileSprite> selectedAttackTiles;

	private Unit lastSelectedUnit;

	private int previousX;
	private int previousY;

	public MapHelper(TileSprite[][] map)
	{
		this.map = map;
		normalTileSelected = false;
		selectedAttackTiles = new HashSet<TileSprite>();
		selectedMovementTiles = new HashSet<TileSprite>();
		selectedNormalTile = null;

		previousX = -1;
		previousY = -1;

		lastSelectedUnit = null;
	}

	private void selectMovementTiles(Unit unit, int x, int y)
	{
		recurseIntoMovement(unit, x - 1, y, unit.getMovement() - 1);
		recurseIntoMovement(unit, x + 1, y, unit.getMovement() - 1);
		recurseIntoMovement(unit, x, y - 1, unit.getMovement() - 1);
		recurseIntoMovement(unit, x, y + 1, unit.getMovement() - 1);

		massSelectMovementTiles();
		massSelectAttackTiles();
	}

	private void massSelectMovementTiles()
	{
		for (TileSprite ts : selectedMovementTiles)
		{
			ts.selectMovement();
		}
	}

	private void massSelectAttackTiles()
	{
		for (TileSprite ts : selectedAttackTiles)
		{
			ts.selectAttackRange();
		}
	}

	private void recurseIntoMovement(Unit unit, int x, int y, int movementLeft)
	{
		if (movementLeft >= map[x][y].getMovementCost()
				&& map[x][y].getUnit() == null)
		{
			// map[x][y].selectMovement();
			selectedMovementTiles.add(map[x][y]);

			try
			// Up
			{
				if (map[x][y - 1].getUnit() == null)
				{
					// map[x][y - 1].selectMovement();
					selectedMovementTiles.add(map[x][y - 1]);
					recurseIntoMovement(unit, x, y - 1, movementLeft
							- map[x][y].getMovementCost());
				}
			} catch (IndexOutOfBoundsException e)
			{
			}

			try
			// Down
			{
				if (map[x][y + 1].getUnit() == null)
				{
					// map[x][y + 1].selectMovement();
					selectedMovementTiles.add(map[x][y + 1]);
					recurseIntoMovement(unit, x, y + 1, movementLeft
							- map[x][y].getMovementCost());
				}
			} catch (IndexOutOfBoundsException e)
			{
			}

			try
			// Left
			{
				if (map[x - 1][y].getUnit() == null)
				{
					// map[x - 1][y].selectMovement();
					selectedMovementTiles.add(map[x - 1][y]);
					recurseIntoMovement(unit, x - 1, y, movementLeft
							- map[x][y].getMovementCost());
				}
			} catch (IndexOutOfBoundsException e)
			{
			}

			try
			// Right
			{
				if (map[x + 1][y].getUnit() == null)
				{
					// map[x + 1][y].selectMovement();
					selectedMovementTiles.add(map[x + 1][y]);
					recurseIntoMovement(unit, x + 1, y, movementLeft
							- map[x][y].getMovementCost());
				}
			} catch (IndexOutOfBoundsException e)
			{
			}
		}

		else
		{
			// map[x][y].selectMovement();
			// selectedMovementTiles.add(map[x][y]);
			recurseIntoAttack(unit, x - 1, y, unit.getAttackRange());
			recurseIntoAttack(unit, x + 1, y, unit.getAttackRange());
			recurseIntoAttack(unit, x, y - 1, unit.getAttackRange());
			recurseIntoAttack(unit, x, y + 1, unit.getAttackRange());
		}
	}

	private void recurseIntoAttack(Unit unit, int x, int y, int attackLeft)
	{
		if (attackLeft >= 1 && !selectedMovementTiles.contains(map[x][y]))
		{
			// map[x][y].selectAttackRange();
			selectedAttackTiles.add(map[x][y]);

			try
			// Up
			{
				recurseIntoAttack(unit, x, y - 1, attackLeft - 1);
			} catch (IndexOutOfBoundsException e)
			{
			}

			try
			// Down
			{
				recurseIntoAttack(unit, x, y + 1, attackLeft - 1);
			} catch (IndexOutOfBoundsException e)
			{
			}

			try
			// Left
			{
				recurseIntoAttack(unit, x - 1, y, attackLeft - 1);
			} catch (IndexOutOfBoundsException e)
			{
			}

			try
			// Right
			{
				recurseIntoAttack(unit, x + 1, y, attackLeft - 1);
			} catch (IndexOutOfBoundsException e)
			{
			}
		}
	}

	public void selectTile(int x, int y)
	{
		if (!(x < map.length && y < map[0].length && x > -1 && y > -1))
		{
			System.err.println("OutOfBoundsOfMap");
		} else if (selectedMovementTiles.contains(map[x][y]))
		{
			if (lastSelectedUnit.getTeam() == PlayerManager.getCurrPlayerTurn())
			{
				unitMove(x, y);
			}
			else
			{
				unSelectTiles();
				selectTileNormal(x, y);
			}
		} else if (selectedAttackTiles.contains(map[x][y]))
		{
			if (lastSelectedUnit.getTeam() == PlayerManager.getCurrPlayerTurn())
			{
				unitAttack(x, y);
			}
			else
			{
				unSelectTiles();
				selectTileNormal(x, y);
			}
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
			} else if (x != previousX || y != previousY)
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
		if (map[x][y].getUnit() != null)
		{
			unitAttack(x, y);
		} else
		{
			System.err.println("Unit Moved");
			lastSelectedUnit.moveTo(x, y, map[x][y]);
		}
		unSelectTiles();
	}

	private void unitAttack(int x, int y)
	{
		unSelectTiles();
		recurseIntoAttack(lastSelectedUnit,
				(int) lastSelectedUnit.getTerrainLocation().x,
				(int) lastSelectedUnit.getTerrainLocation().y,
				lastSelectedUnit.getAttackRange() + 1);

		if ((lastSelectedUnit.getTeam() != map[x][y].getUnit().getTeam())
				&& selectedAttackTiles.contains(map[x][y]))
		{
			lastSelectedUnit.attack(map[x][y].getUnit());
		}
		unSelectTiles();
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
			ts.unSelectAttack();
		}
		selectedAttackTiles.clear();
	}
}
