package ss4_class_object.baitap.lop_quadraticEquation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {
    }

    // Phương thức khởi tạo với 3 tham số
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    // Phương thức gettter cho a, b và c.
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    // Phương thức getDiscriminant()
    public double getDiscriminant(){
        return b*b-4*a*c;
    }
    // Phương thức getRoot1() và getRoot2()
    public double getRoot1(){
        if(this.getDiscriminant()<0)
            return 0;
        return ((-b+Math.sqrt(this.getDiscriminant()))/(2*a));
    }
    public double getRoot2(){
        if(this.getDiscriminant()<0)
            return 0;
        return ((-b-Math.sqrt(this.getDiscriminant()))/(2*a));
    }
}
