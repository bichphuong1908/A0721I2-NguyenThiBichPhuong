package ss2_array_loop.thuchanh;

import java.util.Scanner;

public class UocChungLonNhat {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = input.nextInt();
        System.out.println("Enter b: ");
        b = input.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        // kiểm tra a, b có bằng 0 không
        if(a== 0 || b == 0){
            System.out.println("No greatest common factor");
        }

        // tìm ước chung
        while (a != b){
            if(a > b)
                a = a-b;
            else
                b = b-a;
        }
        System.out.println("Greatest common factor: " + a);
    }
}
