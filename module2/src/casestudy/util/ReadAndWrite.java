package casestudy.util;

import casestudy.models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    final static String Employee_PATH ="src\\casestudy\\data\\employee";
    public static void writeEmployeeListToCSV(List<Employee> employeeList, boolean append){
        File file = new File(Employee_PATH);
        FileWriter fileWriter =null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,append); // true ghi tiếp(dùng cho thêm mới => false ghi đè (dùng cho edit và xóa)
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee: employeeList){
                bufferedWriter.write(employee.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }

    }

    public static List<Employee> readEmployeetListFromCSV() {
        List<Employee> employeeList = new ArrayList<>();
        File file = new File(Employee_PATH);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
//          bufferedReader.readLine();=> đọc ra một dòng trong file => trả về text
            String line = null;
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");  //
                Employee employee = new Employee(Integer.parseInt(array[0]), array[1],
                        Integer.parseInt(array[2]), array[3], array[4], array[5], array[6], array[7], Integer.parseInt(array[8]));
                employeeList.add(employee);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return employeeList;
    }
}
