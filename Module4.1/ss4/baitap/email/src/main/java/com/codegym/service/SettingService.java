package com.codegym.service;

import com.codegym.model.Setting;

import java.util.List;

public interface SettingService {
    List<Setting> getAllUser();
    void update(Setting setting);
//    Setting findById(int id);
}
