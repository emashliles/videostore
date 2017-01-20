import java.util.Vector;
import java.util.Enumeration;

public class Customer
{
	private String name;
	private Vector rentals = new Vector ();

	public Customer (String name) {
		this.name = name;
	}

	public void addRental (Rental rental) {
		rentals.addElement (rental);
	}

	public String getName () {
		return name;
	}

	public String statement () {
		double 				totalAmount 			= 0;
		int					frequentRenterPoints 	= 0;
		Enumeration 		rentals 				= this.rentals.elements ();
		String 				result 					= "Rental Record for " + getName () + "\n";

		while (rentals.hasMoreElements ()) {
			double 		thisAmount = 0;
			Rental 		each = (Rental)rentals.nextElement ();

			// determines the amount for each line
			switch (each.getMovie ().getPriceCode ()) {
				case Movie.REGULAR:
					thisAmount = getThisAmountForRegularMovie(thisAmount, each);
					break;
				case Movie.NEW_RELEASE:
					thisAmount = getThisAmountForNewReleaseMovie(thisAmount, each);
					break;
				case Movie.CHILDRENS:
					thisAmount = getThisAmountForChildrensMovie(thisAmount, each);
					break;
			}

			frequentRenterPoints = getFrequentRenterPoints(frequentRenterPoints, each);

			result += "\t" + each.getMovie ().getTitle () + "\t"
								+ String.valueOf (thisAmount) + "\n";
			totalAmount += thisAmount;

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

	public double getThisAmountForNewReleaseMovie(double thisAmount, Rental each) {
		thisAmount += each.getDaysRented () * 3;
		return thisAmount;
	}

	public double getThisAmountForRegularMovie(double thisAmount, Rental each) {
		thisAmount += 2;
		if (each.getDaysRented () > 2)
            thisAmount += (each.getDaysRented () - 2) * 1.5;
		return thisAmount;
	}
	public double getThisAmountForChildrensMovie(double thisAmount, Rental each) {
		thisAmount += 1.5;
		if (each.getDaysRented () > 3)
            thisAmount += (each.getDaysRented () - 3) * 1.5;
		return thisAmount;
	}
}
