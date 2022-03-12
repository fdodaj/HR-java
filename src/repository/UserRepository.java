package repository;

import com.mysql.cj.jdbc.JdbcConnection;
import model.AuthenticatedUser;
import model.User;

import java.sql.*;

import static util.UserQueries.FIND_USER_BY_ID;
import static util.UserQueries.LOGIN_USER;

public class UserRepository {



    public User findUserById(Integer id) {
        User user = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "root");
             PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_ID);) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user = new User();
                user.setId(result.getInt(1));
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
                user.setRole(result.getString(13));

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }
        return user;
    }
    public AuthenticatedUser authenticate(String email, String password) {
        AuthenticatedUser auth = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "root");
             PreparedStatement statement = connection.prepareStatement(LOGIN_USER)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                auth = new AuthenticatedUser();
                auth.setId(result.getInt(1));
                auth.setEmail(result.getString(2));
                auth.setPassword(result.getString(3));
                auth.setRole(result.getString(4));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return auth;
    }
}
