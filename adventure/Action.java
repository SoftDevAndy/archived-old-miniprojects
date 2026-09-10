package ie.gmit.adventure;

import java.util.*;

public class Action extends Rooms
{
	public static void looking(boolean item[])
	{
		Scanner console = new Scanner(System.in);
		Items discribe = new Items();

		String itemCheck;

		final String CLOSET = "closet";
		final String SINK = "sink";
		final String MIRROR = "mirror";
		final String SOAP = "soap";

		final String NOTES = "notes";
		final String MONITOR = "monitor";
		final String FILES = "files";
		final String PENCILCASE = "pencilcase";

		final String WINDOW = "window";
		final String SHOES = "shoes";
		final String BIN = "bin";

		final String LIGHTBULB = "lightbulb";

		final String CANS = "cans";
		final String INTERNET = "internet";
		final String SILL = "sill";
		final String DOOR = "door";
		final String CLEAN = "clean";
		final String PAINTED = "painted";
		final String ANSWERS = "answers";

		System.out.print("\nPlease enter an OBJECT NAME e.g Soap: ");
		itemCheck = console.next();

		boolean a = false;
		boolean b = false;
		boolean c = false;
		boolean d = false;
		boolean e = false;
		boolean f = false;

		a = getInLeft();
		b = getInRight();
		c = getInBack();
		d = getInFront();
		e = getInFloor();
		f = getInCeiling();

		if(a)
		{
			if(itemCheck.equalsIgnoreCase(CLOSET))
			{
				discribe.leftItemCloset();
			}
			else if(itemCheck.equalsIgnoreCase(SINK))
			{
				discribe.leftItemSink();
			}
			else if(itemCheck.equalsIgnoreCase(MIRROR))
			{
				discribe.leftItemMirror();
			}
			else if(itemCheck.equalsIgnoreCase(CANS))
			{
				discribe.leftItemCans();
			}
			else if(itemCheck.equalsIgnoreCase(SOAP))
			{
				if(item[0])
				{
					System.out.print("\nYou've already looked at the soap\n");
				}
				else
				{
					item[0] = true;
					discribe.leftItemSoap();
				}
			}
			else
			{
				WrongItem();
			}
		} // Left

		else if(b)
		{
			if(itemCheck.equalsIgnoreCase(NOTES))
			{
				discribe.rightItemNotes();
			}
			else if(itemCheck.equalsIgnoreCase(INTERNET))
			{
				discribe.rightItemInternet();
			}
			else if(itemCheck.equalsIgnoreCase(MONITOR))
			{
				discribe.rightItemMonitor();
			}
			else if(itemCheck.equalsIgnoreCase(PENCILCASE))
			{
				discribe.rightItemPencilCase();
			}
			else if(itemCheck.equalsIgnoreCase(FILES))
			{
				if(item[1])
				{
					System.out.print("\nYou've already looked at the files\n");
				}
				else
				{
					item[1] = true;
					discribe.rightItemFiles();
				}
			}
			else
			{
				WrongItem();
			}
		} // Right

		else if(c)
		{
			if(itemCheck.equalsIgnoreCase(WINDOW))
			{
				discribe.backItemsWindow();
			}
			else if(itemCheck.equalsIgnoreCase(SILL))
			{
				discribe.floorItemsSill();
			}
			else
			{
				WrongItem();
			}
		} // Back

		else if(d)
		{
			if(itemCheck.equalsIgnoreCase(DOOR))
			{
				discribe.frontItemsDoor();
			}
			else
			{
				Nothing();
			}
		} // Front

		else if(e)
		{
			if(itemCheck.equalsIgnoreCase(SHOES))
			{
				if(item[2])
				{
					System.out.print("\nYou've already looked at the shoe.\n");
				}
				else
				{
					item[2] = true;
					discribe.floorItemsShoe();
				}

			}
			else if(itemCheck.equalsIgnoreCase(BIN))
			{
				discribe.floorItemsBin();
			}

			else if(itemCheck.equalsIgnoreCase(CLEAN))
			{
				discribe.floorItemsClean();
			}

			else
			{
				WrongItem();
			}
		} //Floor

		else if(f)
		{
			if(itemCheck.equalsIgnoreCase(LIGHTBULB))
			{
				if(item[3])
				{
					System.out.print("\nYou've already looked at the lightbulb.\n");
				}
				else
				{
					item[3] = true;
					discribe.ceilingItemLightbulb();
				}
			}

			else if(itemCheck.equalsIgnoreCase(PAINTED))
			{
				discribe.floorItemsPainted();
			}

			else if(itemCheck.equalsIgnoreCase(ANSWERS))
			{
				discribe.floorItemsAnswers();
			}
			else
			{
				WrongItem();
			}


		} // Ceiling

		else
		{
			System.out.print("\nPlease move around the room\n");
		}
	}

	public static void WrongItem()
	{
		System.out.print("\nWrong item/name chosen or Object is out of reach.\n");
	}
	public static void Nothing()
	{
		System.out.print("\nNothing here to interact with.\n");
	}

}