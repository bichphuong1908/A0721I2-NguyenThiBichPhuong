package ss14_sorting_algorithms.baitap.sap_xep_chen;

public class InsertionSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    public static void insertionSort(int[] list) {

        for (int k = 1; k < list.length; k++) {
            /* Array may be sorted and next pass not needed */
            int key = list[k];
            int j = k - 1;
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        insertionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
