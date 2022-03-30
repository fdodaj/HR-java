package repository;

import entity.Department;
import entity.Permission;
import model.DepartmentPermissionsDTO;
import model.PermissionDTO;
import util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static util.UserQueries.*;

public class PermissionsRepository {
    Connection connection = DatabaseConnection.getConnection();

    public Permission createPermission(Permission permission) {

        try (PreparedStatement statement = connection.prepareStatement(CREATE_PERMISSION)) {
            Permission Permission = new Permission();
            statement.setDate(1, Date.valueOf(permission.getFromDate()));
            statement.setDate(2, Date.valueOf(permission.getToDate()));
            statement.setString(3, permission.getReason());
            statement.setInt(4, permission.getBusinessDays());
            statement.setString(5, permission.getPermissionStatus());
            statement.setBoolean(6, permission.getDeleted());
            statement.setInt(7, permission.getUser_id());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return permission;
    }

    public List<Permission> listPermissions(){
        Permission permission = null;
        List<Permission> permissions = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_PERMISSIONS)){
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                permission = new Permission();
                permission.setId(result.getInt("id"));
                permission.setFromDate(result.getDate("from_date").toLocalDate());
                permission.setToDate(result.getDate("to_date").toLocalDate());
                permission.setReason(result.getString("reason"));
                permission.setBusinessDays(result.getInt("business_days"));
                permission.setPermissionStatus(result.getString("permission_status"));
                permission.setDeleted(result.getBoolean("is_deleted"));
                permission.setUser_id(result.getInt("user_id"));
                permissions.add(permission);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return permissions;
    }

    public Permission delete(Integer id) {
        Permission permission = null;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_PERMISSION)){

            statement.setInt(1, id);
            statement.setBoolean(1, true);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return permission;
    }

    public Permission getPermissionById(Integer id) {
        Permission permission = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_PERMISSION_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                permission = new Permission();
                permission.setId(result.getInt("id"));
                permission.setFromDate(result.getDate("from_date").toLocalDate());
                permission.setToDate(result.getDate("to_date").toLocalDate());
                permission.setReason(result.getString("reason"));
                permission.setBusinessDays(result.getInt("business_days"));
                permission.setPermissionStatus(result.getString("permission_status"));
                permission.setDeleted(result.getBoolean("is_deleted"));
                permission.setUser_id(result.getInt("user_id"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return permission;
    }


    public Permission approve(Integer id) {
        Permission permission = null;
        try (PreparedStatement statement = connection.prepareStatement(APPROVE_PERMISSION)){

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return permission;
    }

    public Permission reject(Integer id) {
        Permission permission = null;
        try (PreparedStatement statement = connection.prepareStatement(REJECT_PERMISSION)){

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return permission;
    }
//    select u.first_name, u.last_name,u.paid_time_off, p.reason, p.from_date,p.to_date, p.permission_status from permission p  join user u on p.user_id = u.id  join department d on d.id = u.department_id where department_id=4;
//        try (PreparedStatement statement = connection.prepareStatement("select u.first_name, u.last_name,u.paid_time_off, p.reason, p.from_date,p.to_date, p.permission_status from permission p  join user u on p.user_id = u.id  join department d on d.id = u.department_id where department_id=4")){
public List<DepartmentPermissionsDTO> getPermissionByDepartment(Integer id) {
    DepartmentPermissionsDTO departmentPermissionsDTO = null;
    List<DepartmentPermissionsDTO> list = new ArrayList<>();

    try (PreparedStatement statement = connection.prepareStatement("select u.first_name, u.last_name,u.paid_time_off, p.reason, p.from_date,p.to_date, p.permission_status from permission p  join user u on p.user_id = u.id  join department d on d.id = u.department_id where department_id=?")){
         statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            departmentPermissionsDTO = new DepartmentPermissionsDTO();
            departmentPermissionsDTO.setFirstName(result.getString("first_name"));
            departmentPermissionsDTO.setLastName(result.getString("last_name"));
            departmentPermissionsDTO.setPaidTimeOff(result.getInt("paid_time_off"));
            departmentPermissionsDTO.setReason(result.getString("reason"));
            departmentPermissionsDTO.setFromDate(result.getDate("from_date"));
            departmentPermissionsDTO.setToDate(result.getDate("to_date"));
            list.add(departmentPermissionsDTO);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }
    return list;
}

    public Permission getUserPermission(Integer id) {
        Permission permission = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT p.from_date, p.to_date,p.reason, u.first_name as firstName, u.last_name as lastname from permission p left join user u on u.id = p.user_id  where p.id = ?")) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                permission = new Permission();
//                permission.setId(result.getInt("id"));
                permission.setFromDate(result.getDate("from_date").toLocalDate());
                permission.setToDate(result.getDate("to_date").toLocalDate());
                permission.setReason(result.getString("reason"));
                permission.setUser_id(result.getInt("user_id"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return permission;
    }
}
