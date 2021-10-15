package ss6_ke_thua.baitap.point_moveablepoint;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint() {
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        float[] test = new float[2];
        test[0] = this.xSpeed;
        test[1] = this.ySpeed;
        return test;
    }
    public Point move(){
        this.setX(this.getX() + this.xSpeed);
        this.setY(this.getY() + this.ySpeed);
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + "," +
                " speed = (" + this.xSpeed + "," + this.ySpeed + ")";
        /*return "MoveablePoint" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';*/
    }
}
