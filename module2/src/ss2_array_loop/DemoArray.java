package ss2_array_loop;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DemoArray {
    public static void main(String[] args) {
        int[] number; // khai báo
        String[] strings = {"abc", "efg"}; // khai báo và khỏi tạo trực tiếp
        // sử dụng để in thong tin của mảng
        System.out.println(Arrays.toString(strings));
        double[] doubles = new double[5]; // khai báo mảng có đọ dài 5 pt, mỗi pt
        // đang có gia trị mặc định 0.00
        // truy cập vào pt của mảng

        doubles[0] = 2;
       // doubles[5] = 6; // lỗi truy cập ngoài pt của mảng
        System.out.println("phần tử thứ 0: " + doubles[0]);

        // nhập dữ liệu cho mảng
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i <doubles.length; i++) {
            System.out.println("nhập vào phần tử thứ " + i);
            doubles[i] = scanner.nextInt();
        }

        // in ra mảng theo cách của riêng mình
        for(int i=0; i <doubles.length; i++){
            System.out.println("phần tử thứ " + i + ":" + doubles[i]);
        }
        // sử dụng foreach để in mảng
        for(double num : doubles){
            System.out.println("phần tử" + num);
        }
        // thay  dổi từ tổng mảng => cộng thêm mỗi phần tử lên 1

        double[] arrayNumber = {1, 2, 3, 4, 5};
        for(int i=0; i<arrayNumber.length; i++){
            arrayNumber[i] +=1;
        }
        System.out.println(Arrays.toString(arrayNumber));
        for(double num : arrayNumber){
            num +=num;
        }
    }
}
