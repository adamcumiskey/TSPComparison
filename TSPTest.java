// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
//
// TSPTest.java
// Main program for testing the TSP solves and outputting the stats

import java.util.Scanner;

public class TSPTest
{
	public static void main(String[] args)
	{
		// Get the number of waypoints from the user
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter in the number of waypoints: ");
		int n = scanner.nextInt();

		// Create the route
		Route route = new Route(n);
		//System.out.println("Initial Route");
		//route.print();


		// Test the greedy2Opt
		Greedy2OptTSP greedy2Opt = new Greedy2OptTSP();

		test(route, greedy2Opt);

		//System.out.println("New Route");
		//route.print();
	}

	private static void test(Route route, TSPSolve algorithm)
	{
		System.out.println();
		System.out.println("======================================");
		System.out.println("             " + algorithm.name());
		System.out.println("======================================");

		float initialLength = route.getLength();

		// Time the execution of the algorithm
		long startTime = System.currentTimeMillis();
		route.presort(0);
		route = algorithm.optimize(route);
		long endTime = System.currentTimeMillis();
		float runTime = (float)(endTime - startTime)/1000;
		
		float finalLength = route.getLength();

		System.out.println("Initial Length: " + initialLength);
		System.out.println("Final Length: " + finalLength);
		System.out.println("Time to optimize: " + runTime + "s");
		System.out.println();

	}
}
