package com.codegym.cms.service;

import java.util.List;

public abstract class IGeneralService<T> {
    abstract List<T> findAll();

    abstract T findById(Long id);

    public abstract void save(T t);

    abstract void remove(Long id);
}
