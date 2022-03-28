package service.services;


import entity.Permission;
import model.DepartmentPermissionsDTO;

import java.util.List;

public interface PermissionService {
    List<Permission> listPermissions();

    Permission createPermission(Permission permission);

    Permission getPermissionById(Integer id);

    Permission deletePermission(Integer id);

    Permission approvePermission(Integer id);

    Permission rejectPermission(Integer id);

    List<DepartmentPermissionsDTO> getPermissionsByDepartment(Integer id);


}
