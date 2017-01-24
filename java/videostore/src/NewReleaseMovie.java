public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getTotalRentalCost(int daysRented) {
        int costPerRentalDay = 3;
        return daysRented * costPerRentalDay;
    }
}
