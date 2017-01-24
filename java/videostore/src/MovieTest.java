import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MovieTest {
    @Test
    public void CalculateCostOfRegularMovieRental() {
        String title = "Regular";
        double totalCostForRegularMovie = getTotalCostForMovie(title, MovieTypes.REGULAR, 3);

        assertEquals(3.5, totalCostForRegularMovie);
    }

    @Test
    public void CalculateCostOfChildrensMovieRental() {
        String title = "Childrens";
        double totalCostForChildrensMovie = getTotalCostForMovie(title, MovieTypes.CHILDRENS, 4);

        assertEquals(3.0, totalCostForChildrensMovie);
    }

    @Test
    public void CalculateCostOfNewReleaseMovieRental() {
        String title = "New Release";
        double totalCostForNewReleaseMovie = getTotalCostForMovie(title, MovieTypes.NEW_RELEASE, 3);

        assertEquals(9.0, totalCostForNewReleaseMovie);

    }

    public double getTotalCostForMovie(String title, int priceCode, int daysRented) {
        Movie movie = Movie.createMovie(title, priceCode);
        return movie.getTotalRentalCost(daysRented);
    }
}
