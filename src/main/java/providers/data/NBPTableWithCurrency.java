package providers.data;

import java.util.List;

public class NBPTableWithCurrency {
   private String table;
   private String currency;
   private String code;
   private List<RatesWithCurrency> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<RatesWithCurrency> getRates() {
        return rates;
    }

    public void setRates(List<RatesWithCurrency> rates) {
        this.rates = rates;
    }

    @Override public String toString() {
        return "NBPTableWithCurrency{"
               + "table='"
               + table
               + '\''
               + ", currency='"
               + currency
               + '\''
               + ", code='"
               + code
               + '\''
               + ", rates="
               + rates
               + '}';
    }
}
