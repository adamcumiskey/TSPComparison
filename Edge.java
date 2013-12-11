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
	
	public float getLength()
	{
		return length;
	}

	private void setLength()
	{
		float delX = end.getX()-start.getX();
		float delY = end.getY()-start.getY();

		length = (float)Math.sqrt((float)Math.pow(delX, 2) + (float)Math.pow(delY, 2));
	}
}
