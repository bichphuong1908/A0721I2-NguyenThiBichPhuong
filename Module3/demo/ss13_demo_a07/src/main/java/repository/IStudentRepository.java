package repository;

import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    Student findById(String id);

    void save(String id, String name, String grade);

    void createStudent(Student student);

    List<Student> findAllByName(String nameStudent);
}
