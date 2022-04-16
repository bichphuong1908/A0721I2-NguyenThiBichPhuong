package com.codegym.baithi.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tieuDe;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;

//    @NotEmpty(message = "không đúng")
//    @Size(min = 10000)
    private String mucGiamGia;
    private String chiTiet;


    public KhuyenMai() {
    }

    public KhuyenMai(long id, String tieuDe, String thoiGianBatDau, String thoiGianKetThuc, String mucGiamGia, String chiTiet) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.mucGiamGia = mucGiamGia;
        this.chiTiet = chiTiet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(String mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }
}
