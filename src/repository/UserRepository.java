package repository;

import entity.AuthenticatedUser;
import entity.User;
import model.MinimalUserDTO;
import model.PermissionDTO;
import model.UserDTO;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.UserQueries.*;

public class UserRepository {
    Connection connection = DatabaseConnection.getConnection();

    public User save(User user) {

        try (PreparedStatement statement = connection.prepareStatement(ADD_USER)) {

            statement.setInt(1, user.getId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setDate(6, (Date) user.getBirthday());
            statement.setString(7, user.getGender());
            statement.setDate(8, (Date) user.getHireDate());
            statement.setInt(9, user.getPaidTimeOff());
            statement.setBoolean(10, user.getDeleted());
            statement.setInt(11, user.getRole_id());
            statement.setInt(12, user.getDepartment_id());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return user;

    }

    public User delete(Integer id) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {

            statement.setInt(1, id);
            statement.setBoolean(1, true);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return user;

    }


    public AuthenticatedUser authenticate(String email, String password) {
        AuthenticatedUser auth = null;
        try (PreparedStatement statement = connection.prepareStatement(LOGIN_USER)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                auth = new AuthenticatedUser();
                auth.setId(result.getInt(1));
                auth.setEmail(result.getString(2));
                auth.setPassword(result.getString(3));
                auth.setRole(result.getInt(4));
                auth.setFirstName(result.getString(5));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return auth;
    }

    public User getUserById(Integer id) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_INFO)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user = new User();
                user.setId(result.getInt("id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setBirthday(result.getDate("birthday"));
                user.setGender(result.getString("gender"));
                user.setHireDate(result.getDate("hire_date"));
                user.setPaidTimeOff(result.getInt("paid_time_off"));
                user.setDeleted(result.getBoolean("is_deleted"));
                user.setRole_id(result.getInt("role_id"));
                user.setDepartment_id(result.getInt("department_id"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return user;
    }



    public List<User> listUsers() {
        User user = null;
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_USERS)) {
            ResultSet result = statement.executeQuery();


            while (result.next()) {
                user = new User();
                user.setId(result.getInt("id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setBirthday(result.getDate("birthday"));
                user.setGender(result.getString("gender"));
                user.setHireDate(result.getDate("hire_date"));
                user.setPaidTimeOff(result.getInt("paid_time_off"));
                user.setDeleted(result.getBoolean("is_deleted"));
                user.setRole_id(result.getInt("role_id"));
                user.setDepartment_id(result.getInt("department_id"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }

    public MinimalUserDTO getMinimalData(Integer id) {
        MinimalUserDTO minimalUserDTO = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_MINIMAL_DATA_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                minimalUserDTO = new MinimalUserDTO();
                minimalUserDTO.setFirstName(result.getString("first_name"));
                minimalUserDTO.setLastName(result.getString("last_name"));
                minimalUserDTO.setEmail(result.getString("email"));
                minimalUserDTO.setRole(result.getString("role_name"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return minimalUserDTO;

    }

    public UserDTO getUserPermissions(Integer id) {
        UserDTO userDTO = new UserDTO();

        try {
            PreparedStatement statement = connection.prepareStatement(GET_MINIMAL_DATA_BY_ID);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                userDTO.setFirstName(result.getString("first_name"));
                userDTO.setLastName(result.getString("last_name"));
                userDTO.setEmail(result.getString("email"));
                userDTO.setRole(result.getString("role_name"));
            }


            statement = connection.prepareStatement("select p.*  from user u left join permission p on u.id = p.user_id where u.id = ?");
            statement.setInt(1, id);
            result = statement.executeQuery();

            List<PermissionDTO> permissionDTOS = new ArrayList<>();
            while (result.next()) {
                PermissionDTO permissionDTO = new PermissionDTO();
                permissionDTO.setFromDate(result.getDate("from_date"));
                permissionDTO.setToDate(result.getDate("to_date"));
                permissionDTO.setPermissionStatus(result.getString("permission_status"));
                permissionDTO.setReason(result.getString("reason"));
                permissionDTOS.add(permissionDTO);
            }

            userDTO.setPermissions(permissionDTOS);
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return userDTO;



    }


}
