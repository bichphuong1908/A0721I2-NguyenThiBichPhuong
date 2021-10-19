package ss7_abstractclass_interface.baitap.interface_resizeable;

import java.util.Random;

public class RectangleTest {
    public static void main(String[] args) {
        //   Rectangle rectangle = new Rectangle();
        //    System.out.println(rectangle);

        //    rectangle = new Rectangle(2.3, 5.8);
        //   System.out.println(rectangle);

        //   rectangle = new Rectangle(2.5, 3.8, "orange", true);
        //    System.out.println(rectangle);

        //   rectangle.resize(5);
        //   System.out.println(rectangle);

        Random random = new Random();
        Rectangle[] rectangles = new Rectangle[20];
        int length = rectangles.length;
        // init array circle
        for (int i = 0; i < length; i++) {
            rectangles[i] = new Rectangle(5,10);
        }
        // resize
        for (int i = 0; i < length; i++) {
            System.out.println("=======================================================");
            System.out.println("Shape " + (i + 1) + " :");
            System.out.println("Area before resize: " + rectangles[i].getArea());
            int percent = (int)(random.nextDouble() * 100);
            System.out.println("Percent: " + percent);
            rectangles[i].resize(percent);
            System.out.println("Area after resize: " + rectangles[i].getArea());
        }
    }
}
