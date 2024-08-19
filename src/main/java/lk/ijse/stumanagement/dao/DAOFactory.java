package lk.ijse.stumanagement.dao;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{   // Enumeration --> Represents the group of contents
        STUDENT
    }

    public StudentDAOImpl getDAO(DAOTypes daoTypes){  // return type must be the most super(SuperDAO)

        switch (daoTypes){
            case STUDENT:
                return new StudentDAOImpl();
            default:
                return null;
        }
    }
}
