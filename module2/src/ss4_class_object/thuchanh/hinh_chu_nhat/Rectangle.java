package ss4_class_object.thuchanh.hinh_chu_nhat;

public class Rectangle {
    // khai báo thuộc tính
    double width, height;
    public  Rectangle(){
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }
    public String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }
}
