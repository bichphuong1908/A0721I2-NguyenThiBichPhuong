package ss3_method;

public class DemoMethod {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        // khởi tạo đối tượng DemoMethod
        DemoMethod demoMethod = new DemoMethod();
        System.out.println(demoMethod.sumElementArray(array));
    }
    // DN metheod không có giá trị trả về và không có tham số
    public static void displayMessage() {
        System.out.println("hello word");
    }
    // DN metheod không có giá trị trả về và có 1 tham số kiểu String
    public static void displayName(String name){
        System.out.println(name);
    }
    // DN metheod có giá trị trả về là int và có 2 tham số truyền vào
    public static int add(int a, int b) {
        int c = a+b;
        return c;
    }
    public int sumElementArray(int[] arr) {
        int sum =0;
        for (int i=0; i<arr.length; i++){
            sum +=arr[i];
        }
        return sum;
    }
}
