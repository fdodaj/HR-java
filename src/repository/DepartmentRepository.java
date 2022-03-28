package repository;
import entity.Department;
import entity.Permission;
import model.PermissionDTO;
import model.UserDTO;
import model.UserDepartmentDTO;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static util.UserQueries.*;

public class DepartmentRepository {
    Connection connection = DatabaseConnection.getConnection();

    public Department addDepartment(Department department) {

        try (PreparedStatement statement = connection.prepareStatement(ADD_DEPARTMENT)) {

            statement.setInt(1, department.getId());
            statement.setString(2, department.getName());
            statement.setString(3, department.getDescription());
            statement.setBoolean(5, department.getDeleted());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return department;
    }

    public List<Department> listDepartments(){
        Department department = null;
        List<Department> departments = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_DEPARTMENTS)){
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                department = new Department();
                department.setId(result.getInt("id"));
                department.setName(result.getString("name"));
                department.setDescription(result.getString("description"));
                department.setDeleted(result.getBoolean("is_deleted"));
                departments.add(department);

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return departments;
    }

    public Department delete(Integer id) {
        Department department = null;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_DEPARTMENT)){

            statement.setInt(1, id);
            statement.setBoolean(1, true);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return department;
    }

    public Department getDepartmentById(Integer id) {
        Department department = null;
        try (PreparedStatement statement = connection.prepareStatement(GET_DEPARTMENT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                department = new Department();
                department.setId(result.getInt("id"));
                department.setName(result.getString("name"));
                department.setDescription(result.getString("description"));
                department.setDeleted(result.getBoolean("is_deleted"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return department;
    }

    public boolean deletePermanentDepartment(Integer id) {
        Department department = null;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_PERMANENT_DEPARTMENT)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return true;
    }

    public Department getDepartmentName(Integer id) {
        Department department = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT name FROM department where id=?")) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                department = new Department();
                department.setName(result.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return department;
    }
}
