package se.softhouse.dirty.videostore;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testCustomerStatement()
	{
		String name = "Bob";
		Customer customer = new Customer(name);
		
		String statement = customer.statement();
		assertEquals("Rental Record for Bob\nAmount owed is 0.0\nYou earned 0 frequent renter points", statement);
		
		
		Movie movie = new Movie("Australia Trip", Movie.NEW_RELEASE);
		int daysRented = 7;
		Rental rental = new Rental(movie, daysRented);
		
		customer.addRental(rental);
		statement = customer.statement();
		assertEquals("Rental Record for Bob\n	Australia Trip	21.0\nAmount owed is 21.0\nYou earned 2 frequent renter points", statement);

		movie = new Movie("Australia For Kids", Movie.CHILDRENS);
		daysRented = 3;
		rental = new Rental(movie, daysRented);
		
		customer.addRental(rental);
		statement = customer.statement();
		assertEquals("Rental Record for Bob\n\tAustralia Trip\t21.0\n\tAustralia For Kids\t1.5\nAmount owed is 22.5\nYou earned 3 frequent renter points", statement);

		movie = new Movie("Australian Animals", Movie.REGULAR);
		daysRented = 100;
		rental = new Rental(movie, daysRented);
		
		customer.addRental(rental);
		statement = customer.statement();
		assertEquals("Rental Record for Bob\n\tAustralia Trip\t21.0\n\tAustralia For Kids\t1.5\n\tAustralian Animals	149.0\nAmount owed is 171.5\nYou earned 4 frequent renter points", statement);

	}
}
