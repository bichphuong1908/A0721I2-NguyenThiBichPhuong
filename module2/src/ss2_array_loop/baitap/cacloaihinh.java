package ss2_array_loop.baitap;

import java.util.Scanner;

public class CacLoaiHinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. In hình chữ nhật");
            System.out.println("2. In hình tam giác vuông, có cạnh góc vuông ở botton-left");
            System.out.println("3. In hình tam giác vuông, có cạnh góc vuông ở top-left ");
            System.out.println("4. In hình tam giác cân");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1. In hình chữ nhật");
                    for (int i = 1; i < 4; i++) {
                        for (int j = 1; j < 8; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;

                case 2:
                    System.out.println("2. In hình tam giác vuông, có cạnh góc vuông ở botton-left");
                    for(int i= 0; i<=5; i++){
                        for(int j= 0; j<i; j++){
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;

                case 3:
                    System.out.println("3. In hình tam giác vuông, có cạnh góc vuông ở top-left ");
                    for(int i= 5;i>=0;i--){
                        for(int j= 0;j<=i;j++){
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;

                case 4:
                    System.out.println("4. In hình tam giác cân");
                    for (int i=1; i<=5; i++) {
                        for (int k=5; k>i; k--) {
                           System.out.print(" ");
                        }
                        for(int j=1; j<=2*i-1; j++) {
                            System.out.print('*');
                        }
                        System.out.println("");
                    }
                    break;

                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
