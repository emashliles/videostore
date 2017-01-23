public class RegularMovie extends Movie {
    public RegularMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double getTotalRentalCost(int daysRented) {
        double totalCost = 2;
        if (daysRented > 2)
            totalCost += (daysRented - 2) * 1.5;
        return totalCost;
    }
}
