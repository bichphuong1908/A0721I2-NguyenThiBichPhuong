package com.codegym.listenMusic.repository;

import com.codegym.listenMusic.model.Music;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.annotation.Annotation;
import java.util.List;

@Transactional
public class MusicRepositoryImpl implements MusicRepository{
    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Music> findAll() {
        TypedQuery<Music> query = em.createQuery("select m from Music m", Music.class);
        return query.getResultList();
    }

    @Override
    public Music findById(String id) {
        TypedQuery<Music> query = em.createQuery("select m from Music m", Music.class);
        return (Music) query.getResultList();
    }


    @Override
    public void save(Music model) {
        if(model.getClass() != null){
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void remove(String id) {
        Music music = findById(id);
        if(music != null){
            em.remove(music);
        }
    }
}
