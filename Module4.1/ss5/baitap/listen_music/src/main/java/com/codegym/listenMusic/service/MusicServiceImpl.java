package com.codegym.listenMusic.service;

import com.codegym.listenMusic.model.Music;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService{
    @Override
    public List<Music> findAll() {
        return null;
    }

    @Override
    public Music findById(Long id) {
        return null;
    }

    @Override
    public void save(Music music) {

    }

    @Override
    public void remove(Long id) {

    }
}
