package se.softhouse.benchmarks;

import se.softhouse.clean.nutritionfacts.NutritionFacts;
import se.softhouse.clean.nutritionfacts.NutritionFactsTest;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/**
 * Times {@link se.softhouse.dirty.nutritionfacts.NutritionFacts} vs clean
 * {@link NutritionFacts}, i.e telescopic constructor vs. builder
 */
public class NutritionFactsBenchmark extends SimpleBenchmark
{
	public void timeBuilderPattern(int reps)
	{
		for (int i = 0; i < reps; i++)
		{
			new NutritionFactsTest().testThatServingAndServingSizeIsRequired();
		}
	}

	public void timeTelescopicConstructor(int reps)
	{
		for (int i = 0; i < reps; i++)
		{
			new se.softhouse.dirty.nutritionfacts.NutritionFactsTest()
					.testCreatingSomeNutritionFacts();
		}
	}

	public static void main(String[] args) throws Exception
	{
		Runner.main(NutritionFactsBenchmark.class, args);
	}
}
