package ss3_method;

import java.util.Arrays;

public class DemoThamTriThamChieu {
    public static void main(String[] args) {
        int x = 1;
        System.out.println("trước khi tuyền vào x = " +x);
        changValue1(x);
        System.out.println("sau khi truyền vào x = " + x);

        int[] array = {1, 2, 3}; // array gọi là biến tham chiếu {1,2,3}, đối tượng
        System.out.println("trước khi thay dổi: " + Arrays.toString(array));
        changArray(array);
        System.out.println("sau khi thay đổi: " + Arrays.toString(array));
    }

    public static void changValue1(int a) {
        int c= 0;
        a +=1;
        System.out.println("bên trong ham = " +a);
    }

    public static void changArray(int[] arr) {
        for(int i=0; i< arr.length; i++){
            arr[i] = 10;
        }
        System.out.println("trong hàm thay đổi: " + Arrays.toString(arr));
    }
}
