package ss1_introduction_to_java.thuchanh.ss1;

import java.nio.Buffer;
import java.util.Scanner;

public class Student {
    int id; // biến instance => biến thuộc về dối tượng
    String name; // biến instance => biến thuộc về dối tượng
    public static void main(String[] args) {
        int number = 1; // biến local (cục bộ)
        float number2 = 20.0f;
        double number3 = 30.0f;
        char c = '2';
        String str = "chuoi";
        String string = "";
        System.out.println(string);
        Scanner scanner = new Scanner(System.in); // kiểu đối tượng
        Student student = new Student(); // kiểu dối tượng do lập trình viên tạo
        System.out.println(student.id);
        final double NUMBER = 21; // khai báo hằng
        // so sánh 2 dấu bằng đối tượng
        Student student1 = new Student();
        Student student2 = new Student();
        System.out.println(student1 == student2);

        if(number<number2){
            System.out.println("number1 nhỏ hơn number2");
        } else {
            System.out.println("number1 > number2");
        }
    }
}
