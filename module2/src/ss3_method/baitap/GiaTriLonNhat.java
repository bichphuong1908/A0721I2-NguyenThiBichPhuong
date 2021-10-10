package ss3_method.baitap;

import java.util.Scanner;

public class GiaTriLonNhat {
    public static void main(String[] args) {
        int m;
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập m: ");
        m = scanner.nextInt();
        System.out.println("nhập n: ");
        n = scanner.nextInt();

        int max = 0;
        int a[][] = new int[m][n];

        System.out.println("");
        for( int i=0;i<m;i++){
            for ( int j=0; j<n;j++) {
                System.out.println("A[" + i + "]["+ j + "] = ");
                a[i][j] = scanner.nextInt();
                if (a[i][j] >max) {
                    max= a[i][j];
                }
            }
        }
        System.out.println("số lớn nhất " + max + " ");
    }
}
