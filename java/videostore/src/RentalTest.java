import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RentalTest {

    @Test
    public void CalculatesFrequentRenterPoints(){
        Rental rental = new Rental(Movie.createMovie("Regular", MovieTypes.REGULAR), 3);
        int frequentRenterPoints = rental.getFrequentRenterPoints();

        assertEquals(1, frequentRenterPoints);
    }

    @Test
    public void CalculatesFrequentRenterPointsForNewRelease(){
        Rental rental = new Rental(Movie.createMovie("NewRelease", MovieTypes.NEW_RELEASE), 3);
        int frequentRenterPoints = rental.getFrequentRenterPoints();

        assertEquals(2, frequentRenterPoints);
    }

}
