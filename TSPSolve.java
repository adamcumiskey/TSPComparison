// Adam Cumiskey
// Algorithms
// Fall '13
// Final Project
//
// TSPSolve.java
// Abstract class representing one of the TSP Algorithms

public abstract class TSPSolve
{
	// Returns the name of the Algorithm for the output
	abstract String name();

	// Runs the TSP algorithm and returns the optimized Route
	abstract Route optimize(Route route);
}
