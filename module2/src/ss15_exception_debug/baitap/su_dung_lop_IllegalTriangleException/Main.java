package ss15_exception_debug.baitap.su_dung_lop_IllegalTriangleException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khai bao doi tuong
        TriangleEdgesCheck check = new TriangleEdgesCheck();

        // Nhap du lieu
        try {
            System.out.print("Nhap vao canh thu nhat: ");
            int a = sc.nextInt();
            System.out.print("Nhap vao canh thu hai: ");
            int b = sc.nextInt();
            System.out.print("Nhap vao canh thu ba: ");
            int c = sc.nextInt();

            try {
                check.checkTriangleEdges(a, b, c);
            } catch (TriangleEdgesException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Sai: khong dung dinh dang!");
        }

        sc.close();
    }
}
