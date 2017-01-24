import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MovieTest {
    @Test
    public void CalculateCostOfRegularMovieRental() {
        Movie movie = Movie.createMovie("Regular", MovieTypes.REGULAR);
        double totalCostForRegularMovie = movie.getTotalRentalCost(3);

        assertEquals(3.5, totalCostForRegularMovie);
    }

    @Test
    public void CalculateCostOfChildrensMovieRental() {
        Movie movie = Movie.createMovie("Childrens", MovieTypes.CHILDRENS);
        double totalCostForChildrensMovie = movie.getTotalRentalCost(4);

        assertEquals(3.0, totalCostForChildrensMovie);
    }

    @Test
    public void CalculateCostOfNewReleaseMovieRental() {
        Movie movie = Movie.createMovie("New Release", MovieTypes.NEW_RELEASE);
        double totalCostForNewReleaseMovie = movie.getTotalRentalCost(3);

        assertEquals(9.0, totalCostForNewReleaseMovie);

    }
}
