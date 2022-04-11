package com.codegym.case_study_java_web.service.impl;

import com.codegym.case_study_java_web.Repository.ServiceRepository;
import com.codegym.case_study_java_web.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public Page<com.codegym.case_study_java_web.model.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public void saveService(com.codegym.case_study_java_web.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteService(Long id) {
    }

    @Override
    public com.codegym.case_study_java_web.model.Service findServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Page<com.codegym.case_study_java_web.model.Service> searchByName(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<com.codegym.case_study_java_web.model.Service> findAllByNameContaining(String name, Pageable pageable) {
        return serviceRepository.findAllByNameContaining(name, pageable);
    }




}
