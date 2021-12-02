package de_thi_thu.model;

public abstract class SanPham {
    private int id = 0;
    private int masanpham;
    private String tensanpham;
    private int giaban;
    private int soluong;
    private String nhasanxuat;

    public SanPham() {
    }

    public SanPham(int id, int masanpham, String tensanpham, int giaban, int soluong, String nhasanxuat) {
        this.id = id;
        this.masanpham = masanpham;
        this.tensanpham = tensanpham;
        this.giaban = giaban;
        this.soluong = soluong;
        this.nhasanxuat = nhasanxuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNhasanxuat() {
        return nhasanxuat;
    }

    public void setNhasanxuat(String nhasanxuat) {
        this.nhasanxuat = nhasanxuat;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", masanpham=" + masanpham +
                ", tensanpham='" + tensanpham + '\'' +
                ", giaban=" + giaban +
                ", soluong=" + soluong +
                ", nhasanxuat='" + nhasanxuat + '\'' ;
    }

    public abstract String getInfoToCSV();
}
