package com.codegym.baithi.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String tieuDe;

    private Date thoiGianBatDau;

    private Date thoiGianKetThuc;

    @NotNull(message = "không đúng")
    @Min(value = 10000, message = "thap quá")
    private Long mucGiamGia;

    private String chiTiet;


    public KhuyenMai() {
    }

    public KhuyenMai(long id, String tieuDe, Date thoiGianBatDau, Date thoiGianKetThuc, Long mucGiamGia, String chiTiet) {
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

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public Long getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(Long mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }
}
