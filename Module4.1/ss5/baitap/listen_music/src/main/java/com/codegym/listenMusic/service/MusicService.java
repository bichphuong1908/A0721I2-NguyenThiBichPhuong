package com.codegym.listenMusic.service;

import com.codegym.listenMusic.model.Music;

import java.util.List;

public interface MusicService {
    List<Music> findAll();

    Music findById(Long id);

    void save(Music music);

    void remove(Long id);
}
