package service.services;


import entity.Department;
import entity.RequestPermission;

import java.util.List;

public interface PermissionService {
    List<RequestPermission> listPermissions();

    RequestPermission createPermission(RequestPermission requestPermission);

    RequestPermission getPermissionById(Integer id);

    RequestPermission deletePermission(Integer id);
}
