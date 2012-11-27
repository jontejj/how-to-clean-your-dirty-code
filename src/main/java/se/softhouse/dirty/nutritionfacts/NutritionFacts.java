package se.softhouse.dirty.nutritionfacts;

// Telescoping constructor pattern
public class NutritionFacts
{
	final int	servingSize;	// (mL) required
	final int	servings;		// (per container) required
	final int	calories;		// optional
	final int	fat;			// (g) optional
	final int	sodium;		// (mg) optional
	final int	carbohydrate;	// (g) optional

	public NutritionFacts(int servingSize, int servings)
	{
		this(servingSize, servings, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories)
	{
		this(servingSize, servings, calories, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat)
	{
		this(servingSize, servings, calories, fat, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat,
			int sodium)
	{
		this(servingSize, servings, calories, fat, sodium, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat,
			int sodium, int carbohydrate)
	{
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}
}
