package com.codegym.thimodule5.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long ma_sv;
    private String name;
    private String ten_nhom;
    private String title;
    private String giao_vien;
    private String email;
    private long phoneNumber;

    public Product() {
    }

    public Product(long id, long ma_sv, String name, String ten_nhom, String title, String giao_vien, String email, long phoneNumber) {
        this.id = id;
        this.ma_sv = ma_sv;
        this.name = name;
        this.ten_nhom = ten_nhom;
        this.title = title;
        this.giao_vien = giao_vien;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMa_sv() {
        return ma_sv;
    }

    public void setMa_sv(long ma_sv) {
        this.ma_sv = ma_sv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTen_nhom() {
        return ten_nhom;
    }

    public void setTen_nhom(String ten_nhom) {
        this.ten_nhom = ten_nhom;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGiao_vien() {
        return giao_vien;
    }

    public void setGiao_vien(String giao_vien) {
        this.giao_vien = giao_vien;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
