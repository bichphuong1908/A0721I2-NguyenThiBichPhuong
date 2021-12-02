package de_thi_thu.model;

public class SanPhamXuatKhau extends SanPham{
    private int giaxuatkhau;
    private String quocgia;

    public SanPhamXuatKhau() {
    }

    public SanPhamXuatKhau(int id, char masanpham, String tensanpham, int giaban, int soluong, String nhasanxuat, int giaxuatkhau, String quocgia) {
        super(id, masanpham, tensanpham, giaban, soluong, nhasanxuat);
        this.giaxuatkhau = giaxuatkhau;
        this.quocgia = quocgia;
    }

    public double getGiaxuatkhau() {
        return giaxuatkhau;
    }

    public void setGiaxuatkhau(int giaxuatkhau) {
        this.giaxuatkhau = giaxuatkhau;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }

    @Override
    public String toString() {
        return "id" + getId() + '\'' +
                ", masanpham=" + getMasanpham() + '\'' +
                ", tensanpham=" + getTensanpham() + '\'' +
                ", giaban=" + getGiaban() + '\'' +
                ", soluong=" + getSoluong() + '\'' +
                ", nhasanxuat=" + getNhasanxuat() + '\''+
                ", giaxuatkhau=" + giaxuatkhau +
                ", quocgia='" + quocgia + '\'' ;
    }

    @Override
    public String getInfoToCSV() {
        return this.getId()+","+this.getMasanpham()+","+this.getTensanpham()+","+this.getGiaban()+","+this.getSoluong()+","+this.getNhasanxuat()+","+this.giaxuatkhau+","+this.quocgia;
    }
}
