// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
//
// Greedy3OptTSP.java
// Implementation of the greedy 3-opt TSP solve

public class Greedy3OptTSP extends TSPSolve
{
	public String name()
	{
		return "Greedy 3-Opt";
	}

	public Route optimize(Route route)
	{
		float distance = route.getLength();

		for (int i = 1; i < route.getWaypointCount()-3; ++i)
		{
			for (int j = i+1; j < route.getWaypointCount()-2; ++j)
			{
				for (int k = j+1; k < route.getWaypointCount()-1; ++k)
				{
					// Perform the 3 way swap and test the length
					route.swapIndexes(i, k);
					route.swapIndexes(j, k);
					float newDistance = route.getLength();
					
					if (newDistance < distance)
						return optimize(route);
					else
					{
						route.swapIndexes(j, k);
						route.swapIndexes(i, k);
					}
				}
			}
		}
		
		return route;
	}
}
