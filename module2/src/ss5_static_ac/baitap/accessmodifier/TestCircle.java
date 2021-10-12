package ss5_static_ac.baitap.accessmodifier;

public class TestCircle {
    private double radius = 1.0f;
    private String color = "red";
    public static int count ;

    public TestCircle() {
    }

    public TestCircle(double radius) {
        this.radius = radius;
        count++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
