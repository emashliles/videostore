import junit.framework.*;

public class CustomerStatementTest extends TestCase
{
	public CustomerStatementTest(String name) {
		super (name);
	}

	private Customer customer;

	protected void setUp ()  {
		customer = new Customer ("Customer");
	}

	public void testStatementForOneNewReleaseRental() {
		customer.addRental (getMovieRental("New Release",Movie.NEW_RELEASE,3));
		assertEquals ("Rental Record for Customer\n" +
				"\tNew Release\t9.0\n" +
				"You owed 9.0\n" +
				"You earned 2 frequent renter points\n",
				customer.statement ());
	}

	public void testStatementForTwoNewReleaseRentals() {
		customer.addRental (getMovieRental("New Release", Movie.NEW_RELEASE, 3));
		customer.addRental (getMovieRental("Another New Release", Movie.NEW_RELEASE, 3));
		assertEquals ("Rental Record for Customer\n" +
				"\tNew Release\t9.0\n" +
				"\tAnother New Release\t9.0\n" +
				"You owed 18.0\n" +
				"You earned 4 frequent renter points\n",
				customer.statement ());
	}

	public void testStatementForOneSingleChildrensRental() {
		customer.addRental (getMovieRental("Childrens", Movie.CHILDRENS, 3));
		assertEquals ("Rental Record for Customer\n" +
				"\tChildrens\t1.5\n" +
				"You owed 1.5\n" +
				"You earned 1 frequent renter points\n",
				customer.statement ());
	}

	public void testStatementForThreeRegularRentals() {
		customer.addRental (getMovieRental("Regular", Movie.REGULAR, 1));
		customer.addRental (getMovieRental("Another Regular", Movie.REGULAR, 2));
		customer.addRental (getMovieRental("Different Regular", Movie.REGULAR, 3));

		assertEquals ("Rental Record for Customer\n" +
				"\tRegular\t2.0\n" +
				"\tAnother Regular\t2.0\n" +
				"\tDifferent Regular\t3.5\n" +
				"You owed 7.5\n" +
				"You earned 3 frequent renter points\n",
				customer.statement ());
	}

	private Rental getMovieRental(String title, int priceCode, int daysRented) {
		return new Rental (new Movie (title, priceCode), daysRented);
	}
}
