package repository;
import entity.Holiday;
import entity.User;
import util.DatabaseConnection;

import java.sql.*;

import static util.UserQueries.*;

public class HolidayRepository {
    Connection connection = DatabaseConnection.getConnection();

    public Holiday save(Holiday holiday) {

        try (PreparedStatement statement = connection.prepareStatement(ADD_HOLIDAY)) {

            statement.setInt(1, holiday.getId());
            statement.setString(2, holiday.getName());
            statement.setString(3, holiday.getDescription());
            statement.setBoolean(4, holiday.getActive());
            statement.setBoolean(5, holiday.getDeleted());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return holiday;
    }


    public Holiday getHolidayById(Integer id) {
        Holiday holiday = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_HOLIDAY_BY_ID)){
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                holiday = new Holiday();
                holiday.setId(result.getInt("id"));
                holiday.setName(result.getString("name"));
                holiday.setDescription(result.getString("description"));
                holiday.setActive(result.getBoolean("is_active"));
                holiday.setDeleted(result.getBoolean("is_deleted"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return holiday;
    }

    public  String getHoliday(){
        Holiday holiday = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_HOLIDAY)){
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id  = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                Boolean active = result.getBoolean("is_active");
                Boolean deleted = result.getBoolean("is_deleted");
                System.out.println(id + "," + name + "," + deleted + "," + active + "," + deleted );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "All holidays";
    }


    public Holiday delete(Integer id) {
        Holiday holiday = null;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_HOLIDAY)){

            statement.setInt(1, id);
            statement.setBoolean(1, true);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return holiday;

    }

}
