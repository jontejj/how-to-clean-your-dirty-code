package se.softhouse.clean.nutritionfacts;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class NutritionFactsTest
{
	@Test
	public void testThatServingAndServingSizeIsRequired()
	{
		NutritionFacts nutritionFacts = NutritionFacts.servingSize(10)
				.servings(20).build();
		assertThat(nutritionFacts.servingSize).isEqualTo(10);
		assertThat(nutritionFacts.servings).isEqualTo(20);
	}
}
