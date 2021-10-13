package ss5_static_ac.baitap.xaydunglop;

public class TestStudent {
    public static void main(String[] args) {
        Student st = new Student();
        st.setName("John");
        st.setClasses("C02");
        System.out.println("name " + st.getName());
        System.out.println("class " + st.getClasses());
    }
}
