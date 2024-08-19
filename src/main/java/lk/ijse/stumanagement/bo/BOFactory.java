package lk.ijse.stumanagement.bo;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        return (boFactory == null) ? new BOFactory() : boFactory;
    }

    public enum BOTypes{   // Enumeration --> Represents the group of contents
        STUDENT
    }

    public StudentBOImpl getBO(BOFactory.BOTypes boTypes){  // return type must be the most super(SuperDAO)

        switch (boTypes){
            case STUDENT:
                return new StudentBOImpl();
            default:
                return null;
        }
    }
}
