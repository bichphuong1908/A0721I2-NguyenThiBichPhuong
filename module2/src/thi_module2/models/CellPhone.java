package thi_module2.models;

public class CellPhone extends Telephone{
    private String country;
    private String status;

    public CellPhone() {
    }

    public CellPhone(String country, String status) {
        this.country = country;
        this.status = status;
    }

    public CellPhone(int id, String name, int price, int quantity, String producer, String country, String status) {
        super(id, name, price, quantity, producer);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price + '\'' +
                ", quantity=" + quantity + '\'' +
                ", prodcer='" + producer + '\'' +
                ", country='" + country + '\'' +
                ", status='" + status + '\'';
    }
    @Override
    public String getInfoToCSV() {
        return this.id + "," + this.name + "," + this.price + "," + this.quantity + "," + this.producer + "," + this.country + "," + this.status;
    }
}
