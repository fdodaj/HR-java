package service;

import entity.AuthenticatedUser;
import entity.User;
import model.MinimalUserDTO;
import model.UserDTO;
import model.UserDepartmentDTO;
import repository.UserRepository;
import service.services.UserService;

import java.sql.SQLException;
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

    @Override
    public List<User> listUsers() {
        return userRepository.listUsers();
    }

    @Override
    public MinimalUserDTO getMinimalData(Integer id) {
        return userRepository.getMinimalData(id);
    }

    public UserDTO getUserPerm(Integer id){
        return userRepository.getUserPermissions(id);
    }

    public List<UserDepartmentDTO> getUserByDepartment(Integer id){
        return userRepository.getUsersByDepartment(id);
    }
}
