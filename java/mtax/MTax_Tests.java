import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

class MTax_Tests {

	private List<X_Tax> xTaxList = new ArrayList<>();
	
	@Mock
	X_Tax TaxsByListId;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		X_Tax xt = new X_Tax();
		Calendar calendar = new GregorianCalendar(2018, 5, 5);
		Date date = calendar.getTime();
		xt.setId("1");
		xt.setTax("tax1");
		xt.setLocal(true);
		xt.setCreated(date);
		
		X_Tax xt2 = new X_Tax();
		Calendar calendar = new GregorianCalendar(2018, 6, 6);
		Date date = calendar.getTime();
		xt2.setId("2");
		xt2.setTax("tax2");
		xt2.setLocal(false);
		xt2.setCreated(date);

		X_Tax xt3 = new X_Tax();

		xTaxList.add(xt);
		xTaxList.add(xt2);
		xTaxList.add(xt3);
	}

	@Test
	public void taxListIsValid() {
		List<String> errorList = MTax.validate(xTaxList);
		assertTrue(!errorList.isEmpty());
	}

	@Test
	public void taxListIsNotValid() {
		List<String> errorList = MTax.validate(xTaxList);
		assertTrue(errorList.isEmpty());
	}

}
