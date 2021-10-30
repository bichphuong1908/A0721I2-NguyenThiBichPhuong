package ss11_generic_stack_queue.thuchanh.lop_linkedlist;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack(){
        stack = new LinkedList<>();
    }

    //Cài đặt phương thức push() thêm vào cuối stack
    public void push(T element){

        stack.addFirst(element);
    }

    //Cài đặt phương thức size()
    public int size() {
        return stack.size();
    }

    //Cài đặt phương thức isEmpty()
    public boolean isEmpty(){
        if(stack.size() == 0){
            return true;
        }
        return false;
    }

    //Cài đặt phương thức pop(), Các phần tử pop từ ngăn xếp
    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }

}
