package main;

import entity.*;
import repository.RoleRepository;
import service.*;
import service.services.DepartmentService;
import service.services.PermissionService;
import service.services.RoleService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestQueries {
    public static void main(String[] args) throws ParseException {
        UserServiceImpl userService = new UserServiceImpl();
        HolidayServicesImpl holidayService = new HolidayServicesImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();
        RoleService roleService = new RoleServiceImpl();
        PermissionService permissionService = new PermissionServiceImpl();




//        permissionService.createPermission(permission);



//        System.out.println(userService.listUsers().toString());
//        System.out.println(holidayService.listHolidays().toString());
//        System.out.println(departmentService.listDepartments().toString());
//        System.out.println(roleService.listRoles().toString());
//        System.out.println(permissionService.listPermissions().toString());

//        System.out.println(userService.getMinimalData(3));
//        System.out.println(userService.getUserPerm(1));
//        permissionService.approvePermission(3);
//        System.out.println(userService.getUserByDepartment(4));


        System.out.println(permissionService.getPermissionsByDepartment(2));
    }

}