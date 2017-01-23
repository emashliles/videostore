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
    public void CalculatesFrequentRenterPoints(){
        Rental rental = new Rental( new Movie("Regular", Movie.REGULAR), 3);
        int frequentRenterPoints = customer.getFrequentRenterPoints(0, rental);

        assertEquals(1, frequentRenterPoints);
    }

    @Test
    public void CalculatesFrequentRenterPointsForNewRelease(){
        Rental rental = new Rental( new Movie("NewRelease", Movie.NEW_RELEASE), 3);
        int frequentRenterPoints = customer.getFrequentRenterPoints(0, rental);

        assertEquals(2, frequentRenterPoints);
    }

    @Test
    public void TotalCostForRegularMovieCanCalculateAmountForMoreThan2Days() {
        Rental rental = new Rental( new Movie("Regular", Movie.REGULAR), 3);
        double totalCostForRegualrMovie = customer.totalCostForRegularMovie(0, rental);
        assertEquals(3.5, totalCostForRegualrMovie);
    }

    @Test
    public void TotalCostForChildrensMovieCanCalculateAmountForMoreThan3Days() {
        Rental rental = new Rental( new Movie("Childrens", Movie.CHILDRENS), 4);
        double totalCostForChildrensMovie = customer.totalCostForChildrensMovie(0, rental);

        assertEquals(3.0, totalCostForChildrensMovie);

    }

    @Test
    public void TotalCostForNewReleaseMovieCanCalculateAmount() {
        Rental rental = new Rental( new Movie("New Release", Movie.NEW_RELEASE), 3);
        double totalCostForNewReleaseMovie = customer.totalCostForNewReleaseMovie(0, rental);

        assertEquals(9.0, totalCostForNewReleaseMovie);

    }
}