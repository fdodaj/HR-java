package util;

public final class UserQueries {
    private UserQueries() {
    }

    public static final String FIND_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    public static final String LOGIN_USER = "SELECT  id, email, password, role FROM user WHERE email = ? AND password = ?";

}
