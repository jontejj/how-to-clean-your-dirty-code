package se.softhouse.dirty.nutritionfacts;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class NutritionFactsTest
{
	@Test
	public void testCreatingSomeNutritionFacts()
	{
		// TODO(lesson1): Telescoping constructor problem
		NutritionFacts nutritionFacts = new NutritionFacts(10, 20, 50, 60, 30,
				40);
		assertThat(nutritionFacts.servingSize).isEqualTo(10);
		assertThat(nutritionFacts.servings).isEqualTo(20);
	}
}
