package ss10_danh_sach.baitap.linkedlist;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
    }

    public MyLinkedList(E element) {
        head = new Node(element);
    }
    public void add(int index, E element) {
        Node temp = head;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        Node after = temp.next;
        temp.next = new Node(element);
        temp.next.next = after;
        numNodes++;
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }
}
