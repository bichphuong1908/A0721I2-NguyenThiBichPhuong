package thi_module2.util;

import thi_module2.models.GenuinePhone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    final static String MOBILES_PATH = "src\\thi_module2\\data\\mobiles.csv";

    public static void writeMobilesListToCSV(List<GenuinePhone> genuinePhoneList, boolean append) {
        File file = new File(MOBILES_PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            fileWriter = new FileWriter(file, append); // true ghi tiếp(dùng cho thêm mới => false ghi đè (dùng cho edit và xóa)
            bufferedWriter = new BufferedWriter(fileWriter);
            for (GenuinePhone genuinePhone: genuinePhoneList){
                bufferedWriter.write(genuinePhone.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch(IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }
    public static List<GenuinePhone> readMobilesListToCSV(){
        List<GenuinePhone> genuinePhoneList = new ArrayList<>();
        File file = new File(MOBILES_PATH);
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
                GenuinePhone genuinePhone = new GenuinePhone(Integer.parseInt(array[0]), array[1],
                        Integer.parseInt(array[2]), Integer.parseInt(array[3]), array[4],
                        Integer.parseInt(array[5]), array[6]);
                genuinePhoneList.add(genuinePhone);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return genuinePhoneList;
    }
}
