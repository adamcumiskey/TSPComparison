// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
//
// Greedy2OptTSP.java
// Implimentation of the greedy 2-opt TSP solve

import java.util.ArrayList;
import java.util.Collections;

public class Greedy2OptTSP
{
	public void test(Route route)
	{
		System.out.println("Initial Length: " + route.getLength());

		// Start the presorting at index 2
		route = presort(route, 2);
		route = optimize(route);

		System.out.println("Final Length: " + route.getLength());
	}
	
	// Recursively presort the route in acending order based on edge length
	private Route presort(Route route, int startIdx)
	{
		// End condition is when we reach the second to last waypoint.
		// We don't want to optimize the last edge because the final stop
		// needs to remain consistent.
		if (startIdx == route.getWaypointCount()-2)
			return route;
		else 
		{
			// Sort the edges and grab the shortest one
			ArrayList<Edge> edges = Route.generateEdges(route, startIdx); 
			Edge shortestEdge = edges.get(0);

			// Get the endex of the end of the waypoint and swap the edges
			int index = route.indexOfWaypoint(shortestEdge.end());
			route.swapIndexes(startIdx+1, index);
			
			// Recurse
			return presort(route, startIdx+1);
		}
	}

	private Route optimize(Route route)
	{
		float distance = route.getLength();

		for (int i = 1; i < route.getWaypointCount()-2; ++i)
		{
			for (int j = i+1; j < route.getWaypointCount()-1; ++j)
			{
				// Swap i and j and test the length
				route.swapIndexes(i, j);
				float newDistance = route.getLength();

				// If better, continue recursively
				// otherwise restore the indexes
				if (newDistance < distance)
					return optimize(route);
				else
					route.swapIndexes(i, j);
			}
		}

		return route;
	}
}

