package ss2_array_loop;

public class Mang {
    public static void main(String[] args) {
        // tạo mảng 2 chiều
        int[][] numbers1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] numbers2 = new int[3][4]; // tạo mảng 2 chiều có 3 hàng và 4 cột
        // các pt đang có giá trị mặc định
        for(int i=0; i<3; i++){
            for(int k=0; k<4; k++){
                System.out.println(numbers2[i][k]);
            }
        }
    }
}
