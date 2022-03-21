package com.codegym.cms.model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private MysqlxDatatypes.Scalar.String name;
    private int price;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MysqlxDatatypes.Scalar.String getName() {
        return name;
    }

    public void setName(MysqlxDatatypes.Scalar.String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
