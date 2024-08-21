package lk.ijse.stumanagement.bo;

import lk.ijse.stumanagement.dto.StudentDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public sealed interface StudentBO permits StudentBOImpl {


    List<StudentDTO> getStudent(Connection connection) throws SQLException;
    boolean saveStudent(StudentDTO studentDTO, Connection connection) throws SQLException;
    boolean deleteStudent(String studentId, Connection connection) throws SQLException;
    boolean updateStudent(String studentId, StudentDTO studentDTO, Connection connection) throws SQLException;


}
