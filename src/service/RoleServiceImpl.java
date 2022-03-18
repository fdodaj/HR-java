package service;

import entity.Role;
import repository.RoleRepository;

public class RoleServiceImpl implements RoleService{
    RoleRepository roleRepository = new RoleRepository();
    @Override
    public void getAllRoles() {
        roleRepository.getAllRoles();
    }

    @Override
    public void addRole(Role role) {
         roleRepository.addRole(role);
    }

    @Override
    public Role deleteRole(Integer id) {
        return roleRepository.delete(id);
    }
}
