package service;

import model.AuthenticatedUser;
import model.User;

import java.util.List;


public interface UserService {
    void addUser(User user);

    User updateUser(User user);

    boolean deleteUser(Integer id);

    User getUserById(Integer id);

    List<User> getAllUsers();

    AuthenticatedUser loginUser(String email, String password);


}
