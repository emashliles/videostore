import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class Movie
{
	private String title;

	Movie(String title) {
		this.title 		= title;
	}

	public static Movie createMovie(String title, int priceCode) {
		switch(priceCode){
		    case MovieTypes.NEW_RELEASE:
			    return new NewReleaseMovie(title);
			case MovieTypes.REGULAR:
				return new RegularMovie(title);
			case MovieTypes.CHILDRENS:
				return new ChildrensMovie(title);
			default:
				throw new NotImplementedException();
		}

	}

	public String getTitle () {
		return title;
	}

	public abstract double getTotalRentalCost(int daysRented);
}
