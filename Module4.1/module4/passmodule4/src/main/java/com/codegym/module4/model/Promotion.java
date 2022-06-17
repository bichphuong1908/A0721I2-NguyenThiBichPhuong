package com.codegym.module4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "không được để trống")
    @Size(min = 5, max = 50, message = "ít nhất 5 kí tự và không quá 50 kí tự")
    private String title;

    @NotEmpty(message = "không để trống")
    private String startTime;

    @NotEmpty(message = "không để trống")
    private String endTime;

    @NotEmpty(message = "không được để trống")
    @Min( value = 10000, message = "không được thấp hơn 10000")
    private String discount;

    @NotEmpty(message = "không được để trống")
    @Size(min = 5, max = 100, message = "ít nhất 5 kí tự và không quá 100 kí tự")
    private String detail;

    public Promotion() {
    }

    public Promotion(long id, String title, String startTime, String endTime, String discount, String detail) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.discount = discount;
        this.detail = detail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
