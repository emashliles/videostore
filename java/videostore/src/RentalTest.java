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

    @Test
    public void TotalCostForRegularMovieCanCalculateAmountForMoreThan2Days() {
        Movie movie = Movie.createMovie("Regular", MovieTypes.REGULAR);
        double totalCostForRegularMovie = movie.getTotalRentalCost(3);

        assertEquals(3.5, totalCostForRegularMovie);
    }

    @Test
    public void TotalCostForChildrensMovieCanCalculateAmountForMoreThan3Days() {
        Movie movie = Movie.createMovie("Childrens", MovieTypes.CHILDRENS);
        double totalCostForChildrensMovie = movie.getTotalRentalCost(4);

        assertEquals(3.0, totalCostForChildrensMovie);
    }

    @Test
    public void TotalCostForNewReleaseMovieCanCalculateAmount() {
        Movie movie = Movie.createMovie("New Release", MovieTypes.NEW_RELEASE);
        double totalCostForNewReleaseMovie = movie.getTotalRentalCost(3);

        assertEquals(9.0, totalCostForNewReleaseMovie);

    }
}
