package casestudy.controllers;

import casestudy.services.Impl.EmployeeServiceImpl;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu(){
        boolean check = true;
        while (check){
            System.out.println("1. Add New Services");
            System.out.println("2. Show Services");
            System.out.println("3. Add New Customer");
            System.out.println("4. Show Information of Customer");
            System.out.println("5. Add New Booking");
            System.out.println("6. Show Information of Employee");
            System.out.println("7. Exit");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()){
                case 1:{
                    addNewServies();
                }
                case 2: {
                    showServices();
                }
                case 6:{
                    displayEmployeeMenu();
                }
            }
        }
    }
    public static void addNewServies()  {
        boolean check = true;
        while (check) {
            System.out.println("1. Add new Villa");
            System.out.println("2. Add new House");
            System.out.println("3. Add new Room");
            System.out.println("4. Back to menu");
            System.out.println("5. Eixt");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()) {
                case 1:

            }
        }
    }
    public static void showServices()  {
        boolean check = true;
        while (check) {
            System.out.println("1. Show all Villa");
            System.out.println("2. Show all House");
            System.out.println("3. Show all Room");
            System.out.println("4. Show All Name Villa Not Duplicate");
            System.out.println("5. Show All Name House Not Duplicate");
            System.out.println("6. Show All Name Room Not Duplicate");
            System.out.println("7. Back to menu");
            System.out.println("8. Eixt");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()) {
                case 1:

            }
        }
    }
    public static void displayEmployeeMenu()  {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employees");
            System.out.println("3. Eixt list employees");
            System.out.println("4. Back to menu");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()) {
                case 1:{
                    employeeService.display();
                    break;
                }
                case 2:{
                   employeeService.addNew();
                   break;
                }
            }
        }
    }
}
