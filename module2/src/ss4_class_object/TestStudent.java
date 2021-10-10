package ss4_class_object;

public class TestStudent {
    public static void main(String[] args) {
        // khởi tạo dối tượng trong tham số
        Student student = new Student();
        System.out.println("id: " +student.id+ " tên: " +student.name+
                " tuổi:" +student.age+ " address: " +student.address);
        // gọi phương thức của dổi tượng
        student.howToGo();
        Student student1 = new Student();
        // khởi tạo đối tượng 2 tham sô
        Student student2 = new Student(1, "chanh");
        System.out.println("id: "+student2.id+" tên: "+student2.name+
                " tuổi "+student2.age+" address "+student2.address);
        // khởi tạo đối tượng 3 tham sô
        Student student3 = new Student(1, "chanh", 45);
        System.out.println("id: "+student3.id+" tên: "+student3.name+
                " tuổi "+student3.age+" address "+student3.address);
    }
}
