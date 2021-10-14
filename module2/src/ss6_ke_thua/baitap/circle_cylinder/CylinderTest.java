package ss6_ke_thua.baitap.circle_cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(4);
        System.out.println(cylinder);

        cylinder = new Cylinder(2,"green",4);
        System.out.println(cylinder);
    }
}
