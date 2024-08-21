package lk.ijse.stumanagement.dao;

import lk.ijse.stumanagement.entity.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class StudentDAOImpl implements StudentDAO {

    static String SAVE_STUDENT = "INSERT INTO Student (id,name,city,email,level) VALUES (?,?,?,?,?)";
    static String UPDATE_STUDENT = "UPDATE Student SET name=?, city=?, email=?, level=? WHERE id=?";
    static String GET_STUDENT = "SELECT * FROM Student";
    static String DELETE_STUDENT = "DELETE FROM Student WHERE id=?";


    @Override
    public List<Student> get(Connection connection) {

        List<Student> studentList = new ArrayList<>();

        try{
            var ps = connection.prepareStatement(GET_STUDENT);

            var resultSet = ps.executeQuery();

            while(resultSet.next()){

                var student = new Student();

                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setCity(resultSet.getString("city"));
                student.setLevel(resultSet.getString("level"));

                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }


    @Override
    public boolean save(Student student, Connection connection) {

        try {

            var ps = connection.prepareStatement(SAVE_STUDENT);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(4, student.getEmail());
            ps.setString(3, student.getCity());
            ps.setString(5, student.getLevel());

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }


    @Override
    public boolean delete(String studentId, Connection connection) {

        try {

            var ps = connection.prepareStatement(DELETE_STUDENT);
            ps.setString(1, studentId);

            return ps.executeUpdate() != 0;

        } catch (SQLException e){
            throw new RuntimeException();
        }

    }


    @Override
    public boolean update(String studentId, Student student, Connection connection) {

        try {

            var ps = connection.prepareStatement(UPDATE_STUDENT);
            ps.setString(1, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(2, student.getCity());
            ps.setString(4, student.getLevel());
            ps.setString(5, studentId);

            return ps.executeUpdate() != 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
