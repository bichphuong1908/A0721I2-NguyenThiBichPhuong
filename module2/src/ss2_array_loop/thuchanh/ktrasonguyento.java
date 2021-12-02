package ss2_array_loop.thuchanh;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class KtraSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a numbers: ");
        int number = scanner.nextInt();

        // Trường hợp numbers < 2  chúng ta sẽ hiển thị numbers không phải là số nguyên tố
        if(number < 2){
            System.out.println(number + " is not a prime");
        } else {
            int i = 2;
            boolean check = true;
            while (i<number){
                if(number % i == 0){
                    check = false;
                    break;
                }
                i++;
            }
            if(check)
                System.out.println(number + " is a prime");
            else
                System.out.println(number + " is not a prime");
        }
        // Còn lại khi numbers >= 2 chúng ta sẽ có đoạn code như sau
    }
}
