package ss4_class_object.baitap.lop_quadraticEquation;

import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        double a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a, b, c: ");
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        QuadraticEquation qe = new QuadraticEquation(a, b, c);
        if(qe.getDiscriminant()<0){
            System.out.println("Phương trình không có nghiệm nguyên: ");
        } else if(qe.getDiscriminant()==0){
            System.out.println("Phương trình có một nghiệm nguyên: "+qe.getRoot1());
        } else {
            System.out.println("Phương trình có hai nghiệm: ");
            System.out.println("Denta is: "+qe.getDiscriminant());
            System.out.println("Root1 is: "+qe.getRoot1());
            System.out.println("Root2 is:"+qe.getRoot2());
        }
    }
}
