// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
//
// TSPTest.java
// Main program for testing the TSP solves and outputting the stats

public class TSPTest
{
	public static void main(String[] args)
	{
		Route route = new Route(10);
	
		Greedy2OptTSP greedy2Opt = new Greedy2OptTSP();
		greedy2Opt.test(route);
	}
}
