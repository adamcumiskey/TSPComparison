// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
//
// Main.java
// Main program for testing the TSP solves and outputting the stats

import java.util.Scanner;
import java.util.Hashtable;

public class Main 
{
	// Keys for the return dictionary
	public static final String LengthImprovementKey = "LengthImprovementKey";
	public static final String TimeToRunKey = "TimeToRunKey";
	
	private static Hashtable test(Route route, TSPSolve algorithm, boolean useImprovement)
	{
		float initialLength = route.getLength();

		// Time the execution of the algorithm
		long startTime = System.currentTimeMillis();
		
		route.presort(0);
		route = algorithm.optimize(route);
		if (useImprovement == true)
		{
			EdgeImprovement.improve(route);	
		}

		long endTime = System.currentTimeMillis();
		float runTime = (float)(endTime - startTime)/1000;
	
		// Calculate the final values
		float finalLength = route.getLength();
		float lengthImprovement = (1.0f - (finalLength / initialLength)) * 100.0f;

		// Store results in a dictionary and return the values
		Hashtable results = new Hashtable();
		results.put(LengthImprovementKey, lengthImprovement);
		results.put(TimeToRunKey, runTime);
		return results;
	}

	private static float average(float total, int iter)
	{
		return (float)(total/(float)iter);
	}

	private static void printResults(String name, float improvement, float time)
	{
		System.out.println();
		System.out.println("========================================");
		System.out.println("              " + name);
		System.out.println("========================================");
		System.out.println("Average Improvement: " + improvement + "%");
		System.out.println("Average Time: " + time + "s");
	}
	
	public static void main(String[] args) throws CloneNotSupportedException
	{
		// Get the number of waypoints from the user
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter in the number of waypoints: ");
		int n = scanner.nextInt();
		
		System.out.print("Enter the number of iterations: ");
		int m = scanner.nextInt();

		// Generate the test objects
		Greedy2OptTSP greedy2Opt = new Greedy2OptTSP();
		Greedy3OptTSP greedy3Opt = new Greedy3OptTSP();
		
		float improv2Opt = 0.0f;
		float time2Opt = 0.0f;
		float improv3Opt = 0.0f;
		float time3Opt = 0.0f;
		for (int i = 0; i < m; ++i)
		{
			// Create the route
			Route route = new Route(n);
			Route copy1 = new Route(0);
			Route copy2 = new Route(0);
			copy1.setRoute(route.getRoute());
			copy2.setRoute(route.getRoute());

			System.out.println("Starting iteration " + (i+1) + "... ");
			Hashtable greedy2OptResults = test(copy1, greedy2Opt, true);
			System.out.println("\t" + greedy2Opt.name() + " finished");
			Hashtable greedy3OptResults = test(copy2, greedy3Opt, true);
			System.out.println("\t" + greedy3Opt.name() + " finished");

			improv2Opt += (float)greedy2OptResults.get(LengthImprovementKey);
			time2Opt += (float)greedy2OptResults.get(TimeToRunKey);

			improv3Opt += (float)greedy3OptResults.get(LengthImprovementKey);
			time3Opt += (float)greedy3OptResults.get(TimeToRunKey);

			System.out.println("Done.");
			System.out.println();
		}

		printResults(greedy2Opt.name(), average(improv2Opt, m), average(time2Opt, m));
		printResults(greedy3Opt.name(), average(improv3Opt, m), average(time3Opt, m));
	}
}
