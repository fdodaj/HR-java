package service;

import entity.Department;
import entity.RequestPermission;
import repository.PermissionsRepository;

public class PermissionServiceImpl implements PermissionService {
    PermissionsRepository permissionsRepository = new PermissionsRepository();
    @Override
    public void listAllPermissions() {
        permissionsRepository.listAllPermissions();
    }

    @Override
    public RequestPermission createPermission(RequestPermission requestPermission) {
        return permissionsRepository.createPermission(requestPermission);
    }

    @Override
    public RequestPermission getPermissionById(Integer id) {
        return permissionsRepository.getPermissionById(id);
    }

    @Override
    public RequestPermission deletePermission(Integer id) {
        return permissionsRepository.delete(id);
    }
}
