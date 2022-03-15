package service;

import entity.AuthenticatedUser;
import entity.User;

import java.util.List;


public interface UserService {
    User addUser(User user);

    User updateUser(User user);

    User getUserById(Integer id);

    User deleteUser(Integer id);

    List<User> getAllUsers();

    AuthenticatedUser loginUser(String email, String password);


}
