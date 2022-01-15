package repository.impl;

import model.Student;
import repository.IStudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private BaseRepository baseRepository = new BaseRepository();


    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            //Statement
//            Statement statement = this.baseRepository.getConnection().createStatement();
////            statement.executeQuery("select * from student where name ="+name);

            //PreparedStatement
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("select * from student");
            //executeQuery : select
            //executeUpdate: insert, update, delete.
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setGrade(resultSet.getDouble("grade"));
                student.setGender(resultSet.getInt("gender"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student findById(String id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("select * from student where id = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = null;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setGrade(resultSet.getDouble("grade"));
                student.setGender(resultSet.getInt("gender"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                break;
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(String id, String name, String grade) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("update student set name = ?, grade = ? where id = ?");
            preparedStatement.setString(3, id);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, grade);
            int num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createStudent(Student student) {
//        try {
//            PreparedStatement preparedStatement = this.baseRepository.getConnection()
//                    .prepareStatement("insert into student(name,date_of_birth,grade,gender) value (?,?,?,?)");
//            preparedStatement.setDouble(3, student.getGrade());
//            preparedStatement.setString(1, student.getName());
//            preparedStatement.setString(2, student.getDateOfBirth());
//            preparedStatement.setInt(4,student.getGender());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Connection connection = this.baseRepository.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.
                    prepareStatement("insert into class(id, name_class) value (?,?)");
            preparedStatement.setInt(1,6);
            preparedStatement.setString(2,"A0122I1");
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = connection.
                    prepareStatement("insert into student(id,name,date_of_birth,gender,grade) " +
                            "value(?,?,?,?,?)");
            
            preparedStatement1.setInt(1,student.getId());
            preparedStatement1.setString(2,student.getName());
            preparedStatement1.setString(3,student.getDateOfBirth());
            preparedStatement1.setInt(4,student.getGender());
            preparedStatement1.setDouble(5,student.getGrade());
            preparedStatement1.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Student> findAllByName(String nameStudent) {
        List<Student> studentList = new ArrayList<>();
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection()
                    .prepareCall("call find_student_by_name(?)");
            callableStatement.setString(1,"%"+nameStudent+"%");
            ResultSet resultSet = callableStatement.executeQuery();
            Student student;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setGrade(resultSet.getDouble("grade"));
                student.setGender(resultSet.getInt("gender"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
