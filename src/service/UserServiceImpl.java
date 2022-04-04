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
        if (userRepository.getUserById(id).getDeleted())
            return null;
        else
        return  userRepository.getUserById(id);
    }

    @Override
    public User deleteUser(Integer id) {
        return userRepository.delete(id);
    }


    @Override
    public AuthenticatedUser loginUser(String email, String password) {

        try {
            if (userRepository.getUserByEmail(email).getDeleted()){
                System.out.println("User is deleted");
                return null;
            }
            else
                return userRepository.authenticate(email, password);
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public List<User> listUsers() {
        return userRepository.listUsers();
    }

    @Override
    public MinimalUserDTO getMinimalData(Integer id) {
        if (userRepository.getUserById(id).getDeleted() == false)
             return userRepository.getMinimalData(id);
        else{
            System.out.println("The user has been deleted");
            return null;
        }
    }

    @Override
    public UserDTO getUserPerm(Integer id) {
        if (userRepository.getUserById(id).getDeleted() == false)
             return userRepository.getUserPermissions(id);
        else{
            System.out.println("The user has been deleted");
            return null;
        }
    }

    public User updateUserPTO(User user) throws Exception {
        if (!user.getDeleted())
             return userRepository.updateUserPto(user);
        else{
            System.out.println("The user has been deleted");
            return null;
        }
    }
    public List<UserDepartmentDTO> getUserByDepartment(Integer id){
        if (!userRepository.getUserById(id).getDeleted())
             return userRepository.getUsersByDepartment(id);
        else{
            System.out.println("The user has been deleted");
            return null;
        }
    }

    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }
}
