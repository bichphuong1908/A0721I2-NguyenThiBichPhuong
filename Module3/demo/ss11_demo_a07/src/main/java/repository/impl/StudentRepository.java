package repository.impl;

import model.Student;
import repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();

     static {
        studentList.add(new Student(1,"HaiTT","01/01/1999",1,8.0));
        studentList.add(new Student(2,"TrungDP","01/01/1999",0,6.0));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(String id) {
        Integer temp = Integer.parseInt(id);
        for(Student student: studentList) {
            if(student.getId().equals(temp)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void save(String id, String name, String grade) {
        Integer temp = Integer.parseInt(id);
        for(Student student: studentList) {
            if(student.getId().equals(temp)) {
                student.setName(name);
                student.setGrade(Double.valueOf(grade));
            }
        }
    }

    @Override
    public void createStudent(Student student) {
        studentList.add(student);
    }
}
