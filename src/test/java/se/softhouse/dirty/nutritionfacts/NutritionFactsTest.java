package se.softhouse.dirty.nutritionfacts;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class NutritionFactsTest {
	@Test
	public void testCreatingSomeNutritionFacts() {
		// TODO(lesson1): Telescoping constructor problem
		NutritionFactsBuilder nutritionFactsBuilder = new NutritionFactsBuilder();
		NutritionFacts nutritionFacts = nutritionFactsBuilder.servingSize(10)
				.servings(20).calories(50).fat(60).sodium(30).carbohydrate(40)
				.done();

		// new NutritionFacts(10, 20, 50, 60, 30, 40);
		assertThat(nutritionFacts.servingSize).isEqualTo(10);
		assertThat(nutritionFacts.servings).isEqualTo(20);
		assertThat(nutritionFacts.calories).isEqualTo(50);
		assertThat(nutritionFacts.fat).isEqualTo(60);
		assertThat(nutritionFacts.sodium).isEqualTo(30);
		assertThat(nutritionFacts.carbohydrate).isEqualTo(40);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreatingSomeNutritionFactsWithoutServings() {
		// TODO(lesson1): Telescoping constructor problem
		NutritionFactsBuilder nutritionFactsBuilder = new NutritionFactsBuilder();
		NutritionFacts nutritionFacts = nutritionFactsBuilder.servingSize(10)
				.done();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCreatingSomeNutritionFactsWithoutServingSize() {
		// TODO(lesson1): Telescoping constructor problem
		NutritionFactsBuilder nutritionFactsBuilder = new NutritionFactsBuilder();
		NutritionFacts nutritionFacts = nutritionFactsBuilder.servings(20)
				.done();
	}
}
