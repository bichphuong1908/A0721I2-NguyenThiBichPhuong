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
    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
            size = size - 1;
            return true;
        }
        return false;
    }
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }
    public boolean contains(E  element) {
        for (E x : elements) {
            if (element.equals(x)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public E get(int i) {
        if (i >= 0 && i <= size) {
            return elements[i];
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size " + (size - 1));
    }
}
