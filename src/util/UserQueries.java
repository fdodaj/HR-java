package util;

public final class UserQueries {
    private UserQueries() {}

    public static final String LOGIN_USER = "SELECT  id, email, password, role_id, first_name,  department_id  FROM user WHERE email = ? AND password = ?";
    public static final String GET_INFO = "SELECT * FROM user WHERE id = ?";
    public static final String ADD_USER = "INSERT INTO user(`id`,`first_name`,`last_name`,`email`,`password`,`phone_number`,`birthday`,`address`,`gender`,`hire_date`,`paid_time_off`,`is_deleted`,`role`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String DELETE_USER = "UPDATE user SET is_deleted = true where id  = ?";
    public static final String GET_ALL_USERS = "SELECT * FROM user";
    public static final String GET_MINIMAL_DATA = "select u.last_name, u.first_name, u.email, r.id, r.name  from user u left join role r on u.role_id = r.id";
    public static final String GET_MINIMAL_DATA_BY_ID = "select u.last_name, u.first_name, u.email, r.name as role_name  from user u left join role r on u.role_id = r.id where u.id = ?";


    public static final String GET_ALL_HOLIDAY  = "SELECT * FROM holiday";
    public static final String GET_HOLIDAY_BY_ID = "SELECT * FROM holiday WHERE id = ?";
    public static final String ADD_HOLIDAY = "INSERT INTO holiday(`id`,`name`, `description`,`date`, `is_active`, `is_deleted`) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String DELETE_HOLIDAY = "UPDATE holiday SET is_deleted = true where id  = ?";

    public static final String GET_ALL_DEPARTMENTS = "SELECT * FROM department";
    public static final String GET_DEPARTMENT_BY_ID = "SELECT * FROM department where id = ?";
    public static final String ADD_DEPARTMENT = "INSERT INTO department(`id`, `name`, `description`, `department_leader`, `is_deleted`) VALUES(?, ?, ?, ?, ?)";
    public static final String DELETE_DEPARTMENT = "UPDATE department SET is_deleted = true where id = ?";


    public static final String GET_ALL_PERMISSIONS = "SELECT * FROM permission";
    public static final String GET_PERMISSION_BY_ID = "SELECT * FROM permission where id = ?";
    public static final String CREATE_PERMISSION = "INSERT INTO permission(`id`,`from_date`, `to_date`, `reason`, `business_days`, `permission_status`, `is_deleted`, `user_id`) VALUES(?, ?, ?,?, ?, ?, ?,?)";
    public static final String DELETE_PERMISSION = "UPDATE permission SET is_deleted = true where id = ?";
    public static final String APPROVE_PERMISSION = "UPDATE permission SET permission_status = 'Approved'  where id  = ?";
    public static final String REJECT_PERMISSION = "UPDATE permission SET permission_status = 'Rejected'  where id  = ?";


    public static final String GET_ALL_ROLES = "SELECT * FROM role";
    public static final String ADD_ROLE = "INSERT INTO role(`id`, `name`, `description`, `is_deleted`) VALUES (?, ?, ?, ?)";
    public static final String DELETE_ROLE = "UPDATE role SET is_deleted = true  WHERE id = ?";


}
