package lk.ijse.stumanagement.dao;

import lk.ijse.stumanagement.dto.StudentDTO;
import lk.ijse.stumanagement.entity.Student;

import java.sql.Connection;

public sealed interface StudentDAO extends CrudDAO<Student> permits StudentDAOImpl {

/*
    List<Student> get(Connection connection);
    boolean save(Student student, Connection connection);
    boolean delete(String studentId, Connection connection);
    boolean update(String studentId, Student student, Connection connection);
*/


}
