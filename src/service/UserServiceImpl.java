package service;

import model.AuthenticatedUser;
import model.User;
import repository.UserRepository;

import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserRepository();

    @Override
    public void addUser(User user) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return Collections.emptyList();
    }

    @Override
    public AuthenticatedUser loginUser(String email, String password) {
       return userRepository.authenticate(email, password);
    }



}
