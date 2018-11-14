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
		xt.setLocal(false);
		xt.setCreated(date);
		
		X_Tax xt2 = new X_Tax();
		Calendar calendar = new GregorianCalendar(2018, 6, 6);
		Date date = calendar.getTime();
		xt2.setId("2");
		xt2.setTax("tax2");
		xt2.setLocal(true);
		xt2.setCreated(date);

		X_Tax xt3 = new X_Tax();
	}

	@Test
	public void taxListIsValid() {
		xTaxList = new ArrayList<>();
		xTaxList.add(xt);
		List<String> errorList = MTax.validate(xTaxList);

		boolean hasTaxNotValid = false;
		for(String error : errorList) {
			if (error == "La lista de impuestos no es válida") {
				hasTaxNotValid = true;
			}
		}
		assertTrue(!hasTaxNotValid);
	}

	@Test
	public void taxListIsNotValid() {
		X_Tax xt = new X_Tax();
		xTaxList = new ArrayList<>();
		xTaxList.add(xt);
		List<String> errorList = MTax.validate(xTaxList);
		assertTrue(!errorList.isEmpty());
	}

}
