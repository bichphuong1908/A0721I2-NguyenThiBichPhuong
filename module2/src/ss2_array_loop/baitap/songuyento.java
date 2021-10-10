package ss2_array_loop.baitap;

import java.util.Scanner;

public class SoNguyenTo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 20 ;
        System.out.println(n);
        // có thể nhập bấy kì số nào
        //System.out.println("nhập số lượng số nguyên tố cần in ra");
        //n = input.nextInt();
        int count = 0;
        int num =2;
        String result ="";
        while (count<n){
           boolean flag = true;
           if(num<2){
               flag = false;
           } else {
              for(int i=2; i<num; i++){
                  if(num%i==0){
                      flag = false;
                      break;
                  }
              }
           }
           if(flag){
               result += num + ",";
               count++;
           }
           num++;
        }
        System.out.println(result);

    }
}
