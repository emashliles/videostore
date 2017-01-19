import junit.framework.*;

public class VideoStoreTest extends TestCase
{
	public VideoStoreTest (String name) {
		super (name);
	}

	private Customer customer;

	protected void setUp ()  {
		customer = new Customer ("Customer");
	}

	public void testSingleNewReleaseStatement () {
		customer.addRental (new Rental (new Movie ("New Release", Movie.NEW_RELEASE), 3));
		assertEquals ("Rental Record for Customer\n" +
				"\tNew Release\t9.0\n" +
				"You owed 9.0\n" +
				"You earned 2 frequent renter points\n",
				customer.statement ());
	}

	public void testDualNewReleaseStatement () {
		customer.addRental (new Rental (new Movie ("New Release", Movie.NEW_RELEASE), 3));
		customer.addRental (new Rental (new Movie ("Another New Release", Movie.NEW_RELEASE), 3));
		assertEquals ("Rental Record for Customer\n" +
				"\tNew Release\t9.0\n" +
				"\tAnother New Release\t9.0\n" +
				"You owed 18.0\n" +
				"You earned 4 frequent renter points\n",
				customer.statement ());
	}

	public void testSingleChildrensStatement () {
		customer.addRental (new Rental (new Movie ("Childrens", Movie.CHILDRENS), 3));
		assertEquals ("Rental Record for Customer\n" +
				"\tChildrens\t1.5\n" +
				"You owed 1.5\n" +
				"You earned 1 frequent renter points\n",
				customer.statement ());
	}

	public void testMultipleRegularStatement () {
		customer.addRental (new Rental (new Movie ("Regular", Movie.REGULAR), 1));
		customer.addRental (new Rental (new Movie ("Another Regular", Movie.REGULAR), 2));
		customer.addRental (new Rental (new Movie ("Different Regular", Movie.REGULAR), 3));

		assertEquals ("Rental Record for Customer\n" +
				"\tRegular\t2.0\n" +
				"\tAnother Regular\t2.0\n" +
				"\tDifferent Regular\t3.5\n" +
				"You owed 7.5\n" +
				"You earned 3 frequent renter points\n",
				customer.statement ());
	}
}
