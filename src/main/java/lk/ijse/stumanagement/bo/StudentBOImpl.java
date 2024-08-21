package lk.ijse.stumanagement.bo;

import lk.ijse.stumanagement.dao.DAOFactory;
import lk.ijse.stumanagement.dao.StudentDAO;
import lk.ijse.stumanagement.dao.StudentDAOImpl;
import lk.ijse.stumanagement.dto.StudentDTO;
import lk.ijse.stumanagement.entity.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public final class StudentBOImpl implements StudentBO {

    private StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);


    @Override
    public List<StudentDTO> getStudent(Connection connection) throws SQLException {
        List<Student> studentList = studentDAO.get(connection);
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Student student : studentList) {
            StudentDTO studentDTO = new StudentDTO(student.getId(),student.getName(),student.getEmail(),student.getCity(),student.getLevel());
            studentDTOList.add(studentDTO);
        }

        return studentDTOList;
    }

    @Override
    public boolean saveStudent(StudentDTO studentDTO, Connection connection) throws SQLException {
        Student student = new Student(studentDTO.getId(),studentDTO.getName(),studentDTO.getEmail(),studentDTO.getCity(),studentDTO.getLevel());
        return studentDAO.save(student, connection);
    }

    @Override
    public boolean deleteStudent(String studentId, Connection connection) throws SQLException {
        return studentDAO.delete(studentId, connection);
    }

    @Override
    public boolean updateStudent(String studentId, StudentDTO studentDTO, Connection connection) throws SQLException {
        Student student = new Student(studentDTO.getId(),studentDTO.getName(),studentDTO.getEmail(),studentDTO.getCity(),studentDTO.getLevel());
        return studentDAO.update(studentId, student, connection);
    }
}
