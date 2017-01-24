public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    public double getTotalRentalCost(int daysRented) {
        double baseRentalCost;
        baseRentalCost = 1.5;
        if (daysRented > 3)
            baseRentalCost += (daysRented- 3) * 1.5;
        return baseRentalCost;
    }
}
