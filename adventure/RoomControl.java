package ie.gmit.adventure;

public class RoomControl extends Rooms
{
	Discriptions iamhere = new Discriptions();

	public void whereAmI()
	{
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
			iamhere.roomLeft();
		}

		else if(b)
		{
			iamhere.roomRight();
		}

		else if(c)
		{
			iamhere.roomBack();
		}

		else if(d)
		{
			iamhere.roomFront();
		}

		else if(e)
		{
			iamhere.roomFloor();
		}

		else if(f)
		{
			iamhere.roomCeiling();
		}
		else
		{
			System.out.print("\nPlease move around the room\n");
		}

	}
}