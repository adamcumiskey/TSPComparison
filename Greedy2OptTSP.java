// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
//
// Greedy2OptTSP.java
// Implimentation of the greedy 2-opt TSP solve

public class Greedy2OptTSP extends TSPSolve
{
	public String name()
	{
		return "Greedy 2-Opt";
	}

	public Route optimize(Route route)
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
