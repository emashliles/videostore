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
        Rental rental = new Rental(Movie.createMovie("Regular", Movie.REGULAR), 3);
        int frequentRenterPoints = customer.getFrequentRenterPoints(0, rental);

        assertEquals(1, frequentRenterPoints);
    }

    @Test
    public void CalculatesFrequentRenterPointsForNewRelease(){
        Rental rental = new Rental(Movie.createMovie("NewRelease", Movie.NEW_RELEASE), 3);
        int frequentRenterPoints = customer.getFrequentRenterPoints(0, rental);

        assertEquals(2, frequentRenterPoints);
    }

}