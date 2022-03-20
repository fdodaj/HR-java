package service.services;

import entity.Role;
import entity.User;

import java.util.List;

public interface RoleService {

    List<Role> listRoles();

    void addRole(Role role);

    Role deleteRole(Integer id);
}
