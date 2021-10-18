package ss6_ke_thua.baitap.point2d_point3d;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z){
        setXY(x, y);
        this.z=z;
    }
    public float[] getXYZ(){
        float[] test=new float[3];
        test[0]=this.getX();
        test[1]=this.getY();
        test[2]=this.getZ();
        return test;
    }

    @Override
    public String toString() {
        return "Point3D " +
                /*"z= " + z +
                ", " + super.toString()*/
         "("+getX()+","+getY()+","+getZ()+")";
    }
}
