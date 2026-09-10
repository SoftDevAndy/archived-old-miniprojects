package ie.gmit.adventure;

import java.util.*;

public class TextBasedAdventureGame extends Rooms
{
	public static void main(String[] args )
	{
		Scanner console = new Scanner(System.in);
		Discriptions yarn = new Discriptions();
		Rooms g = new Rooms();

		String userInput = "";

		final String LOCK = "lock";
		final String QUIT = "quit";
		final int MAX = 3;

		boolean []item = new boolean [] {false,false,false,false}; // inventory array

		yarn.welcomeMessage();
		yarn.intro();

		System.out.print("Type a choice (type help for more options): ");
		userInput = console.nextLine();

		while(userInput.equalsIgnoreCase(QUIT) == false)
		{
			decider(userInput,item,g.inLeft,g.inRight,g.inBack,g.inFront,g.inFloor,g.inCeiling);

			if(item[0] == true && item[1] == true && item[2] == true && item[3])
			{
				System.out.print("\nYou have all the codes, type LOCK to end.\n");
			}

			System.out.print("\nType a choice (type help for more options): ");
			userInput = console.nextLine();

			if(userInput.equalsIgnoreCase(LOCK))
			{
				if(item[0] == true && item[1] == true && item[2] == true && item[3])
				{
					yarn.victoryCondition();
					System.exit(0);
				}
				else
				{
					System.out.print("\nYou are still missing some codes.\n");
				}
			}
		}

		System.out.print("\nYou chose to leave the game and therefore you lose.");
	}

	public static void decider(String deciderBack,boolean item[],boolean inLeft,boolean inRight,boolean inBack,boolean inFront,boolean inFloor,boolean inCeiling)
	{
		Discriptions read = new Discriptions();
		RoomControl roomCheck = new RoomControl();
		Action interact = new Action();

		final String HELP = "help";
		final String INVENTORY = "inventory";

		final String LEFT = "left";
		final String RIGHT = "right";
		final String BACK = "back";
		final String FRONT = "front";
		final String FLOOR = "floor";
		final String CEILING = "ceiling";
		final String ACTION = "action";
		final String WHERE = "where";

		inLeft = getInLeft();
		inRight = getInRight();
		inBack = getInBack();
		inFront = getInFront();
		inFloor = getInFloor();
		inCeiling = getInCeiling();


		if(deciderBack.equalsIgnoreCase(HELP))
		{
			read.help();
		}

		else if(deciderBack.equalsIgnoreCase(INVENTORY))
		{
			read.inventory(item);
		}

		else if(deciderBack.equalsIgnoreCase(LEFT))
		{
			read.roomLeft();
			setInLeft();
		}

		else if(deciderBack.equalsIgnoreCase(RIGHT))
		{
			read.roomRight();
			setInRight();
		}

		else if(deciderBack.equalsIgnoreCase(BACK))
		{
			read.roomBack();
			setInBack();
		}
		else if(deciderBack.equalsIgnoreCase(FRONT))
		{
			read.roomFront();
			setInFront();
		}
		else if(deciderBack.equalsIgnoreCase(FLOOR))
		{
			read.roomFloor();
			setInFloor();

		}
		else if(deciderBack.equalsIgnoreCase(CEILING))
		{
			read.roomCeiling();
			setInCeiling();
		}
		else if(deciderBack.equalsIgnoreCase(ACTION))
		{
			interact.looking(item);
		}
		else if(deciderBack.equalsIgnoreCase(WHERE))
		{
			roomCheck.whereAmI();
		}

		else
		{
			System.out.print("Invalid Input - Sorry.\n");
		}
	}

} // End