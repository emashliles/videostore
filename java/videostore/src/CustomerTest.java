import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer =  new Customer("Name");
    }

    @Test
    public void ThisAmountForRegularMovieCanCalculateAmountForMoreThan2Days() {
        Rental rental = new Rental( new Movie("Regular", Movie.REGULAR), 3);
        double thisAmountForRegualrMovie = customer.getThisAmountForRegularMovie(0, rental);
        assertEquals(3.5, thisAmountForRegualrMovie);
    }

    @Test
    public void ThisAmountForChildrensMovieCanCalculateAmountForMoreThan3Days() {
        Rental rental = new Rental( new Movie("Childrens", Movie.CHILDRENS), 4);
        double thisAmountForChildrensMovie = customer.getThisAmountForChildrensMovie(0, rental);

        assertEquals(3.0, thisAmountForChildrensMovie);

    }

    @Test
    public void ThisAmountForNewReleaseMovieCanCalculateAmount() {
        Rental rental = new Rental( new Movie("New Release", Movie.NEW_RELEASE), 3);
        double thisAmountForNewReleaseMovie = customer.getThisAmountForNewReleaseMovie(0, rental);

        assertEquals(9.0, thisAmountForNewReleaseMovie);

    }
}