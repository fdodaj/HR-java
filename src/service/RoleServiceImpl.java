package service;

import entity.Role;
import repository.RoleRepository;
import service.services.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository = new RoleRepository();
    @Override
    public List<Role> listRoles() {
       return roleRepository.listRoles();
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
