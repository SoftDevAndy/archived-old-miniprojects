package ie.gmit.adventure;

public class Rooms
{
	public static boolean inLeft = false;
	public static boolean inRight = false;
	public static boolean inBack = false;
	public static boolean inFront = false;
	public static boolean inFloor = false;
	public static boolean inCeiling = false;

	public static boolean getInLeft()
	{
		return inLeft;
	}

	public static boolean getInRight()
	{
		return inRight;
	}

	public static boolean getInBack()
	{
		return inBack;
	}

	public static boolean getInFront()
	{
		return inFront;
	}

	public static boolean getInFloor()
	{
		return inFloor;
	}

	public static boolean getInCeiling()
	{
		return inCeiling;
	}
	/// Get

	public static void setInLeft()
	{
		inLeft = true;

		inRight = false;
		inBack = false;
		inFront = false;
		inFloor = false;
		inCeiling = false;
	}

	public static void setInRight()
	{
		inRight = true;

		inLeft = false;
		inBack = false;
		inFront = false;
		inFloor = false;
		inCeiling = false;
	}

	public static void setInBack()
	{
		inBack = true;

		inLeft = false;
		inRight = false;
		inFront = false;
		inFloor = false;
		inCeiling = false;

	}

	public static void setInFront()
	{
		inFront = true;

		inLeft = false;
		inRight = false;
		inBack = false;
		inFloor = false;
		inCeiling = false;
	}

	public static void setInFloor()
	{
		inFloor = true;

		inLeft = false;
		inRight = false;
		inBack = false;
		inFront = false;
		inCeiling = false;
	}

	public static void setInCeiling()
	{
		inCeiling = true;

		inLeft = false;
		inRight = false;
		inBack = false;
		inFront = false;
		inFloor = false;
	}

	// Set
}
