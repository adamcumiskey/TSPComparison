// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
//
// Route.java
// Represents a collection of Waypoints

import java.util.Random;

public class Route
{
	// The route is represented by an array of Waypoints	
	private Waypoint[] route;

	// Generate a route consisting of n random Waypoints
	public Route(int n)
	{
		route = new Waypoint[n];
		for (int i = 0; i < n; ++i)
		{
			route[i] = randomWaypoint();
		}
	}

	public float getLength()
	{
		float length = 0.0f;
		for (int i = 0; i < route.length-1; ++i)
		{
			Edge edge = new Edge(route[i], route[i+1]);
			length += edge.getLength();
		}
		return length;
	}

	public void print()
	{
		for(int i = 0; i < route.length; ++i)
		{
			route[i].print();
		}
	}

	private Waypoint randomWaypoint()
	{
		Random generator = new Random();
		int randX = generator.nextInt() % 100;
		int randY = generator.nextInt() % 100;

		return new Waypoint(randX, randY);
	}
}
