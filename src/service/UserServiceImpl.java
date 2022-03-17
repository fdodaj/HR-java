package service;

import entity.AuthenticatedUser;
import entity.User;
import repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserRepository();


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return  userRepository.getUserById(id);
    }

    @Override
    public User deleteUser(Integer id) {
        return userRepository.delete(id);
    }



    @Override
    public AuthenticatedUser loginUser(String email, String password) {
       return userRepository.authenticate(email, password);
    }

    public String listUsers(){
        return userRepository.listUsers();
    }

}
