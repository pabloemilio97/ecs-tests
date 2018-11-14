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
	
	@Mock
	X_Tax TaxsByListId;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@Test
	public void taxListIsValid() {
		X_Tax xt = new X_Tax();
		List<X_Tax> xTaxList = new ArrayList<>();
		xTaxList.add(xt);
		List<String> errorList = MTax.validate(xTaxList);

		boolean hasTaxListNotValid = false;
		for(String error : errorList) {
			if (error == "La lista de impuestos no es válida") {
				hasTaxListNotValid = true;
			}
		}
		assertTrue(!hasTaxListNotValid);
	}

	@Test
	public void taxListIsNotValid() {
		List<X_Tax> xTaxList;
		List<String> errorList = MTax.validate(xTaxList);
		
		boolean hasTaxListNotValid = false;
		for(String error : errorList) {
			if (error == "La lista de impuestos no es válida") {
				hasTaxListNotValid = true;
			}
		}
		assertTrue(hasTaxListNotValid);
	}

	@Test
	public void errorListContainsTaxError() {
		X_Tax xt = new X_Tax();
		List<X_Tax> xTaxList = new ArrayList<>();
		xTaxList.add(xt);
		List<String> errorList = MTax.validate(xTaxList);

		boolean hasTax = true;
		for(String error : errorList) {
			if (error == "El impuesto es obligatorio") {
				hasTax = false;
			}
		}
		assertTrue(hasTax);
	}

}
