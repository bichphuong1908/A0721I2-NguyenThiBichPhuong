package ss2_array_loop;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        boolean flag = true;
        do{
            System.out.println("chọn chức năng cần thực hiện " +
                    "\n1.add " +
                    "\n2.display " +
                    "\n3.edit " +
                    "\n4.Exit ");
            Scanner scanner = new Scanner(System.in);
            int chooseMenu = scanner.nextInt();
            switch (chooseMenu){
                case 1:
                    System.out.println("chức năng thêm mới");
                    // code
                    break;
                case 2:
                    System.out.println("chức năng hiển thị");
                    // code
                    break;
                case 3:
                    System.out.println("chức năng update");
                    // code
                    break;
                default:
                    flag = false;
            }
        }while (flag);

    }
}
