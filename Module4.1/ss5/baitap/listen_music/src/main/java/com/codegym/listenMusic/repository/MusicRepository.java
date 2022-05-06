package com.codegym.listenMusic.repository;


import java.util.List;

public interface MusicRepository <Music, Long> {
    void save(Music music);
    void remove(String id);
    List<Music> findAll();
    Music findById(String id);
}
