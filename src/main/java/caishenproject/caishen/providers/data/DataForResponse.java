package caishenproject.caishen.providers.data;

public class DataForResponse {

    private double mid;
    private String effectiveDate;

    public DataForResponse(double mid, String effectiveDate) {
        this.mid = mid;
        this.effectiveDate = effectiveDate;
    }

    public double getMid() {
        return mid;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    @Override public String toString() {
        return "DataForResponse{" + "mid=" + mid + ", effectiveDate='" + effectiveDate + '\'' + '}';
    }
}
