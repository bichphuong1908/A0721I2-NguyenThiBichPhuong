package com.codegym.service;

import com.codegym.model.Setting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SettingServiceImpl implements SettingService{

    private static List<Setting> settings;

    static {
        settings = new ArrayList<>();
        settings.add(new Setting(0,"English", 20, true, "Thor"));
    }
    @Override
    public List<Setting> getAllUser() {
        return settings;
    }

    @Override
    public void update(Setting setting) {
        settings.add(setting);
    }

//    @Override
//    public Setting findById(int id) {
//        return settings.get(id);
//    }
}
