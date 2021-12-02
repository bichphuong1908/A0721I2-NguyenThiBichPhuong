package de_thi_thu.util;


import de_thi_thu.model.SanPhamNhapKhau;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    final static String PRODUCTS_PATH = "src\\de_thi_thu\\data\\products";

    public static void writeProductsListToCSV(List<SanPhamNhapKhau> sanPhamNhapKhauList, boolean append) {
        File file = new File(PRODUCTS_PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append); // true ghi tiếp(dùng cho thêm mới => false ghi đè (dùng cho edit và xóa)
            bufferedWriter = new BufferedWriter(fileWriter);
            for (SanPhamNhapKhau sanPhamNhapKhau: sanPhamNhapKhauList){
                bufferedWriter.write(sanPhamNhapKhau.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch(IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }
    public static List<SanPhamNhapKhau> readProductsListToCSV(){
        List<SanPhamNhapKhau> sanPhamNhapKhauList = new ArrayList<>();
        File file = new File(PRODUCTS_PATH);
        FileReader fileReader =null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
//          bufferedReader.readLine();=> đọc ra một dòng trong file => trả về text
            String line =null;
            String[] array =null;
            while ((line=bufferedReader.readLine())!=null){
                array= line.split(",");  //
                SanPhamNhapKhau sanPhamNhapKhau = new SanPhamNhapKhau(Integer.parseInt(array[0]),
                        Integer.parseInt(array[1]), array[2], Integer.parseInt(array[3]),
                        Integer.parseInt(array[4]), array[5], Integer.parseInt(array[6]), array[7], Integer.parseInt(array[8]));
                sanPhamNhapKhauList.add(sanPhamNhapKhau);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return sanPhamNhapKhauList;
    }

}


