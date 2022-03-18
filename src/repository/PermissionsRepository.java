package repository;

import entity.Department;
import entity.RequestPermission;
import util.DatabaseConnection;

import java.sql.*;

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

    public void listAllPermissions(){
        RequestPermission requestPermission = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_PERMISSIONS)){
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id  = result.getInt("id");
                int user = result.getInt("user");
                Date fromDate = result.getDate("from_date");
                Date toDate = result.getDate("to_date");
                String reason = result.getString("reason");
                int businessDays = result.getInt("business_days");
                String requestType = result.getString("request_type");
                String requestStatus = result.getString("request_status");
                boolean deleted = result.getBoolean("is_deleted");
                System.out.println(id + ", " + user + ", " + fromDate + ", " + toDate + ", " + reason + ", " + businessDays + ", " + requestType + ", " + requestStatus + ", " + deleted );

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
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
