public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getTotalRentalCost(int daysRented) {
        double costPerExtraRentalDay = 1.5;
        double baseRentalCost = 2;
        int baseRentalDays = 2;

        if (daysRented > baseRentalDays) {
            baseRentalCost += (daysRented - baseRentalDays) * costPerExtraRentalDay;
        }
        return baseRentalCost;
    }
}
