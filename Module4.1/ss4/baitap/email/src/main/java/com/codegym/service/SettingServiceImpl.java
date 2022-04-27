package com.codegym.service;

import com.codegym.model.Setting;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SettingServiceImpl implements SettingService{

    private static Map<Integer, Setting> settingMap;
    static {
        settingMap = new HashMap<>();
        settingMap.put(1,new Setting("English", 20, true, "Thor"));
    }

    @Override
    public void update(Setting setting) {
        if (settingMap.containsKey(setting.getId())) {
            settingMap.put(setting.getId(), setting);
        }
    }

    @Override
    public Setting findById(int id) {
        return settingMap.get(id);
    }
}
