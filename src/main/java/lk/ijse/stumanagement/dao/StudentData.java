package lk.ijse.stumanagement.dao;

import org.example.studentmanagement.dto.StudentDTO;

import java.sql.Connection;
import java.sql.SQLException;

public sealed interface StudentData permits StudentDataProcess{

    StudentDTO getStudent(String studentId, Connection connection) throws SQLException;
    boolean saveStudent(StudentDTO studentDTO, Connection connection);
    boolean deleteStudent(String studentId, Connection connection);
    boolean updateStudent(String studentId, StudentDTO studentDTO, Connection connection);


}
