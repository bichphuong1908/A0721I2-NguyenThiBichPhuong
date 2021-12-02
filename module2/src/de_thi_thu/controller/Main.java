package de_thi_thu.controller;

import de_thi_thu.service.SanPhamNhapKhauServices;

import java.util.Scanner;

public class Main {
    static final int ADD = 1;
    private static SanPhamNhapKhauServices sanPhamNhapKhauServices = new SanPhamNhapKhauServices();

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
                    sanPhamNhapKhauServices.add();
                    break;
                case 2:
                    System.out.println("chức năng delete");
                    sanPhamNhapKhauServices.delete();
                    break;
                case 3:
                    sanPhamNhapKhauServices.display();
                    break;
                case 4:
                    System.out.println("chức năng search");
                    sanPhamNhapKhauServices.searchByName();
                    break;
                default:
                    flag=false;

            }
        }while (flag);
    }
}
