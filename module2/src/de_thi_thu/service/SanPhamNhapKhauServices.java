package de_thi_thu.service;

import de_thi_thu.model.SanPhamNhapKhau;
import de_thi_thu.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SanPhamNhapKhauServices implements Services{
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("nhập id");
        int id =Integer.parseInt(scanner.nextLine());
        System.out.println("nhập mã sản phẩm");
        int masanpham = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên sản phẩm");
        String tensanpham = scanner.nextLine();
        System.out.println("nhập giá bán");
        int giaban = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập số lượng");
        int soluong = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập nhà sản xuất");
        String nhasanxuat = scanner.nextLine();
        System.out.println("nhập giá nhập khẩu");
        int gianhapkhau = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tỉnh thành");
        String tinhthanh = scanner.nextLine();
        System.out.println("nhập thuế");
        int thue = Integer.parseInt(scanner.nextLine());
        SanPhamNhapKhau sanPhamNhapKhau = new SanPhamNhapKhau(id, masanpham, tensanpham, giaban, soluong, nhasanxuat, gianhapkhau, tinhthanh, thue);
        List<SanPhamNhapKhau> sanPhamNhapKhauList = new ArrayList<>();
        sanPhamNhapKhauList.add(sanPhamNhapKhau);
        ReadAndWriteFile.writeProductsListToCSV(sanPhamNhapKhauList, true);

    }

    @Override
    public void delete() {
        display();
        System.out.println("chọn sinh viên cần xóa");
        int index = Integer.parseInt(scanner.nextLine());
        List<SanPhamNhapKhau> sanPhamNhapKhauList = ReadAndWriteFile.readProductsListToCSV();
        sanPhamNhapKhauList.remove(index-1);
        ReadAndWriteFile.writeProductsListToCSV(sanPhamNhapKhauList, false);

    }

    @Override
    public void display() {
        System.out.println("hiên thi ra danh sách");
        List<SanPhamNhapKhau> sanPhamNhapKhauList = ReadAndWriteFile.readProductsListToCSV();
        for (int i=0;i<sanPhamNhapKhauList.size();i++){
            System.out.println((i+1)+"."+sanPhamNhapKhauList.get(i));
        }
    }

    @Override
    public void searchByName() {
        display();
        System.out.println("nhập tên cần tìm kiếm");
        String searchName = scanner.nextLine();
        List<SanPhamNhapKhau> sanPhamNhapKhauList = ReadAndWriteFile.readProductsListToCSV();
        for (SanPhamNhapKhau sanPhamNhapKhau: sanPhamNhapKhauList){
            if (sanPhamNhapKhau.getTensanpham().contains(searchName)){// tìm kiếm gần đúng
                System.out.println(sanPhamNhapKhau.toString());
            }
        }
    }
}
