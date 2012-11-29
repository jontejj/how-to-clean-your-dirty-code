package se.softhouse.clean.videostore;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class VideoStoreTest
{
	@Test
	public void testThatRentingAChildrensMovieIsCheap()
	{
		Customer kid = new Customer("Ken");
		kid.addRental(new Rental(new Movie("Barbie", Price.CHILDRENS), 3));

		String statement = kid.statement();
		assertThat(statement.toString()).contains("Barbie	1.5");
	}

	@Test
	public void testBonusForTwoDayNewReleaseRental()
	{
		Customer parent = new Customer("Kirk");
		parent.addRental(new Rental(new Movie("Star Trek", Price.NEW_RELEASE),
				3));

		String statement = parent.statement();
		assertThat(statement).contains("Rental Record for Kirk");
		assertThat(statement).contains("Star Trek\t9.0");
		assertThat(statement).contains("Amount owed is 9.0");
		assertThat(statement).contains("You earned 2 frequent renter points");
	}

	@Test
	public void testRentingOneOfEachMovie()
	{
		Customer parent = new Customer("Kirk");
		parent.addRental(new Rental(new Movie("Star Trek", Price.NEW_RELEASE),
				1));
		parent.addRental(new Rental(new Movie("Le voyage dans la lune",
				Price.REGULAR), 1));
		parent.addRental(new Rental(new Movie(
				"The Many Adventures of Winnie the Pooh", Price.CHILDRENS), 1));

		String statement = parent.statement();
		assertThat(statement).isEqualTo(
				"Rental Record for Kirk\n" + "\tStar Trek\t3.0\n"
						+ "\tLe voyage dans la lune\t2.0\n"
						+ "\tThe Many Adventures of Winnie the Pooh\t1.5\n"
						+ "Amount owed is 6.5\n"
						+ "You earned 3 frequent renter points");
	}
}
