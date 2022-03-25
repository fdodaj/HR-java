package service.services;


import entity.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> listPermissions();

    Permission createPermission(Permission permission);

    Permission getPermissionById(Integer id);

    Permission deletePermission(Integer id);

    Permission approvePermission(Integer id);

    Permission rejectPermission(Integer id);
}
