import java.util.ArrayList;
import java.util.List;

public class Customer
{
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer (String name) {
		this.name = name;
	}

	public void addRental (Rental rental) {
		rentals.add(rental);
	}

	public String getName () {
		return name;
	}

	public String statement () {
		double 				totalAmount 			= 0;
		int					frequentRenterPoints 	= 0;
		String 				result 					= "Rental Record for " + getName () + "\n";

		for(Rental rental : rentals){
			double totalCost = 0;

			// determines the amount for each line
			switch (rental.getMovie ().getPriceCode ()) {
				case Movie.REGULAR:
					totalCost = totalCostForRegularMovie(totalCost, rental);
					break;
				case Movie.NEW_RELEASE:
					totalCost = totalCostForNewReleaseMovie(totalCost, rental);
					break;
				case Movie.CHILDRENS:
					totalCost = totalCostForChildrensMovie(totalCost, rental);
					break;
			}

			frequentRenterPoints = getFrequentRenterPoints(frequentRenterPoints, rental);

			result += "\t" + rental.getMovie ().getTitle () + "\t"
								+ String.valueOf (totalCost) + "\n";
			totalAmount += totalCost;

		}

		result += "You owed " + String.valueOf (totalAmount) + "\n";
		result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";


		return result;
	}

	public int getFrequentRenterPoints(int frequentRenterPoints, Rental each) {
		frequentRenterPoints++;

		if (each.getMovie ().getPriceCode () == Movie.NEW_RELEASE
                && each.getDaysRented () > 1) {
            frequentRenterPoints++;
        }
		return frequentRenterPoints;
	}

	public double totalCostForNewReleaseMovie(double totalCost, Rental each) {
		totalCost += each.getDaysRented () * 3;
		return totalCost;
	}

	public double totalCostForRegularMovie(double totalCost, Rental each) {
		totalCost += 2;
		if (each.getDaysRented () > 2)
            totalCost += (each.getDaysRented () - 2) * 1.5;
		return totalCost;
	}
	public double totalCostForChildrensMovie(double totalCost, Rental each) {
		totalCost += 1.5;
		if (each.getDaysRented () > 3)
            totalCost += (each.getDaysRented () - 3) * 1.5;
		return totalCost;
	}
}
