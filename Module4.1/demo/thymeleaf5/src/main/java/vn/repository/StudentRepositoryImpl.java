package vn.repository;

import org.springframework.transaction.annotation.Transactional;
import vn.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void delete(String id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("Select s from Student s").getResultList();
    }

    @Override
    public Student findById(String id) {
        return entityManager.find(Student.class, id);
    }
}
