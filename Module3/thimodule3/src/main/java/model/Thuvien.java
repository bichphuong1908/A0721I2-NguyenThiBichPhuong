package model;

public class Thuvien {
    private int id;
    private String ten_sach;
    private String tac_gia;
    private int so_luong;
    private String mo_ta;

    public Thuvien(int id, String ten_sach, String tac_gia, int so_luong, String mo_ta) {
        this.id = id;
        this.ten_sach = ten_sach;
        this.tac_gia = tac_gia;
        this.so_luong = so_luong;
        this.mo_ta = mo_ta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_sach() {
        return ten_sach;
    }

    public void setTen_sach(String ten_sach) {
        this.ten_sach = ten_sach;
    }

    public String getTac_gia() {
        return tac_gia;
    }

    public void setTac_gia(String tac_gia) {
        this.tac_gia = tac_gia;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }
}
