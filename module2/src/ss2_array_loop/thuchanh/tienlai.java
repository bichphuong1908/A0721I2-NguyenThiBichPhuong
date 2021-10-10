package ss2_array_loop.thuchanh;

import java.util.Scanner;

public class TienLai {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;
        Scanner input = new Scanner(System.in);

        // nhập số tiền gửi
        System.out.println("Enter investment amount: ");
        money = input.nextDouble();

        // nhập số tháng gửi
        System.out.println("Enter investment of months : ");
        month = input.nextInt();

        // nhập lãi xuất
        System.out.println("Enter annual interest rate in percentage :");
        interestRate = input.nextDouble();

        // tính lãi suất nhận được
        double totalInterest = 0;
        for(int i =0; i< month; i++){
            totalInterest += money * (interestRate/100)/12* month;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}
