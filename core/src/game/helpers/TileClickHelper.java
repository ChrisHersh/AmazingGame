package game.helpers;

import java.util.Scanner;

import game.objects.TileSprite;

public class TileClickHelper
{
	private TileSprite[][] map;
	private int currentSelectX;
	private int currentSelectY;

	public TileClickHelper(TileSprite[][] map)
	{
		this.map = map;
		currentSelectX = -1;
		currentSelectY = -1;
	}

	public void recieveMessage(String msg)
	{
		String purpose = msg.substring(0, msg.indexOf(" "));
		switch (purpose)
		{
		case "SELECT":
			Scanner s = new Scanner(msg);
			s.next();
			select(s.nextInt(), s.nextInt());
			s.close();
		}
	}

	private void select(int x, int y)
	{
		if (map[x][y].getUnit() == null)
		{
			map[x][y].selectNormal();
			if(currentSelectX != -1&& currentSelectY != -1)
			{
				if(map[x][y].isSelected())
				{
					map[x][y].unSelectNormal();
				}
				else if(!map[x][y].isSelected())
				{
					map[x][y].selectNormal();
				}
			}
		} else
		{

		}
	}

	private void findMovement()
	{

	}

	private void findAttack()
	{

	}
}
