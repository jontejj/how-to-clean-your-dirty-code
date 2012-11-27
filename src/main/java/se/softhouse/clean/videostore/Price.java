package se.softhouse.clean.videostore;

public enum Price
{
	REGULAR {
		@Override
		public double getRentalCost(int daysRented)
		{
			double cost = 2;
			if (daysRented > 2)
			{
				cost += (daysRented - 2) * 1.5;
			}
			return cost;
		}
	},
	NEW_RELEASE {

		@Override
		public double getRentalCost(int daysRented)
		{
			return daysRented * 3;
		}

		@Override
		public int getFrequentRenterPoints(int daysRented)
		{
			int points = super.getFrequentRenterPoints(daysRented);
			if (daysRented >= 2)
			{
				points++;
			}
			return points;
		}
	},
	CHILDRENS {

		@Override
		public double getRentalCost(int daysRented)
		{
			double cost = 1.5;
			if (daysRented > 3)
			{
				cost += (daysRented - 3) * 1.5;
			}
			return cost;
		}
	};

	public abstract double getRentalCost(int daysRented);

	/**
	 * @param daysRented
	 *            the number of days the movie has been rented
	 */
	public int getFrequentRenterPoints(int daysRented)
	{
		return 1;
	}
}
