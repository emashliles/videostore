public class Rental
{
	private int daysRented;
	private Movie movie;

	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie () {
		return movie;
	}

	public double getTotalRentalCost() {
		return movie.getTotalRentalCost(daysRented);
	}

	public int getFrequentRenterPoints() {
		int frequentRenterPoints =1;

		if (getMovie() instanceof NewReleaseMove
                && daysRented > 1) {
            frequentRenterPoints++;
        }
		return frequentRenterPoints;
	}
}
