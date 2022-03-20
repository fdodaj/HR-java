package repository;

import entity.Department;
import entity.RequestPermission;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.UserQueries.*;
import static util.UserQueries.GET_DEPARTMENT_BY_ID;

public class PermissionsRepository {
    Connection connection = DatabaseConnection.getConnection();

    public RequestPermission createPermission(RequestPermission requestPermission) {

        try (PreparedStatement statement = connection.prepareStatement(CREATE_PERMISSION)) {
            RequestPermission permission = new RequestPermission();
            statement.setInt(1, requestPermission.getId());
            statement.setInt(2, requestPermission.getUser());
            statement.setDate(3, (Date) requestPermission.getFromDate());
            statement.setDate(4, (Date) requestPermission.getToDate());
            statement.setString(5, requestPermission.getReason());
            statement.setInt(6, requestPermission.getBusinessDays());
            statement.setString(7, requestPermission.getRequestType());
            statement.setString(8, requestPermission.getRequestStatus());
            statement.setBoolean(9, requestPermission.getDeleted());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return requestPermission;
    }

    public List<RequestPermission> listPermissions(){
        RequestPermission requestPermission = null;
        List<RequestPermission> requestPermissions = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_PERMISSIONS)){
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                requestPermission = new RequestPermission();
                requestPermission.setId(result.getInt("id"));
                requestPermission.setUser(result.getInt("user"));
                requestPermission.setFromDate(result.getDate("from_date"));
                requestPermission.setToDate(result.getDate("to_date"));
                requestPermission.setReason(result.getString("reason"));
                requestPermission.setBusinessDays(result.getInt("business_days"));
                requestPermission.setRequestType(result.getString("request_type"));
                requestPermission.setRequestStatus(result.getString("request_status"));
                requestPermission.setDeleted(result.getBoolean("is_deleted"));
                requestPermissions.add(requestPermission);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return requestPermissions;
    }

    public RequestPermission delete(Integer id) {
        RequestPermission requestPermission = null;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_PERMISSION)){

            statement.setInt(1, id);
            statement.setBoolean(1, true);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return requestPermission;
    }

    public RequestPermission getPermissionById(Integer id) {
        RequestPermission requestPermission = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_PERMISSION_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                requestPermission = new RequestPermission();
                requestPermission.setId(result.getInt("id"));
                requestPermission.setUser(result.getInt("user"));
                requestPermission.setFromDate(result.getDate("from_date"));
                requestPermission.setToDate(result.getDate("to_date"));
                requestPermission.setReason(result.getString("reason"));
                requestPermission.setBusinessDays(result.getInt("business_days"));
                requestPermission.setRequestType(result.getString("request_type"));
                requestPermission.setRequestStatus(result.getString("request_status"));
                requestPermission.setDeleted(result.getBoolean("is_deleted"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return requestPermission;
    }
}
