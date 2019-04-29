package providers.data;

import java.util.List;

public class NbpTableA {
    String table;
    String no;
    String effectiveDate;
    List<Rates> rates;

    public String getTable() {
        return table;
    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public List<Rates> getRates() {
        return rates;
    }
}
