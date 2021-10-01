package ss1_introduction_to_java.thuchanh.ss1;

import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        // hiển thị thì dùng (sout)
        System.out.println("hello");
        // nhận từ bàn phím => sử dụng đối tượng Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("nhâp tên");
        String name = sc.nextLine(); // nhập chuổi
        System.out.println("nhập tuổi");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("nhập địa chỉ");
        String address = sc.nextLine();
        System.out.println("nhập lương");
        double salary = Double.parseDouble(sc.nextLine());
        System.out.println("tên vừa nhập: " +name);
        System.out.println("tuổi vừa nhập: " +age);
        System.out.println("ĐC vừa nhập: " +address);
        System.out.println("lương vừa nhập: " +salary);
    }
}
