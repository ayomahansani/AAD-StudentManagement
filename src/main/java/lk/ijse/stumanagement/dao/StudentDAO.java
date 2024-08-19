package lk.ijse.stumanagement.dao;

import lk.ijse.stumanagement.dto.StudentDTO;
import lk.ijse.stumanagement.entity.Student;

import java.sql.Connection;

public sealed interface StudentDAO permits StudentDAOImpl {

    Student getStudent(String studentId, Connection connection);
    boolean saveStudent(Student student, Connection connection);
    boolean deleteStudent(String studentId, Connection connection);
    boolean updateStudent(String studentId, Student student, Connection connection);


}
