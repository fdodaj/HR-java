package main;

import entity.*;
import service.*;
import service.services.DepartmentService;
import service.services.HolidayService;
import service.services.PermissionService;
import service.services.RoleService;


import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

public class TestQueries {
    public static void main(String[] args) throws ParseException {
        UserServiceImpl userService = new UserServiceImpl();
        HolidayService holidayService = new HolidayServicesImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();
        RoleService roleService = new RoleServiceImpl();
        PermissionService permissionService = new PermissionServiceImpl();

        Holiday holiday = new Holiday();
        User user = new User();


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
//        String startDate = "2020-02-02";
//        System.out.println(getDayNumberNew(LocalDate.of(2022, 03, 29)));
////        System.out.println(c);


    }
    public static int getBussinessDays(LocalDate from, LocalDate to) {
        int businessDays = 0;
        for (LocalDate date = from; date.isBefore(to); date = date.plusDays(1)) {
            if (!(isWeekendDay(date) || isHoliday(date))) {
                businessDays++;
            }
        }
        return businessDays;
    }

    private static boolean isWeekendDay(LocalDate date) {
        return (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
    }

    private static boolean isHoliday(LocalDate date) {
        HolidayService holidayService = new HolidayServicesImpl();
        int counter = 0;
        for (Holiday holiday : holidayService.listHolidays()) {
            if (holiday.getDate().equals(date)) {
                counter++;
            }
        }
        return counter > 0;
    }



}