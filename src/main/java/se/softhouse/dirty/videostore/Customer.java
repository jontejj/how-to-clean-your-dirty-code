package se.softhouse.dirty.videostore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private final String _name;
	private final Vector _rentals = new Vector();

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	};

	private static class FrequentRenterPoints {
		private int frequentRenterPoints;

		public void add(Rental rental) {
			this.frequentRenterPoints += calculateFrequentRenterPoints(rental);
		}

		public int get() {
			return frequentRenterPoints;
		}

		private int calculateFrequentRenterPoints(Rental each) {
			// add frequent renter points
			int frequentRenterPoints = 1;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1) {
				frequentRenterPoints++;
			}
			return frequentRenterPoints;
		}

	}

	public String statement() {
		// TODO(lesson0): Refactoring one step at a time

		FrequentRenterPoints frequentRenterPoints = new FrequentRenterPoints();
		Enumeration rentals = _rentals.elements();
		StringBuilder result = new StringBuilder("Rental Record for "
				+ getName() + "\n");
		double totalAmount = allRentals(frequentRenterPoints, rentals, result);
		getFooterLines(result, totalAmount, frequentRenterPoints.get());
		return result.toString();
	}

	private double allRentals(FrequentRenterPoints frequentRenterPoints,
			Enumeration rentals, StringBuilder result) {
		double totalAmount = 0;
		while (rentals.hasMoreElements()) {
			totalAmount += onRental(frequentRenterPoints, result,
					(Rental) rentals.nextElement());
		}
		return totalAmount;
	}

	private double onRental(FrequentRenterPoints frequentRenterPoints,
			StringBuilder result, Rental rental) {
		double thisAmount = determineAmountsForEachLine(rental);
		frequentRenterPoints.add(rental);
		showFiguresForThisRental(result, rental, thisAmount);
		return thisAmount;
	}

	private void getFooterLines(StringBuilder result, double totalAmount,
			int frequentRenterPoints) {
		// add footer lines
		result.append("Amount owed is " + String.valueOf(totalAmount) + "\n");
		result.append("You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points");

	}

	private void showFiguresForThisRental(StringBuilder result, Rental each,
			double thisAmount) {
		result.append("\t" + each.getMovie().getTitle() + "\t"
				+ String.valueOf(thisAmount) + "\n");
	}

	private double determineAmountsForEachLine(Rental each) {
		double thisAmount = 0;
		switch (each.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (each.getDaysRented() > 2) {
				thisAmount += (each.getDaysRented() - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			thisAmount += each.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (each.getDaysRented() > 3) {
				thisAmount += (each.getDaysRented() - 3) * 1.5;
			}
			break;
		}
		return thisAmount;
	}
}
