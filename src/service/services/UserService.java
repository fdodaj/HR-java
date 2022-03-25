package service.services;

import entity.AuthenticatedUser;
import entity.User;
import model.MinimalUserDTO;
import model.UserDTO;
import model.UserDepartmentDTO;

import java.sql.SQLException;
import java.util.List;


public interface UserService {
    User addUser(User user);

    User updateUser(User user);

    User getUserById(Integer id);

    User deleteUser(Integer id);

    AuthenticatedUser loginUser(String email, String password);

    List<User> listUsers();

    MinimalUserDTO getMinimalData(Integer id);

    UserDTO getUserPerm(Integer id);

    List<UserDepartmentDTO> getUserByDepartment(Integer id);


}
