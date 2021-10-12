package ss5_static_ac.baitap.accessmodifier;

public class Test {
    public static void main(String[] args) {
        TestCircle circle1 = new TestCircle(1);
        System.out.println(TestCircle.count);

        TestCircle circle2 = new TestCircle(6);
        System.out.println(TestCircle.count);
    }
}
