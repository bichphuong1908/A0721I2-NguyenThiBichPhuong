package de_thi_thu.model;

public class SanPhamNhapKhau extends SanPham{
    private int gianhapkhau;
    private String tinhthanh;
    private int thue;

    public SanPhamNhapKhau() {
    }


    public SanPhamNhapKhau(int id, int masanpham, String tensanpham, int giaban, int soluong, String nhasanxuat, int gianhapkhau, String tinhthanh, int thue) {
        super(id, masanpham, tensanpham, giaban, soluong, nhasanxuat);
        this.gianhapkhau = gianhapkhau;
        this.tinhthanh = tinhthanh;
        this.thue = thue;
    }

    public double getGianhapkhau() {
        return gianhapkhau;
    }

    public void setGianhapkhau(int gianhapkhau) {
        this.gianhapkhau = gianhapkhau;
    }

    public String getTinhthanh() {
        return tinhthanh;
    }

    public void setTinhthanh(String tinhthanh) {
        this.tinhthanh = tinhthanh;
    }

    public int getThue() {
        return thue;
    }

    public void setThue(int thue) {
        this.thue = thue;
    }

    @Override
    public String toString() {
        return "id" + getId() + '\'' +
                ", masanpham=" + getMasanpham() + '\'' +
                ", tensanpham=" + getTensanpham() + '\'' +
                ", giaban=" + getGiaban() + '\'' +
                ", soluong=" + getSoluong() + '\'' +
                ", nhasanxuat=" + getNhasanxuat() + '\''+
                ", gianhapkhau=" + gianhapkhau +
                ", tinhthanh='" + tinhthanh + '\'' +
                ", thue=" + thue + '\'';
    }

    @Override
    public String getInfoToCSV() {
        return this.getId()+","+this.getMasanpham()+","+this.getTensanpham()+","+this.getGiaban()+","+this.getSoluong()+","+this.getNhasanxuat()+","+this.gianhapkhau+","+this.tinhthanh+","+this.thue;
    }
}
