package ss4_class_object;

public class Student {
        int id; // biến instance biến thuộc về class(thuộc tính)
        String name;
        int age;
        String address;
        // condtructor không tham số
        public Student(){
        }
        // condtructor 2 tham số
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        // condtructor 3 tham số
        public Student(int id, String name, int age) {
            // condtructor được gọi thông qua từ khóa this
            this(id,name);
            this.age = age;
        }
        // condtructor 4 tham số
        public Student(int id, String name, int age, String address) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.address = address;
        }
        // định nghĩa 1 phương thức
    public static void howToGo(){
        System.out.println("Di chuyển bằng xe máy");
    }
}
