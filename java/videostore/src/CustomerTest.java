import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest {

    @Test
    public void ThisAmountForChildrensMovieCanCalculateAmountForMoreThan3Days() throws Exception {

        Customer customer = new Customer("Name");
        Rental rental = new Rental( new Movie("Childrens", Movie.CHILDRENS), 4);
        double thisAmountForChildrensMovie = customer.getThisAmountForChildrensMovie(0, rental);

        assertEquals(thisAmountForChildrensMovie,1.5 );

    }

}