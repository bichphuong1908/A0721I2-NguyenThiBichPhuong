package thi_module2.models;

public abstract class Telephone {
    protected int id;
    protected String name;
    protected int price;
    protected int quantity;
    protected String producer;

    public Telephone() {
    }

    public Telephone(int id, String name, int price, int quantity, String prodcer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProducer() {
        return producer;
    }

    public void setProdcer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price + '\'' +
                ", quantity=" + quantity + '\'' +
                ", prodcer='" + producer + '\'' ;
    }

    public abstract String getInfoToCSV();

}
