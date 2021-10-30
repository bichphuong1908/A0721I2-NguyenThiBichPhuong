package ss10_danh_sach.baitap.arraylist;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;

    public MyList() {

        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }
    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        // Thêm phần tử element vào cuối danh sách (mảng)
        elements[size] = element;
        // Tăng độ dài của danh sách lên 1;
        size++;
    }
    public void remmove(E element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        // Thêm phần tử element vào cuối danh sách (mảng)
        elements[size] = element;
        // Tăng độ dài của danh sách lên 1;
        size--;
    }

}
