package util;

public final class UserQueries {
    private UserQueries() {
    }

    public static final String FIND_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    public static final String LOGIN_USER = "SELECT  id, email, password, role , first_name FROM user WHERE email = ? AND password = ?";
    public static final String GET_INFO = "SELECT * FROM user WHERE id = ?";
    public static final String ADD_USER = "INSERT INTO user(`id`,`first_name`,`last_name`,`email`,`password`,`phone_number`,`birthday`,`address`,`gender`,`hire_date`,`paid_time_off`,`is_deleted`,`role`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String DELETE_USER = "UPDATE user SET is_deleted = true where id  = ?";


}
