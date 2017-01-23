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
		String statement = "Rental Record for " + name + "\n";

		for(Rental rental : rentals){
			double totalCost = rental.getTotalRentalCost();
			frequentRenterPoints += rental.getFrequentRenterPoints();
			statement += movieStatementLine(rental, totalCost);
			totalAmount += totalCost;
		}

		statement += "You owed " + String.valueOf (totalAmount) + "\n";
		statement += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";


		return statement;
	}

	private String movieStatementLine(Rental rental, double totalCost) {
		return "\t" + rental.getMovie ().getTitle () + "\t"
                            + String.valueOf (totalCost) + "\n";
	}

}
