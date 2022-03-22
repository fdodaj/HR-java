package repository;

import entity.Role;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Role> listRoles(){
        Role role = null;
        List<Role> roles = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_ROLES)){
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                role = new Role();
                role.setId(result.getInt("id"));
                role.setName(result.getString("name"));
                role.setDescription(result.getString("description"));
                role.setDeleted(result.getBoolean("is_deleted"));
                roles.add(role);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return roles;
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
