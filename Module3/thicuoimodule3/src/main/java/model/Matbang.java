package model;

public class Matbang {
    private int id;
    private String dien_tich;
    private String trang_thai;
    private int tang;
    private String loai_van_phong;
    private String gia_cho_thue;
    private String ngay_bat_dau;
    private String ngay_ket_thuc;

    public Matbang() {
    }

    public Matbang(int id, String dien_tich, String trang_thai, int tang, String loai_van_phong, String gia_cho_thue, String ngay_bat_dau, String ngay_ket_thuc) {
        this.id = id;
        this.dien_tich = dien_tich;
        this.trang_thai = trang_thai;
        this.tang = tang;
        this.loai_van_phong = loai_van_phong;
        this.gia_cho_thue = gia_cho_thue;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDien_tich() {
        return dien_tich;
    }

    public void setDien_tich(String dien_tich) {
        this.dien_tich = dien_tich;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public String getLoai_van_phong() {
        return loai_van_phong;
    }

    public void setLoai_van_phong(String loai_van_phong) {
        this.loai_van_phong = loai_van_phong;
    }

    public String getGia_cho_thue() {
        return gia_cho_thue;
    }

    public void setGia_cho_thue(String gia_cho_thue) {
        this.gia_cho_thue = gia_cho_thue;
    }

    public String getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(String ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public String getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(String ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }
}
