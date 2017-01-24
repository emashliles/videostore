import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RentalTest {

    @Test
    public void TotalCostForRegularMovieCanCalculateAmountForMoreThan2Days() {
        Rental rental = new Rental(Movie.createMovie("Regular", MovieTypes.REGULAR), 3);
        double totalCostForRegualrMovie = rental.getTotalRentalCost();
        assertEquals(3.5, totalCostForRegualrMovie);
    }

    @Test
    public void TotalCostForChildrensMovieCanCalculateAmountForMoreThan3Days() {
        Rental rental = new Rental(Movie.createMovie("Childrens", MovieTypes.CHILDRENS), 4);
        double totalCostForChildrensMovie = rental.getTotalRentalCost();

        assertEquals(3.0, totalCostForChildrensMovie);

    }

    @Test
    public void TotalCostForNewReleaseMovieCanCalculateAmount() {
        Rental rental = new Rental(Movie.createMovie("New Release", MovieTypes.NEW_RELEASE), 3);
        double totalCostForNewReleaseMovie = rental.getTotalRentalCost();

        assertEquals(9.0, totalCostForNewReleaseMovie);

    }
}
