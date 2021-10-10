package ss3_method.baitap;

import java.util.Scanner;

public class XoaPhanTu {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
        // nhập giá trị cho các pt của mảng
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        // in ra mảng đã nhập
         System.out.printf("%-20s%s", "Elements in array: ", "");
         for (int j = 0; j < array.length; j++) {
             System.out.print(array[j] + "\t");
         }
        //  nhập số k cần xóa
        System.out.println("\nNhập số nguyên k:");
        int k = scanner.nextInt();

        for (int j = i = 0; i < size; i++) {
            if (array[i] != k) {
                array[j] = array[i];
                j++;
            }
        }
        int j = size;
        System.out.println("Mảng còn lại sau khi xóa phần tử " + k + " là: ");
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
