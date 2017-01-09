package pensamientopositivo.es.mvp.mvp.model;

public class CakesResponse {
    private String product;
    private CakeStaffContacts[] staffContacts;
    private String releaseDate;
    private CakeResponseCakes[] cakes;
    private double version;

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public CakeStaffContacts[] getStaffContacts() {
        return this.staffContacts;
    }

    public void setStaffContacts(CakeStaffContacts[] staffContacts) {
        this.staffContacts = staffContacts;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public CakeResponseCakes[] getCakes() {
        return this.cakes;
    }

    public void setCakes(CakeResponseCakes[] cakes) {
        this.cakes = cakes;
    }

    public double getVersion() {
        return this.version;
    }

    public void setVersion(double version) {
        this.version = version;
    }
}
