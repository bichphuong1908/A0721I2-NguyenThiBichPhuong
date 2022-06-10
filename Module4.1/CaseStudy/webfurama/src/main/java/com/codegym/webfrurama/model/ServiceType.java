package com.codegym.webfrurama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "serviceType")
    List<Service> Services;

    public ServiceType() {
    }

    public ServiceType(long id, String name, List<Service> services) {
        this.id = id;
        this.name = name;
        Services = services;
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

    public List<Service> getServices() {
        return Services;
    }

    public void setServices(List<Service> services) {
        Services = services;
    }
}
