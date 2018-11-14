import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MTax implements Constant {
    
    public MTax(){}
    
    public static List<String> validate(List<X_Tax> xTaxList) {
        List<String> errorList = new ArrayList<>();

        if (xTaxList != null && !xTaxList.isEmpty()) {
            List<String> validIdList = new ArrayList<>();
            bool hasNonLocalRate = false;
            for (X_Tax tax : xTaxList) {
                if (tax.getId() != null) {
                    validIdList.add(tax.getId().toString());
                }
                if (tax.getTax() == null) {
                    errorList.add("El impuesto es obligatorio");
                }
                if (!tax.isLocal()) {
                    hasNonLocalRate = true;
                }
            }
            if (!hasNonLocalRate) {
                errorList.add("Debe de incluir al menos una tasa no local");
            }
            if (!validIdList.isEmpty()) {
                List<X_Tax> xtList  = TaxsByListId(validIdList, false);
                if (xtList.size() != validIdList.size()) {
                    errorList.add("Existen datos no guardados previamente");
                } else {
                    HashMap<String, X_Tax> map_taxs = new HashMap<String, X_Tax>();
                    for (X_Tax tax : xtList) {
                        map_taxs.put(tax.getId().toString(), tax);
                    }
                    for (X_Tax tax : xTaxList) {
                        if (tax.getId() != null) {
                            String taxId = tax.getId().toString();
                            tax.setCreated(map_taxs.get(taxId).getCreated());
                        }
                    }
                }
            }
        }
        else{
            errorList.add("La lista de impuestos no es válida");
        }
        return errorList;
    }

}
