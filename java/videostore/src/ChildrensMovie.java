public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double getTotalRentalCost(int daysRented) {
        double totalCost = 1.5;
        if (daysRented > 3)
            totalCost += (daysRented- 3) * 1.5;
        return totalCost;
    }
}
