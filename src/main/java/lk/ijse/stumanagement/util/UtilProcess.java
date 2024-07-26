package lk.ijse.stumanagement.util;

import java.util.UUID;

public class UtilProcess {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
