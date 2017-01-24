public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    public double getTotalRentalCost(int daysRented) {
        double costPerExtraRentalDay= 1.5;
        double baseRentalCost= 1.5;
        int baseRentalDays = 3;

        if (daysRented > baseRentalDays) {
            baseRentalCost += (daysRented- baseRentalDays) * costPerExtraRentalDay;
        }
        return baseRentalCost;
    }
}
