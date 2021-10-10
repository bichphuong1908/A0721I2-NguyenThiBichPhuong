package ss5_static_ac.demo1;

import java.util.Arrays;

public class Text {
    public static void main(String[] args) {
        Student student1 = new Student(1,"chanh1","DN");
        System.out.println("đây là hàm main");
        Student student2 = new Student(1,"chanh2","DN");
        Student[] studentList = new Student[2];
        studentList[0]=student1;
        studentList[1]=student2;
        // truy cập vào thuộc tính thông qua class
//        Student.school="CodeGym";
        // truy cập vào thuộc tính thông qua object
//        student1.school="CodeGym";
        // truy cập vào pt static thông qua class
//        Student.registerSubject();
        // truy cập pt static thông qua đối tượng
//        student1.registerSubject();
//        for (int i=0; i<studentList.length; i++){
//            studentList[i].school="CodeGym";
//        }

        // không thể truy cập vào thuộc tính private ở bên ngoài class
        System.out.println(student1.getId());
        student1.setId(10);
        System.out.println(student1.getId());
        System.out.println(student1.address);
//        for (Student s: studentList) {
//            System.out.println(s.name+ "-"+ s.school);
//        }

    }
}
