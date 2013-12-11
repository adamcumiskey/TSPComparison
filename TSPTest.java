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
		greedy2Opt.test(route);

		//System.out.println("New Route");
		//route.print();
	}
}
