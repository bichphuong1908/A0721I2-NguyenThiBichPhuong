package service;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    Student findById(String id);

    void save(String id, String name, String grade);

    boolean createStudent(Student student);

    List<Student> findAllByName(String nameStudent);
}
