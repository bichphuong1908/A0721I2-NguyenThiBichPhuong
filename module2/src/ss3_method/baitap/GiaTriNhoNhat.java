package ss3_method.baitap;

import java.util.Scanner;

public class GiaTriNhoNhat {
    public static void main(String[] args) {
        // khai báo khởi tạo mảng
        int[] size = {4, 12, 7, 8, 1, 6, 9};

        int min = size[0];
        for (int i = 0; i < size.length; i++){
            if(size[i]<min){
                min = size[i];
            }
        }
        System.out.println("Giá trị nhở nhất: " + min);
    }

}
