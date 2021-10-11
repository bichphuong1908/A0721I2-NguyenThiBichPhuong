package ss4_class_object.baitap.lop_fan;

public class Text {
    public static void main(String[] args) {
        Fan fan1 =new Fan(3,true,10,"green");
        Fan fan2 =new Fan(2,false,5,"black");
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
