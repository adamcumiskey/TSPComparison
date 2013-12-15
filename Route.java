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

	public void setRoute(ArrayList<Waypoint> newRoute)
	{
		route = newRoute;
	}

	public ArrayList<Waypoint> getRoute()
	{
		return (ArrayList<Waypoint>)route.clone();
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

	// Recursively presort the route in acending order based on edge length
	public void presort(int startIdx)
	{
		// End condition is when we reach the second to last waypoint.
		// We don't want to optimize the last edge because the final stop
		// needs to remain consistent.
		if (startIdx == route.size()-2)
			return;
		else 
		{
			// Sort the edges and grab the shortest one
			ArrayList<Edge> edges = generateEdges(startIdx); 
			Edge shortestEdge = edges.get(0);

			// Get the endex of the end of the waypoint and swap the edges
			int index = route.indexOf(shortestEdge.end());
			swapIndexes(startIdx+1, index);
			
			// Recurse
			presort(startIdx+1);
		}
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

	// Return an array of sorted edges 
	private ArrayList<Edge> generateEdges(int startIdx)
	{
		ArrayList<Edge> edges = new ArrayList<Edge>(route.size()/2);

		for (int i = startIdx+1; i < route.size()-1; ++i)
		{
			Waypoint start = route.get(i);
			Waypoint end = route.get(i+1);
			Edge edge = new Edge(start, end);
			edges.add(edge);
		}
		
		Collections.sort(edges);
		return edges;
	}
}
