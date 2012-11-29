package se.softhouse.benchmarks;

import se.softhouse.clean.figures.Figure;
import se.softhouse.clean.figures.FigureTest;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/**
 * Times {@link se.softhouse.dirty.figures.Figure} vs {@link Figure}. That
 * is,tagged fields vs class hierarchy
 */
public class FigureBenchmark extends SimpleBenchmark
{
	public void timeTaggedFields(int reps)
	{
		for (int i = 0; i < reps; i++)
		{
			new se.softhouse.dirty.figures.FigureTest()
					.testWorkingWithSomeFigures();
		}
	}

	public void timeClassHierarchy(int reps)
	{
		for (int i = 0; i < reps; i++)
		{
			new FigureTest().testWorkingWithSomeFigures();
		}
	}

	public static void main(String[] args) throws Exception
	{
		Runner.main(FigureBenchmark.class, args);
	}
}
