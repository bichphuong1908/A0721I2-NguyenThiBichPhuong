package ss7_abstractclass_interface.baitap.interface_colorable;

public class Square extends Shape implements Colorable{
    private double side =0;

    public Square() {
    }

    public Square(double side) {
        
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        setShape(color,filled);
        this.side = side;
    }

    private void setShape(String color, boolean filled) {
    }

    public double getSide() {
        
        return side;
    }

    public void setSide(double side) {
        
        this.side = side;
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void howToColor() {
        System.out.println("hình vuông: tô 4 cạnh");
    }
}
