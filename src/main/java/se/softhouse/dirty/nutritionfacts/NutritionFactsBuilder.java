package se.softhouse.dirty.nutritionfacts;

public class NutritionFactsBuilder {

	private int servingSize; // (mL) required
	private int servings; // (per container) required
	private int calories; // optional
	private int fat; // (g) optional
	private int sodium; // (mg) optional
	private int carbohydrate; // (g) optional

	public NutritionFactsBuilder servingSize(int servingSize) {
		this.servingSize = servingSize;
		return this;
	}

	public NutritionFactsBuilder servings(int value) {
		this.servings = value;
		return this;
	}

	public NutritionFactsBuilder calories(int value) {
		this.calories = value;
		return this;
	}

	public NutritionFactsBuilder fat(int value) {
		this.fat = value;
		return this;
	}

	public NutritionFactsBuilder sodium(int value) {
		this.sodium = value;
		return this;
	}

	public NutritionFactsBuilder carbohydrate(int value) {
		this.carbohydrate = value;
		return this;
	}

	public NutritionFacts done() {
		return new NutritionFacts(servingSize, servings, calories, fat,
				sodium, carbohydrate);
	}
}
