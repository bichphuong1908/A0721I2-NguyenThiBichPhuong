package ss1_introduction_to_java.baitap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("mời bạn nhạp số tiền USD: ");
        usd = sc.nextDouble();
        double quydoi = usd * 23000;
        System.out.println("giá trị VND: " +quydoi);


    }
}

