package thi_module2.controller;

import thi_module2.services.GenuinePhoneService;

import java.util.Scanner;

public class Main {
    static final int ADD = 1;
    private static GenuinePhoneService genuinePhoneService= new GenuinePhoneService();

    public static void main(String[] args) {
        boolean flag = true;
        do {
            System.out.println("Chọn chức năng cần thực hiên" +
                    "\n1.add" +
                    "\n2.delete" +
                    "\n3.display" +
                    "\n4.search" +
                    "\n5.Exit");
            Scanner scanner = new Scanner(System.in);
            int chooseMenu = scanner.nextInt();
            switch (chooseMenu) {
                case 1:
                    genuinePhoneService.add();
                    break;
                case 2:
                    System.out.println("chức năng delete");
                    genuinePhoneService.delete();
                    break;
                case 3:
                    genuinePhoneService.display();
                    break;
                case 4:
                    System.out.println("chức năng search");
                    genuinePhoneService.searchByName();
                    break;
                default:
                    flag=false;
            }
        }while (flag) ;
        }
    }
