package ss6_ke_thua.baitap.point2d_point3d;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
        float[] test = new float[2];
        test[0] = this.x;
        test[1] = this.y;
        return test;
    }

    @Override
    public String toString() {
        return "Point2D " +
               /* " x= " + x +
                ", y= " + y +*/
                "("+this.x+","+this.y+")";
    }
}
