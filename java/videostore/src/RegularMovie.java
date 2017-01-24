public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getTotalRentalCost(int daysRented) {
        double baseRentalCost;
        baseRentalCost = 2;
        if (daysRented > 2)
            baseRentalCost += (daysRented - 2) * 1.5;
        return baseRentalCost;
    }
}
