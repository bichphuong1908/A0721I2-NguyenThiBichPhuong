package ss15_exception_debug.baitap.su_dung_lop_IllegalTriangleException;

public class TriangleEdgesCheck {
    // Ham kiem tra tam giac hop le
    public void checkTriangleEdges(double a, double b, double c) throws TriangleEdgesException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleEdgesException("Loi: Tam giac khong hop le!");
        } else {
            System.out.println("Tam giac hop le!");
        }
    }
}
