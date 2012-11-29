package se.softhouse.clean.videostore;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class Customer
{
	private final String		_name;
	private final List<Rental>	_rentals	= Lists.newArrayList();

	public Customer(String name)
	{
		_name = name;
	};

	public void addRental(Rental arg)
	{
		_rentals.add(arg);
	}

	public String getName()
	{
		return _name;
	};

	public ImmutableList<Rental> getRentals()
	{
		return ImmutableList.copyOf(_rentals);
	}

	public String statement()
	{
		return new Statement(this).toString();
	}

	public int frequentRenterPoints()
	{
		int frequentRenterPoints = 0;
		for (Rental rental : _rentals)
		{
			frequentRenterPoints += rental.frequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	public double amountToPay()
	{
		double totalAmount = 0.0;
		for (Rental rental : _rentals)
		{
			totalAmount += rental.cost();
		}
		return totalAmount;
	}
}
