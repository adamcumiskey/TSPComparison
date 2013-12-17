// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
//
// Edge.java
// Represents an edge made up of two waypoints

public class Edge implements Comparable<Edge>
{
	private Waypoint start, end;
	private float length;

	public Edge(Waypoint start, Waypoint end)
	{
		this.start = start;
		this.end = end;
		setLength();
	}

	public Waypoint start()
	{
		return start;
	}

	public Waypoint end()
	{
		return end;
	}
	
	public int compareTo(Edge otherEdge)
	{
		float otherLength = otherEdge.getLength();

		if (otherLength > length) {
			return -1;
		} else if (otherLength < length) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public boolean sharesVertex(Edge otherEdge)
	{
		if (start == otherEdge.start() ||
				start == otherEdge.end()   ||
				end   == otherEdge.start() ||
				end   == otherEdge.end())
		{
			return true;
		}

		return false;
	}
	
	public float getLength()
	{
		return length;
	}

	private void setLength()
	{
		float delX = end.getX()-start.getX();
		float delY = end.getY()-start.getY();

		length = (float)Math.sqrt((float)Math.pow(delX, 2) +
						 (float)Math.pow(delY, 2));
	}

	public String toString()
	{
		return "(" + start.toString() + ", " + end.toString() + ")";
	}

	// Quick way to determine whether two edges intersect
	// http://stackoverflow.com/questions/9043805/test-if-two-lines-intersect-javascript-function
	public boolean isOverlapping(Edge edge)
	{
		Waypoint w1 = start; Waypoint w2 = end;
		Waypoint w3 = edge.start(); Waypoint w4 = edge.end();

		return ((CCW(w1, w3, w4) != CCW(w2, w3, w4)) &&
					  (CCW(w1, w2, w3) != CCW(w1, w2, w4)));
	}

	// Determine whether the 3 points are counter clockwise
	private boolean CCW(Waypoint w1, Waypoint w2, Waypoint w3)
	{
		int a = w1.getX(); int b = w1.getY();
		int c = w2.getX(); int d = w2.getY();
		int e = w3.getX(); int f = w3.getY();

		return ((f-b)*(c-a)>(d-b)*(e-a));
	}
}
