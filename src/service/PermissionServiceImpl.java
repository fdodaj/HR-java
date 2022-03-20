package service;

import entity.RequestPermission;
import repository.PermissionsRepository;
import service.services.PermissionService;

import java.util.List;

public class PermissionServiceImpl implements PermissionService {
    PermissionsRepository permissionsRepository = new PermissionsRepository();
    @Override
    public List<RequestPermission> listPermissions() {
        return permissionsRepository.listPermissions();
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
