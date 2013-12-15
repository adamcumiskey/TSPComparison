// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
//
// EdgeImprovement.java
// Implementation of the improvement which finds and fixes
// overlapping edges

import java.util.ArrayList;

public class EdgeImprovement
{
	public static void improve(Route route)
	{
		ArrayList<Edge> edges = route.generateEdges(0);

		for (int i = 0; i < edges.size(); ++i)
		{
			Edge edge = edges.get(i);
			for (int j = 0; j < edges.size(); ++j)
			{
				Edge testEdge = edges.get(j);

				if (edge != testEdge)
				{
					if (edge.isOverlapping(testEdge))
					{
						swapVertexes(edge, testEdge, route);
					}
				}
			}
		}
	}

	// Swaps the end index of the first edge with the start index
	// of the second edge
	private static void swapVertexes(Edge edge1, Edge edge2, Route route)
	{
		int startIdx = route.indexOfWaypoint((Waypoint)edge1.end());
		int endIdx = route.indexOfWaypoint((Waypoint)edge2.start());

		route.swapIndexes(startIdx, endIdx);
	}
}
