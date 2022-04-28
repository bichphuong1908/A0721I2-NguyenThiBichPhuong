package com.codegym.service;

import com.codegym.model.Declaration;

import java.util.List;

public interface DeclarationService {
    List<Declaration>findAll();
    void save(Declaration declaration);
}
