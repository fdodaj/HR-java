package repository;

import entity.RequestPermission;
import entity.Role;
import entity.User;
import util.DatabaseConnection;

import java.sql.*;

import static util.UserQueries.*;


public class RoleRepository {

    Connection connection = DatabaseConnection.getConnection();

    public void addRole(Role role) {

        try (PreparedStatement statement = connection.prepareStatement(ADD_ROLE)) {

            statement.setInt(1, role.getId());
            statement.setString(2, role.getName());
            statement.setString(3, role.getDescription());
            statement.setBoolean(4, role.getDeleted());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    public void getAllRoles(){
        Role role = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_ROLES)){
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id  = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                boolean deleted = result.getBoolean("is_deleted");
                System.out.println(id + ", " + name + ", " + description + ", " + deleted);

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Role delete(Integer id) {
        Role role = null;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_ROLE)){

            statement.setInt(1, id);
            statement.setBoolean(1, true);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return role;
    }

}
