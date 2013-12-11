// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
//
// Greedy2OptTSP.java
// Implimentation of the greedy 2-opt TSP solve

public class Greedy2OptTSP
{
	public void test(Route route)
	{
		System.out.println();
		System.out.println("======================================");
		System.out.println("        Greedy 2-opt test");
		System.out.println("======================================");

		float initialLength = route.getLength();

		// Time the execution of the algorithm
		long startTime = System.currentTimeMillis();
		route.presort(0);
		route = optimize(route);
		long endTime = System.currentTimeMillis();
		float runTime = (float)(endTime - startTime)/1000;
		
		float finalLength = route.getLength();

		System.out.println("Initial Length: " + initialLength);
		System.out.println("Final Length: " + finalLength);
		System.out.println("Time to optimize: " + runTime + "s");
		System.out.println();
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
