package lk.ijse.stumanagement.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface CrudDAO<T> {

    boolean save(T entity, Connection connection) throws SQLException;
    boolean update(String studentId, T entity, Connection connection) throws SQLException;
    boolean delete(String studentId, Connection connection) throws SQLException;
    T get(String studentId, Connection connection) throws SQLException;

}
