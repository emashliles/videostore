public class ChildrensMovie extends Movie {

    public static final double COST_PER_EXTRA_RENTAL_DAY = 1.5;
    public static final int BASE_RENTAL_DAYS = 3;
    public static final double BASE_RENTAL_COST = 1.5;

    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    public double getTotalRentalCost(int daysRented) {
        double rentalCost = 0.0;

        rentalCost += BASE_RENTAL_COST;

        if (daysRented > BASE_RENTAL_DAYS) {
            rentalCost += (daysRented- BASE_RENTAL_DAYS) * COST_PER_EXTRA_RENTAL_DAY;
        }
        return rentalCost;
    }
}
