package main;

import entity.*;
import repository.RoleRepository;
import service.*;
import service.services.DepartmentService;
import service.services.PermissionService;
import service.services.RoleService;

public class TestQueries {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        HolidayServicesImpl holidayService = new HolidayServicesImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();
        RoleService roleService = new RoleServiceImpl();
        PermissionService permissionService = new PermissionServiceImpl();


//        System.out.println(userService.listUsers().toString());
//        System.out.println(holidayService.listHolidays().toString());
//        System.out.println(departmentService.listDepartments().toString());
//        System.out.println(roleService.listRoles().toString());
//        System.out.println(permissionService.listPermissions().toString());
    }
}
