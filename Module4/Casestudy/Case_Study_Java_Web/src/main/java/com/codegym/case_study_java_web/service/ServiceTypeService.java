package com.codegym.case_study_java_web.service;
import com.codegym.case_study_java_web.model.Service;
import com.codegym.case_study_java_web.model.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();
    void saveServiceType (ServiceType serviceType);
    void deleteServiceType (Long id);
    ServiceType findServiceTypeById(Long id);
}

