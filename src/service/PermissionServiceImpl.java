package service;

import entity.Permission;
import repository.PermissionsRepository;
import service.services.PermissionService;

import java.util.List;

public class PermissionServiceImpl implements PermissionService {
    PermissionsRepository permissionsRepository = new PermissionsRepository();
    @Override
    public List<Permission> listPermissions() {
        return permissionsRepository.listPermissions();
    }

    @Override
    public Permission createPermission(Permission requestPermission) {
        return permissionsRepository.createPermission(requestPermission);
    }

    @Override
    public Permission getPermissionById(Integer id) {
        return permissionsRepository.getPermissionById(id);
    }

    @Override
    public Permission deletePermission(Integer id) {
        return permissionsRepository.delete(id);
    }
}
