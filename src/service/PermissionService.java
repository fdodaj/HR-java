package service;


import entity.Department;
import entity.RequestPermission;

public interface PermissionService {
    void listAllPermissions();

    RequestPermission createPermission(RequestPermission requestPermission);

    RequestPermission getPermissionById(Integer id);

    RequestPermission deletePermission(Integer id);
}
