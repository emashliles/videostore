import java.util.ArrayList;
import java.util.List;

public class Customer
{
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer (String name) {
		this.name = name;
	}

	public void addRental (Rental rental) {
		rentals.add(rental);
	}

	public String statement () {
		double 				totalAmount 			= 0;
		int					frequentRenterPoints 	= 0;
		String 				result 					= "Rental Record for " + name + "\n";

		for(Rental rental : rentals){
			double totalCost = 0;

			totalCost += rental.getTotalRentalCost();

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

		if (each.getMovie() instanceof NewReleaseMove
                && each.getDaysRented () > 1) {
            frequentRenterPoints++;
        }
		return frequentRenterPoints;
	}

}
