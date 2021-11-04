package ss10_danh_sach.baitap.linkedlist;

public class Node {
    public Node next;
    private Object data;


        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
}
