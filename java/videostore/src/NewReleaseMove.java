public class NewReleaseMove extends Movie {
    public NewReleaseMove(String title) {
        super(title);
    }

    @Override
    public double getTotalRentalCost(int daysRented) {
        return daysRented * 3;
    }
}
