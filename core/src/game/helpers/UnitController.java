package game.helpers;

import java.util.HashMap;

import com.badlogic.gdx.math.Vector2;

import game.objects.TileSprite;
import game.objects.Unit;

public class UnitController
{
	private int maxX, minX, maxY, minY;

	public void selectMovementTiles(Unit unit, TileSprite[][] map, int x, int y)
	{
		maxX = map.length;
		minX = -1;
		maxY = map[0].length;
		minY = -1;

		recurseIntoMovement(unit, map, x, y, unit.getMovement() + 1);


		// for (int key : movementRanges.keySet())
		// {
		// int selectX = (int) movementRanges.get(key).x;
		// int selectY = (int) movementRanges.get(key).y;
		// // System.out.println("Hello");
		// try
		// {
		// map[selectX][selectY].selectMovement();
		// } catch (Exception e)
		// {
		// // System.out.println("X " + selectX);
		// // System.out.println("Y " + selectY);
		// }
		// }
	}

	public void recurseIntoMovement(Unit unit, TileSprite[][] map, int x,
			int y, int movementLeft)
	{
		if (movementLeft > 0)
		{
			map[x][y].selectMovement();



			try
			{
				map[x][y-1].selectMovement();
				recurseIntoMovement(unit, map, x, y - 1, movementLeft
						- map[x][y].getMovementCost());
			} catch (IndexOutOfBoundsException e)
			{
			}

			try
			{
				// System.out.println(down.hashCode());
				map[x][y+1].selectMovement();
				recurseIntoMovement(unit, map, x, y + 1, movementLeft
						- map[x][y].getMovementCost());
			} catch (IndexOutOfBoundsException e)
			{
				// System.err.println("Out of bounds");
				// System.out.println("X " + x);
				// System.out.println("Y " + y);

			}

			try
			{
				// System.out.println(left.hashCode());
				map[x-1][y].selectMovement();
				recurseIntoMovement(unit, map, x - 1, y, movementLeft
						- map[x][y].getMovementCost());
			} catch (IndexOutOfBoundsException e)
			{
				// System.err.println("Out of bounds");
				// System.out.println("X " + x);
				// System.out.println("Y " + y);
			}

			try
			{
				// System.out.println(right.hashCode());
				map[x+1][y].selectMovement();
				recurseIntoMovement(unit, map, x + 1, y, movementLeft
						- map[x][y].getMovementCost());
			} catch (IndexOutOfBoundsException e)
			{
				// System.err.println("Out of bounds");
				// System.out.println("X " + x);
				// System.out.println("Y " + y);
			}
		}

		else
		{
			map[x][y].selectMovement();
		}
	}
}
