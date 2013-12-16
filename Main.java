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
		Route routeCopy = new Route(0);
		routeCopy.setRoute(route.getRoute());
		
		float initialLength = routeCopy.getLength();

		// Time the execution of the algorithm
		long startTime = System.currentTimeMillis();
		
		routeCopy.presort(0);
		routeCopy = algorithm.optimize(routeCopy);
		if (useImprovement == true)
		{
			EdgeImprovement.improve(routeCopy);	
		}

		long endTime = System.currentTimeMillis();
		float runTime = (float)(endTime - startTime)/1000;
	
		// Calculate the final values
		float finalLength = routeCopy.getLength();
		float lengthImprovement = (1.0f - (finalLength / initialLength)) * 100.0f;

		printTrialResults(algorithm.name(), initialLength, finalLength, runTime);

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

	private static void printAverageResults(String name, float reduction, float time)
	{
		System.out.println();
		System.out.println("========================================");
		System.out.println("              " + name);
		System.out.println("========================================");
		System.out.println("Average Improvement: " + reduction + "%");
		System.out.println("Average Time: " + time + "s");
	}

	private static void printTrialResults(String name, float initialLength, float finalLength, float time)
	{
		System.out.println("\t" + name);
		System.out.println("\t Initial Length: " + initialLength);
		System.out.println("\t Final Length: " + finalLength);
		System.out.println("\t Time to run: " + time);
		System.out.println();
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
		float reduc2Opt = 0.0f;
		float time2Opt = 0.0f;

		Greedy3OptTSP greedy3Opt = new Greedy3OptTSP();
		float reduc3Opt = 0.0f;
		float time3Opt = 0.0f;
	
		for (int i = 0; i < m; ++i)
		{
			System.out.println("Trial " + (i+1));
			Route route = new Route(n);	

			Hashtable results2Opt = test(route, greedy2Opt, false);
			reduc2Opt += (float)results2Opt.get(LengthImprovementKey);
			time2Opt += (float)results2Opt.get(TimeToRunKey);

			Hashtable results3Opt = test(route, greedy3Opt, false);
			reduc3Opt += (float)results3Opt.get(LengthImprovementKey);
			time3Opt += (float)results3Opt.get(TimeToRunKey);
		}

		printAverageResults(greedy2Opt.name(), average(reduc2Opt, m), average(time2Opt, m));
		printAverageResults(greedy3Opt.name(), average(reduc3Opt, m), average(time3Opt, m));
	}
}
