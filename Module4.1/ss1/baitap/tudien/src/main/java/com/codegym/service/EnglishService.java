package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public interface EnglishService {
    String findByEnglish(String wordEnglish);
}
