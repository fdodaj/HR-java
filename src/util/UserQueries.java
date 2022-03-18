package util;

public final class UserQueries {
    private UserQueries() {
    }

    public static final String LOGIN_USER = "SELECT  id, email, password, role , first_name FROM user WHERE email = ? AND password = ?";
    public static final String GET_INFO = "SELECT * FROM user WHERE id = ?";
    public static final String ADD_USER = "INSERT INTO user(`id`,`first_name`,`last_name`,`email`,`password`,`phone_number`,`birthday`,`address`,`gender`,`hire_date`,`paid_time_off`,`is_deleted`,`role`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String DELETE_USER = "UPDATE user SET is_deleted = true where id  = ?";
    public static final String GET_ALL_USERS = "SELECT * FROM user";


    public static final String GET_ALL_HOLIDAY  = "SELECT * FROM holiday";
    public static final String GET_HOLIDAY_BY_ID = "SELECT * FROM holiday WHERE id = ?";
    public static final String ADD_HOLIDAY = "INSERT INTO holiday(`id`,`name`, `description`, `is_active`, `is_deleted`) VALUES (?, ?, ?, ?, ?)";
    public static final String DELETE_HOLIDAY = "UPDATE holiday SET is_deleted = true where id  = ?";

    public static final String GET_ALL_DEPARTMENTS = "SELECT * FROM department";
    public static final String GET_DEPARTMENT_BY_ID = "SELECT * FROM department where id = ?";
    public static final String ADD_DEPARTMENT = "INSERT INTO department(`id`, `name`, `description`, `department_leader`, `is_deleted`) VALUES(?, ?, ?, ?, ?)";
    public static final String DELETE_DEPARTMENT = "UPDATE department SET is_deleted = true where id = ?";




}
