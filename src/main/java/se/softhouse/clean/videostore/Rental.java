package se.softhouse.clean.videostore;


public class Rental
{
	private final Movie	_movie;
	private final int	_daysRented;

	public Rental(Movie movie, int daysRented)
	{
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented()
	{
		return _daysRented;
	}

	public Movie getMovie()
	{
		return _movie;
	}

	double cost()
	{
		return _movie.getRentalCost(_daysRented);
	}

	int frequentRenterPoints()
	{
		return _movie.getFrequentRenterPoints(_daysRented);
	}
}
