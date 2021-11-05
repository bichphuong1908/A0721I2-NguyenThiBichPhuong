package ss14_sorting_algorithms.baitap.insertion_sort;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
            System.out.println("\nBegin sort processing...");
            insertionSort(list);
        }
    }
        public static void insertionSort(int[] list) {

            int k;
            for (k = 1; k < list.length; k++) {
                /* Array may be sorted and next pass not needed */
                int key = list[k];
                int j = k - 1;
                while (j >= 0 && list[j] > key) {
                    list[j + 1] = list[j];
                    j = j - 1;
                }
                list[j + 1] = key;
                for (int i = 0; i < list.length - k; i++) {
                    if (list[i] > list[i + 1]) {
                        /* Swap list[i] with list[i + 1] */
                        System.out.println("Swap " + list[i] + " with " + list[i + 1]);
                        int temp = list[i];
                        list[i] = list[i + 1];
                        list[i + 1] = temp;
                        
                    }
                }
            }


            /* Show the list after sort */
            System.out.print("List after the  " + k + "' sort: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }
}
