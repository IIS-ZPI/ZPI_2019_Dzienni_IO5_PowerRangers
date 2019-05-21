package caishenproject.caishen.providers.data;

public class DataForResponse {

    private double difference;
    private String effectiveDate;

    public DataForResponse(double difference, String effectiveDate) {
        this.difference = difference;
        this.effectiveDate = effectiveDate;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override public String toString() {
        return "DataForResponse{" + "difference=" + difference + ", effectiveDate='" + effectiveDate + '\'' + '}';
    }
}
