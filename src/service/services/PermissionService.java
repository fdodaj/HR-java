package service.services;


import entity.Permission;
import model.DepartmentPermissionsDTO;
import model.PermissionDTO;

import java.time.LocalDate;
import java.util.List;

public interface PermissionService {
    List<Permission> listPermissions();

    Permission createPermission(Permission permission);

    Permission getPermissionById(Integer id);

    Permission deletePermission(Integer id);

    Permission approvePermission(Integer id) throws Exception;

    Permission rejectPermission(Integer id);

    List<DepartmentPermissionsDTO> getPermissionsByDepartment(Integer id);
}
