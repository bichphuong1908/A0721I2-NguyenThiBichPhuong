package com.codegym.java_web.service;

import com.codegym.java_web.model.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();
    void saveServiceType (ServiceType serviceType);
    void deleteServiceType (Long id);
    ServiceType findServiceTypeById(Long id);
}

