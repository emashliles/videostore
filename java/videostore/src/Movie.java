import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Movie
{
	public static final int CHILDRENS	= 2;
	public static final int REGULAR 	= 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private int priceCode;

	Movie(String title, int priceCode) {
		this.title 		= title;
		this.priceCode 	= priceCode;
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

	public int getPriceCode () {
		return priceCode;
	}

	public String getTitle () {
		return title;
	}

}
