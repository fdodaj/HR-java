package service;

import entity.Role;
import entity.User;

public interface RoleService {

    void getAllRoles();

    void addRole(Role role);

    Role deleteRole(Integer id);
}
