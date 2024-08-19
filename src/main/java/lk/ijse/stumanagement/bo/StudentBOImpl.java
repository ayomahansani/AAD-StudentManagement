package lk.ijse.stumanagement.bo;

import lk.ijse.stumanagement.dao.StudentDAO;
import lk.ijse.stumanagement.dao.StudentDAOImpl;
import lk.ijse.stumanagement.dto.StudentDTO;
import lk.ijse.stumanagement.entity.Student;

import java.sql.Connection;


public final class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = new StudentDAOImpl();


    @Override
    public StudentDTO getStudent(String studentId, Connection connection) {
        Student student = studentDAO.getStudent(studentId, connection);
        return new StudentDTO(student.getId(),student.getName(),student.getEmail(),student.getCity(),student.getLevel());
    }

    @Override
    public boolean saveStudent(StudentDTO studentDTO, Connection connection) {
        Student student = new Student(studentDTO.getId(),studentDTO.getName(),studentDTO.getEmail(),studentDTO.getCity(),studentDTO.getLevel());
        return studentDAO.saveStudent(student, connection);
    }

    @Override
    public boolean deleteStudent(String studentId, Connection connection) {
        return studentDAO.deleteStudent(studentId, connection);
    }

    @Override
    public boolean updateStudent(String studentId, StudentDTO studentDTO, Connection connection) {
        Student student = new Student(studentDTO.getId(),studentDTO.getName(),studentDTO.getEmail(),studentDTO.getCity(),studentDTO.getLevel());
        return studentDAO.updateStudent(studentId, student, connection);
    }
}
