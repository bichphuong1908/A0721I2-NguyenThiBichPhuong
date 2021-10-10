package ss2_array_loop.baitap;

import java.util.Scanner;

public class HienThiSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i =0; i<100; i++){
            if(isPrimeNumber(i)){
                System.out.println(i + " ");
            }
        }
    }
    public static boolean isPrimeNumber(int n) {
        // n < 2 không phải số nguyên tố
        if(n<2){
            return false;
        }
        // check số nguyên tố khi n >=2
        int squareRoot = (int)Math.sqrt(n);
        for(int i=2; i<= squareRoot; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
