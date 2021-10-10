package ss3_method.baitap;

import java.util.Arrays;

public class GopMang {
    public static void main(String[] args) {
        // khai báo và khởi tạo giá trị mảng
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        // length đổ dài 2 mảng cộng lại
        int length = array1.length + array2.length;
        // lưu trữ 2 mảng cần nối
        int[] result = new int[length];
        int pos = 0;

        for(int element : array1){
            result[pos] = element;
            pos++;
        }
        for(int element : array2){
            result[pos] = element;
            pos++;
        }

        System.out.println(Arrays.toString(result));
    }
}
