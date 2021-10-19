package ss7_abstractclass_interface.baitap.interface_resizeable;

import java.util.Random;

public class SquareTest {
    public static void main(String[] args) {
    /*    Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square(5.8, "yellow", true);
        System.out.println(square);

        square.resize(6.9);
        System.out.println(square); */

        Random random = new Random();
        Square[] squares = new Square[20];
        int length = squares.length;
        // init array circle
        for (int i = 0; i < length; i++) {
            squares[i] = new Square(7);
        }
        // resize
        for (int i = 0; i < length; i++) {
            System.out.println("=======================================================");
            System.out.println("Shape " + (i + 1) + " :");
            System.out.println("A Rectangle with width before resize: " + squares[i].getWidth());
            System.out.println("A Rectangle with width before resize: " + squares[i].getLength());
            System.out.println("Area before resize: " + squares[i].getArea());
            int percent = (int)(random.nextDouble() * 100);
            System.out.println("Percent: " + percent);
            squares[i].resize(percent);
            System.out.println("A Rectangle with width after resize: " + squares[i].getWidth());
            System.out.println("A Rectangle with width after resize: " + squares[i].getLength());
            System.out.println("Area after resize: " + squares[i].getArea());
        }
    }
}
