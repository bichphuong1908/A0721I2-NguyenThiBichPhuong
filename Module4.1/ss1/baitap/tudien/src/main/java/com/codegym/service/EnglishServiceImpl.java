package com.codegym.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EnglishServiceImpl implements EnglishService{

    private static Map<String, String> Map = new HashMap<>();
    static {
        Map.put("book", "sach");
        Map.put("grandma", "ba");
        Map.put("boss", "ong chu");
        Map.put("flower", "hoa");
    }

    @Override
    public String findByEnglish(String wordEnglish) {
        String wordVN = Map.get(wordEnglish);
        if (wordVN == null) {
            return null;
        } else {
            return wordVN;
        }
    }
}
