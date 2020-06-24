package ntou.wbse.hw4.entity;

public class QueryParameter {
    private String pharmacyName;
    private String zone;

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "QueryParameter{" + "pharmacyName='" + pharmacyName + '\'' + ", zone='" + zone + '}';
    }
}
