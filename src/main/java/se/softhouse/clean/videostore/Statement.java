package se.softhouse.clean.videostore;

public class Statement
{
	final Customer	_customer;
	final double	_totalAmount;
	final int		_frequentRenterPoints;

	public Statement(Customer customer)
	{
		_customer = customer;
		_totalAmount = customer.amountToPay();
		_frequentRenterPoints = customer.frequentRenterPoints();
	}

	@Override
	public String toString()
	{
		String result = header();
		for (Rental rental : _customer.getRentals())
		{
			result += figuresForOneRental(rental);
		}
		result += footer();
		return result;
	}

	private String header()
	{
		return "Rental Record for " + _customer.getName() + "\n";
	}

	private String figuresForOneRental(Rental rental)
	{
		return "\t" + rental.getMovie().getTitle() + "\t" + rental.cost()
				+ "\n";
	}

	private String footer()
	{
		return "Amount owed is " + _totalAmount + "\n" + "You earned "
				+ _frequentRenterPoints + " frequent renter points";
	}
}
