package thi_module2.services;

import thi_module2.models.GenuinePhone;
import thi_module2.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenuinePhoneService implements Service{
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("nhâp id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhâp tên điện thoại");
        String name = scanner.nextLine();
        System.out.println("nhập giá bán");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập số lượng");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("nhà sản xuất");
        String producer = scanner.nextLine();
        System.out.println("thời gian bảo hành");
        int time = Integer.parseInt(scanner.nextLine());
        System.out.println("pham vi bảo hành");
        String insurance = scanner.nextLine();
        GenuinePhone genuinePhone = new GenuinePhone(id, name, price, quantity, producer, time, insurance);
        List<GenuinePhone> genuinePhoneList = new ArrayList<>();
        genuinePhoneList.add(genuinePhone);
        ReadAndWriteFile.writeMobilesListToCSV(genuinePhoneList, true);
    }

    @Override
    public void delete() {
        display();
        System.out.println("chọn cần xóa");
        int index = Integer.parseInt(scanner.nextLine());
        List<GenuinePhone> genuinePhoneList = ReadAndWriteFile.readMobilesListToCSV();
        genuinePhoneList.remove(index-1);
        ReadAndWriteFile.writeMobilesListToCSV(genuinePhoneList, false);

    }

    @Override
    public void display() {
        System.out.println("hiên thi ra danh sách");
        List<GenuinePhone> genuinePhoneList = ReadAndWriteFile.readMobilesListToCSV();
        for (int i=0;i<genuinePhoneList.size();i++){
            System.out.println((i+1)+"."+genuinePhoneList.get(i));
        }
    }

    @Override
    public void searchByName() {
        /*display();
        System.out.println("nhập tên cần tìm kiếm");
        String searchName = scanner.nextLine();
        List<GenuinePhone> genuinePhoneList = ReadAndWriteFile.readMobilesListToCSV();
        for (GenuinePhone genuinePhone: genuinePhoneList){
            if (GenuinePhone.getName().contains(searchName)){// tìm kiếm gần đúng
                System.out.println(genuinePhone.toString());
            }
        }*/
    }
}
