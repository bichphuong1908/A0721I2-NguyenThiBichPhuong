package com.codegym.case_study_java_web.service.impl;
import com.codegym.case_study_java_web.Repository.ServiceTypeRepository;
import com.codegym.case_study_java_web.model.ServiceType;
import com.codegym.case_study_java_web.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public void saveServiceType(ServiceType serviceType) {

    }

    @Override
    public void deleteServiceType(Long id) {

    }

    @Override
    public ServiceType findServiceTypeById(Long id) {
        return null;
    }
}