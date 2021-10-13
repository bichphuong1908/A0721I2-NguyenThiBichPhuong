package ss5_static_ac.baitap.accessmodifier;

public class Test {
    public static void main(String[] args) {
        TestCircle circle = new TestCircle(1);
        System.out.println("Radius of the circle "+circle.getRadius());
        System.out.println("Area of the circle "+circle.getArea());

    }
}
