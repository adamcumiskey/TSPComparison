// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
// 
// Waypoint.java
// Object representing a point in cartesian space

public class Waypoint
{
	private int x, y;

	public Waypoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void print()
	{
		System.out.println("(" + x + ", " + y + ")");
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;	
	}
}
