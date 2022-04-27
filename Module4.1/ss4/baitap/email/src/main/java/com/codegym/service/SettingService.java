package com.codegym.service;

import com.codegym.model.Setting;

public interface SettingService {
    void update(Setting setting);
    Setting findById(int id);
}
