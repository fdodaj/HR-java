package repository;

import entity.Permission;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.UserQueries.*;

public class PermissionsRepository {
    Connection connection = DatabaseConnection.getConnection();

    public Permission createPermission(Permission permission) {

        try (PreparedStatement statement = connection.prepareStatement(CREATE_PERMISSION)) {
            Permission Permission = new Permission();
            statement.setInt(1, permission.getId());
            statement.setDate(2, permission.getFromDate());
            statement.setDate(3, permission.getToDate());
            statement.setString(4, permission.getReason());
            statement.setInt(5, permission.getBusinessDays());
            statement.setString(6, permission.getPermissionStatus());
            statement.setBoolean(7, permission.getDeleted());
            statement.setInt(8, permission.getUser_id());
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
                permission.setFromDate(result.getDate("from_date"));
                permission.setToDate(result.getDate("to_date"));
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
                permission.setFromDate(result.getDate("from_date"));
                permission.setToDate(result.getDate("to_date"));
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
}
