package se.softhouse.clean.videostore;

public class Movie
{
	private final String	_title;
	private final Price		_price;

	public Movie(String title, Price price)
	{
		_title = title;
		_price = price;
	}

	public String getTitle()
	{
		return _title;
	}

	public double getRentalCost(int daysRented)
	{
		return _price.getRentalCost(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented)
	{
		return _price.getFrequentRenterPoints(daysRented);
	}
}
