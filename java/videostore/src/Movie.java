import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class Movie
{
	public static final int CHILDRENS	= 2;
	public static final int REGULAR 	= 0;
	public static final int NEW_RELEASE = 1;

	private String title;

	Movie(String title) {
		this.title 		= title;
	}

	public static Movie createMovie(String title, int priceCode) {
		switch(priceCode){
		    case NEW_RELEASE:
			    return new NewReleaseMove(title, priceCode);
			case REGULAR:
				return new RegularMovie(title, priceCode);
			case CHILDRENS:
				return new ChildrensMovie(title, priceCode);
			default:
				throw new NotImplementedException();
		}

	}

	public String getTitle () {
		return title;
	}

	public abstract double getTotalRentalCost(int daysRented);
}
