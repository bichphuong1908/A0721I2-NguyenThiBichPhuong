package com.codegym.webfrurama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double cost;

    @OneToMany(mappedBy = "rentType")
    List<Service> services;

    public RentType() {
    }

    public RentType(long id, String name, double cost, List<Service> services) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.services = services;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
