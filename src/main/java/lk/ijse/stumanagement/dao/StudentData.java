package lk.ijse.stumanagement.dao;

import lk.ijse.stumanagement.dto.StudentDTO;

import java.sql.Connection;
import java.sql.SQLException;

public sealed interface StudentData permits StudentDataProcess{

    StudentDTO getStudent(String studentId, Connection connection);
    boolean saveStudent(StudentDTO studentDTO, Connection connection);
    boolean deleteStudent(String studentId, Connection connection);
    boolean updateStudent(String studentId, StudentDTO studentDTO, Connection connection);


}
