public class RegularMovie extends Movie {

    public static final double COST_PER_EXTRA_RENTAL_DAY = 1.5;
    public static final int BASE_RENTAL_DAYS = 2;
    public static final double BASE_RENTAL_COST = 2;

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getTotalRentalCost(int daysRented) {
        double rentalCost = 0.0;

        rentalCost += BASE_RENTAL_COST;

        if (daysRented > BASE_RENTAL_DAYS) {
            rentalCost += (daysRented - BASE_RENTAL_DAYS) * COST_PER_EXTRA_RENTAL_DAY;
        }
        return rentalCost;
    }
}
