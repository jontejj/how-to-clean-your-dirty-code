package se.softhouse.clean.nutritionfacts;

public class NutritionFacts
{
	final int	servingSize;	// (mL) required
	final int	servings;		// (per container) required
	final int	calories;		// optional
	final int	fat;			// (g) optional
	final int	sodium;		// (mg) optional
	final int	carbohydrate;	// (g) optional

	/**
	 * Starting point for constructing NutritionFacts instances, next method
	 * that must be called is {@link BuilderForServings#servings(int)}
	 */
	public static BuilderForServings servingSize(int servingSize)
	{
		// This enforces the order NutritionFacts.servingSize(10).servings(20)
		// which IMHO is more readable than new NutritionFacts(10, 20)
		return new BuilderForServings(servingSize);
	}

	public static final class BuilderForServings
	{
		private final int	servingSize;

		private BuilderForServings(int servingSize)
		{
			this.servingSize = servingSize;
		}

		/**
		 * @return a Builder that you can set optional properties on
		 */
		public Builder servings(int servings)
		{
			return new Builder(servingSize, servings);
		}
	}

	/**
	 * Builder for the optional properties in {@link NutritionFacts}
	 */
	public static final class Builder
	{
		// Required parameters
		private final int	servingSize;
		private final int	servings;

		// Optional parameters - initialized to default values
		private int			calories		= 0;
		private int			fat				= 0;
		private int			carbohydrate	= 0;
		private int			sodium			= 0;

		private Builder(int servingSize, int servings)
		{
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val)
		{
			calories = val;
			return this;
		}

		public Builder fat(int val)
		{
			fat = val;
			return this;
		}

		public Builder carbohydrate(int val)
		{
			carbohydrate = val;
			return this;
		}

		public Builder sodium(int val)
		{
			sodium = val;
			return this;
		}

		public NutritionFacts build()
		{
			return new NutritionFacts(this);
		}
	}

	private NutritionFacts(Builder builder)
	{
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
}
