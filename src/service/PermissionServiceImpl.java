package service;

import entity.Permission;
import entity.User;
import model.DepartmentPermissionsDTO;
import repository.PermissionsRepository;
import repository.UserRepository;
import service.services.PermissionService;


import java.util.List;

public class PermissionServiceImpl implements PermissionService {
    Permission permission = new Permission();
    User user = new User();
    PermissionsRepository permissionsRepository = new PermissionsRepository();
    UserRepository userRepository = new UserRepository();
    @Override
    public List<Permission> listPermissions() {
        return permissionsRepository.listPermissions();
    }

    @Override
    public Permission createPermission(Permission requestPermission) {
        Permission permission = permissionsRepository.getPermissionById(requestPermission.getId());
         user = userRepository.getUserById(user.getId());
        if (user.getPaidTimeOff()>permission.getBusinessDays()) {
            System.out.println("you have no days left");
            return null;
        }
        else {
            return permissionsRepository.createPermission(requestPermission);
        }
    }

    @Override
    public Permission getPermissionById(Integer id) {
        return permissionsRepository.getPermissionById(id);
    }

    @Override
    public Permission deletePermission(Integer id) {
        return permissionsRepository.delete(id);
    }

    @Override
    public Permission approvePermission(Integer id) {
        return permissionsRepository.approve(id);
    }

    @Override
    public Permission rejectPermission(Integer id) {
        return permissionsRepository.reject(id);
    }

    @Override
    public List<DepartmentPermissionsDTO> getPermissionsByDepartment(Integer id) {
        return permissionsRepository.getPermissionByDepartment(id);
    }


}
