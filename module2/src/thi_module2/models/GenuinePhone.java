package thi_module2.models;

public class GenuinePhone extends Telephone{
    private int time;
    private String insurance;

    public GenuinePhone() {
    }

    public GenuinePhone(int time, String insurance) {
        this.time = time;
        this.insurance = insurance;
    }

    public GenuinePhone(int id, String name, int price, int quantity, String producer, int time, String insurance) {
        super(id, name, price, quantity, producer);
        this.time = time;
        this.insurance = insurance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "id=" + id + '\'' +
                ", name=" + name + '\'' +
                ", price=" + price + '\'' +
                ", quantity=" + quantity + '\'' +
                ", prodcer=" + producer + '\'' +
                ", time=" + time + '\'' +
                ", insurance='" + insurance + '\'' ;
    }
    @Override
    public String getInfoToCSV() {
        return this.id + "," + this.name + "," + this.price + "," + this.quantity + "," + this.producer + "," + this.time + "," + this.insurance;
    }
}
