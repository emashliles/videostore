public class NewReleaseMove extends Movie {
    public NewReleaseMove(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double getTotalRentalCost(int daysRented) {
        return daysRented * 3;
    }
}
