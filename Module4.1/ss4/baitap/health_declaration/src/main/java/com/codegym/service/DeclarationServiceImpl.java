package com.codegym.service;

import com.codegym.model.Declaration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeclarationServiceImpl implements DeclarationService {

    private static List<Declaration> declarations;

    static {
        declarations = new ArrayList<>();
        declarations.add(new Declaration(1,"Nguyen Van A", "1990-08-19", "Male", "Viet Nam", "123456789"));
    }

    @Override
    public List<Declaration> findAll() {
        return declarations;
    }

    @Override
    public void save(Declaration declaration) {
        declarations.add(declaration);
    }
}
