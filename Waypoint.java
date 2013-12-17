// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
// 
// Waypoint.java
// Object representing a point in cartesian space

import java.util.Random;

public class Waypoint
{
	private int x, y;

	public Waypoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;	
	}
	
	public static Waypoint randomWaypoint()
	{
		Random generator = new Random();
		int randX = generator.nextInt() % 100;
		int randY = generator.nextInt() % 100;

		return new Waypoint(randX, randY);
	}
}
