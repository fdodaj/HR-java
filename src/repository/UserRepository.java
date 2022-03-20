package repository;

import entity.AuthenticatedUser;
import entity.User;
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
            statement.setString(6, user.getPhoneNumber());
            statement.setDate(7, (Date) user.getBirthday());
            statement.setString(8, user.getAddress());
            statement.setString(9, user.getGender());
            statement.setDate(10, (Date) user.getHireDate());
            statement.setInt(11, user.getPaidTimeOff());
            statement.setBoolean(12, user.getDeleted());
            statement.setString(13, user.getRole());

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
                auth.setRole(result.getString(4));
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
                user.setFirstName(result.getString(2));
                user.setLastName(result.getString(3));
                user.setEmail(result.getString(4));
                user.setPassword(result.getString(5));
                user.setPhoneNumber(result.getString(6));
                user.setBirthday(result.getDate(7));
                user.setAddress(result.getString(8));
                user.setGender(result.getString(9));
                user.setHireDate(result.getDate(10));
                user.setPaidTimeOff(result.getInt(11));
                user.setDeleted(result.getBoolean(12));
                user.setRole(result.getString(4));
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
                user.setId(result.getInt("user_id"));
                user.setFirstName(result.getString(2));
                user.setLastName(result.getString(3));
                user.setEmail(result.getString(4));
                user.setPassword(result.getString(5));
                user.setPhoneNumber(result.getString(6));
                user.setBirthday(result.getDate(7));
                user.setAddress(result.getString(8));
                user.setGender(result.getString(9));
                user.setHireDate(result.getDate(10));
                user.setPaidTimeOff(result.getInt(11));
                user.setDeleted(result.getBoolean(12));
                user.setRole(result.getString(4));
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }
}
