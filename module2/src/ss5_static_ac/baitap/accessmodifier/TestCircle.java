package ss5_static_ac.baitap.accessmodifier;

public class TestCircle {
    private double radius = 1.0f;
    private String color = "red";

    public TestCircle() {
    }

    public TestCircle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        return radius * radius * 3.14;
    }

}
