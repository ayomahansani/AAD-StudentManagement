package lk.ijse.stumanagement.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> {

    boolean save(T entity, Connection connection) throws SQLException;
    boolean update(String studentId, T entity, Connection connection) throws SQLException;
    boolean delete(String studentId, Connection connection) throws SQLException;
    List<T> get(Connection connection) throws SQLException;

}
