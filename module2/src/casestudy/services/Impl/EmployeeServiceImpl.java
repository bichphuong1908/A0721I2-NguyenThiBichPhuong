package casestudy.services.Impl;

import casestudy.models.Employee;
import casestudy.services.Service;
import casestudy.util.ReadAndWrite;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements Service {
    static List<Employee> employeeList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        System.out.println("hiên thi ra danh sách");
        List<Employee> employeeList = ReadAndWrite.readEmployeetListFromCSV();
        for (int i=0;i<employeeList.size();i++){
            System.out.println((i+1)+"."+employeeList.get(i));
        }
    }

    @Override
    public void addNew() {
        System.out.println("nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập name: ");
        String name = scanner.nextLine();
        System.out.println("nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập giới tính: ");
        String sex = scanner.nextLine();
        System.out.println("nhập CMDN/CCCD: ");
        String idCard = scanner.nextLine();
        System.out.println("nhập Email: ");
        String email = scanner.nextLine();
        System.out.println("nhập chức vụ: ");
        String level = scanner.nextLine();
        System.out.println("nhập vị trí: ");
        String position = scanner.nextLine();
        System.out.println("nhập lương: ");
        int salary = scanner.nextInt();
        Employee employee = new Employee(id, name, age, sex, idCard, email, level, position, salary);
        employeeList.add(employee);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        ReadAndWrite.writeEmployeeListToCSV(employeeList,true);
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
