import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CustomerStatementTest
{
	private Customer customer;

@Before
	public void setUp ()  {
		customer = new Customer ("Customer");
	}

    @Test
	public void statementForOneNewReleaseRental() {
		customer.addRental (getMovieRental("New Release", MovieTypes.NEW_RELEASE,3));

		String rentalCost = "9.0";
		String frequentRenterPoints = "2";
		assertEquals (getExpected((String) rentalCost, (String) frequentRenterPoints, "New Release"),
				customer.statement ());
	}

	public String getExpected(String rentalCost, String frequentRenterPoints, final String title) {
		return "Rental Record for Customer\n" +
				"\t" + title + "\t" + rentalCost + "\n" +
				"You owed " + rentalCost + "\n" +
						"You earned " + frequentRenterPoints + " frequent renter points\n";
	}

	@Test
	public void statementForTwoNewReleaseRentals() {
		customer.addRental (getMovieRental("New Release", MovieTypes.NEW_RELEASE, 3));
		customer.addRental (getMovieRental("Another New Release", MovieTypes.NEW_RELEASE, 3));

		assertEquals ("Rental Record for Customer\n" +
				"\tNew Release\t9.0\n" +
				"\tAnother New Release\t9.0\n" +
				"You owed 18.0\n" +
				"You earned 4 frequent renter points\n",
				customer.statement ());
	}

	@Test
	public void statementForOneSingleChildrensRental() {
		customer.addRental (getMovieRental("Childrens", MovieTypes.CHILDRENS, 3));

		assertEquals ("Rental Record for Customer\n" +
				"\tChildrens\t1.5\n" +
				"You owed 1.5\n" +
				"You earned 1 frequent renter points\n",
				customer.statement ());
	}

	@Test
	public void statementForChildrensRentalOver3Days() {
		customer.addRental (getMovieRental("Childrens", MovieTypes.CHILDRENS, 4));

		String rentalCost = "3.0";
		String frequentRenterPoints = "1";
		assertEquals (getExpected(rentalCost, frequentRenterPoints, "Childrens"),
				customer.statement ());
	}

	@Test
	public void statementForThreeRegularRentals() {
		customer.addRental (getMovieRental("Regular", MovieTypes.REGULAR, 1));
		customer.addRental (getMovieRental("Another Regular", MovieTypes.REGULAR, 2));
		customer.addRental (getMovieRental("Different Regular", MovieTypes.REGULAR, 3));

		assertEquals ("Rental Record for Customer\n" +
				"\tRegular\t2.0\n" +
				"\tAnother Regular\t2.0\n" +
				"\tDifferent Regular\t3.5\n" +
				"You owed 7.5\n" +
				"You earned 3 frequent renter points\n",
				customer.statement ());
	}

	private Rental getMovieRental(String title, int priceCode, int daysRented) {
		return new Rental (Movie.createMovie(title, priceCode), daysRented);
	}
}
