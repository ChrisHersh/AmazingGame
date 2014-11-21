package game.world;

import java.util.Vector;

import game.objects.Unit;


public class PlayerManager
{
	public static int currentPlayerCap = 0;
	private static int currentPlayer = 0;
	
	public static void addNewPlayer()
	{
		currentPlayerCap++;
	}
	
	public static void endTurn()
	{
		if(currentPlayer == currentPlayerCap-1)
		{
			currentPlayer = 0;
		}
		else
		{
			currentPlayer++;
		}
		System.out.println(currentPlayer);
	}
	
	public static int getCurrPlayerTurn()
	{
		return currentPlayer;
	}
}
