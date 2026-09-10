package ie.gmit.adventure;

public class Discriptions
{
	public static void help()
	{
		System.out.print("=========================================\n");
		System.out.print("To Navigate the room type the following \n\n");
		System.out.print("          List of All Keywords            \n");
		System.out.print("    LEFT,RIGHT,BACK,FRONT,FLOOR,CEILING   \n");
		System.out.print(" Typing any of the above will change view.\n");
		System.out.print("\n     INVENTORY will show inventory.     \n");
		System.out.print("\n       To try the door type LOCK 		\n");
		System.out.print("\n   Type ACTION and you will be prompted \n");
		System.out.print("\n       for an item name e.g SOAP        \n");
		System.out.print("\n    WHERE reminds you where you are     \n");
		System.out.print("\n  To see these instructions type HELP   \n");
		System.out.print("=========================================\n");
	}

	public static void welcomeMessage()
	{
		System.out.print("==================================\n");
		System.out.print("Welcome to a very basic text game \n");
		System.out.print("              by Andy             \n");
		System.out.print("Created on the 4th of March 2012 \n");
		System.out.print("    Type HELP for Instructions   \n");
		System.out.print("==================================\n");
	}

	public static void inventory(boolean item[])
	{
		final int MAX = 3;
		int i = -1;
		int check = 0;

		System.out.print("\nInventory:");
		System.out.print("\n============");

		while(i < MAX)
		{
			++i;

			if(item[i])
			{
				System.out.print("\nCode" + (i+1));
				++check;
			}
			else
			{
				System.out.print("\nEmpty Slot " + (i+1));
			}

			System.out.print("\n");
		}

	 	if(item[0] == true && item[1] == true && item[2] == true && item[3] == true)
	 	{
			System.out.print("\nYou have all the codes to leave.\n");
		}

		System.out.print("============\n");
	}

	public static void intro()
	{
		System.out.print("\nAs you venture into Andy's room some how the lock\n");
		System.out.print("slides down. It's a combination lock. 4 digits. You have \n");
		System.out.print("no idea what they are and must escape before he finds\n");
		System.out.print("out that you have been here sneaking around.\n");
		System.out.print("========================================================\n");
	}

	public static void roomLeft()
	{
		System.out.print("\n(LEFT)\n");
		System.out.print("\nThis is the lost corner of the bedroom.\n");
		System.out.print("My CLOSET is to the left. To the right is the sink area.\n");
		System.out.print("The SINK is nice and clean. A clear MIRROR stares back \n");
		System.out.print("at you but all the silly faces in the world won't help \n");
		System.out.print("you figure out  the combination. There is a lot of\n");
		System.out.print(" deoderant CANS, full and empty. A SOAP sits there.\n");
		System.out.print("========================================================\n");
	}

	public static void roomRight()
	{
		System.out.print("\n(RIGHT)\n");
		System.out.print("\nThis is HQ there is a computer desk with all sorts of\n");
		System.out.print("of NOTES everywhere. There is a MONITOR facing \n");
		System.out.print("you and a PENCILCASE is laying nearby. The pc is on \n");
		System.out.print("but there is no INTERNET connection. The desktop is on \n");
		System.out.print("the screen. Maybe I should look closer at the MONITOR.\n");
		System.out.print("========================================================\n");
	}

	public static void roomBack()
	{
		System.out.print("\n(BACK)\n");
		System.out.print("\nThe back of the room contains a bolted WINDOW.\n");
		System.out.print("These is no escaping this way and the window SILL\n");
		System.out.print("seem to be clear of anything useful to escape.\n");
		System.out.print("Maybe another part of the room holds something more\n");
		System.out.print("useful to escaping.\n");
		System.out.print("========================================================\n");
	}

	public static void roomFront()
	{
		System.out.print("\n(FRONT)\n");
		System.out.print("\nThis is the front of the room. Only the DOOR\n");
		System.out.print("stands between you and freedom. Only by knowing\n");
		System.out.print("all four digits can you unlock it.\n");
		System.out.print("========================================================\n");
	}

	public static void roomFloor()
	{
		System.out.print("\n(FLOOR)\n");
		System.out.print("\nThe floor is wooden and has been hoovered CLEAN.\n");
		System.out.print("There is very little on his floor.\n");
		System.out.print("A pair of Andy's old SHOES lay near the bed.\n");
		System.out.print("There is a BIN aswell nearby.\n");
		System.out.print("========================================================\n");
	}

	public static void roomCeiling()
	{
		System.out.print("\n(CEILING)\n");
		System.out.print("\nA unlit LIGHTBULB hangs down taunting you.\n");
		System.out.print("Everything on the ceiling is out of reach to you.\n");
		System.out.print("The ceiling is PAINTED white and looking up towards\n");
		System.out.print("the heavens isn't the best way to seek ANSWERS in\n");
		System.out.print("Andy's crypt of a room.\n");
		System.out.print("========================================================\n");
	}

	public static void exitGame()
	{
		System.out.print("\nI guess you lose the game then... Goodbye....\n");
		System.out.print("========================================================\n");
	}

	public static void victoryCondition( )
	{
		System.out.print("========================================================\n");
		System.out.print("\nYou've won! You've got all 4 parts of the combination\n");
		System.out.print("\nThank you for playing the game.\n");
		System.out.print("========================================================\n");
	}
}
