// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
//
// Route.java
// Represents a collection of Waypoints

import java.util.ArrayList;
import java.util.Collections;

public class Route
{
	// The route is represented by an array of Waypoints	
	private ArrayList<Waypoint> route;

	// Generate a route consisting of n random Waypoints
	public Route(int n)
	{
		route = new ArrayList<Waypoint>(n);
		for (int i = 0; i < n; ++i)
		{
			route.add(Waypoint.randomWaypoint());
		}
	}

	public float getLength()
	{
		float length = 0.0f;
		for (int i = 0; i < route.size()-1; ++i)
		{
			Edge edge = new Edge(route.get(i), route.get(i+1));
			length += edge.getLength();
		}
		return length;
	}

	// Return an array of sorted edges 
	public static ArrayList<Edge> generateEdges(Route route, int startIdx)
	{
		ArrayList<Edge> edges = new ArrayList<Edge>(route.getWaypointCount()/2);

		for (int i = startIdx+1; i < route.getWaypointCount()-1; ++i)
		{
			Waypoint start = route.waypointAtIndex(i);
			Waypoint end = route.waypointAtIndex(i+1);
			Edge edge = new Edge(start, end);
			edges.add(edge);
		}
		
		Collections.sort(edges);
		return edges;
	}
	
	public void swapIndexes(int idxA, int idxB)
	{
		Collections.swap(route, idxA, idxB);
	}

	public Waypoint waypointAtIndex(int idx)
	{
		return (Waypoint)route.get(idx);
	}

	public int indexOfWaypoint(Waypoint waypoint)
	{
		return route.indexOf(waypoint);
	}

	public int getWaypointCount()
	{
		return route.size();
	}

	public void print()
	{
		for(int i = 0; i < route.size(); ++i)
		{
			route.get(i).print();
		}
	}	
}
