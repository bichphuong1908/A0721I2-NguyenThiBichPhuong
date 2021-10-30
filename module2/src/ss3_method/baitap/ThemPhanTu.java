package ss3_method.baitap;

import java.util.Scanner;

public class ThemPhanTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {1,3,5,6,7,8};
        int[] arr2 = new int[array.length + 1];
        System.out.print("Nhập số cần chèn :");
        int X = scanner.nextInt();
        System.out.print("Nhập vị trí cần chèn : ");
        int index = scanner.nextInt();
        if (index <= 1 || index >= array.length - 1) {
            System.out.println("không chèn được phần tử vào mảng");
        } else {
            for (int i = 0; i < index; i++) {
                arr2[i] = array[i];
            }
            arr2[index] = X;
            for (int j = index + 1; j < array.length + 1; j++) {
                arr2[j] = array[j - 1];
            }

            System.out.println("Mảng sau khi thêm là");
            for (int i = 0; i < arr2.length; i++) {
                System.out.print(arr2[i] + "\t");
            }
        }
    }
}
