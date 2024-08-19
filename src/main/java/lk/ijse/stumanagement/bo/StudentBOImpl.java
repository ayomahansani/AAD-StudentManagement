package lk.ijse.stumanagement.bo;

import lk.ijse.stumanagement.dao.StudentDAO;
import lk.ijse.stumanagement.dao.StudentDAOImpl;
import lk.ijse.stumanagement.dto.StudentDTO;

import java.sql.Connection;


public final class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = new StudentDAOImpl();


    @Override
    public StudentDTO getStudent(String studentId, Connection connection) {
        return studentDAO.getStudent(studentId, connection);
    }

    @Override
    public boolean saveStudent(StudentDTO studentDTO, Connection connection) {
        return studentDAO.saveStudent(studentDTO, connection);
    }

    @Override
    public boolean deleteStudent(String studentId, Connection connection) {
        return studentDAO.deleteStudent(studentId, connection);
    }

    @Override
    public boolean updateStudent(String studentId, StudentDTO studentDTO, Connection connection) {
        return studentDAO.updateStudent(studentId, studentDTO, connection);
    }
}
