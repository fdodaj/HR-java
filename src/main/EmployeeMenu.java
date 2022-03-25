package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static main.HrApplication.SCANNER;
import static main.HrApplication.auth;

import entity.Permission;
import service.PermissionServiceImpl;
import service.UserServiceImpl;
import service.services.PermissionService;

public final class EmployeeMenu {

    private EmployeeMenu() {
    }

    public static void menu() throws ParseException {
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println("---------------Employee menu---------------");
        char exit;
        do {
            System.out.println("Press 1 to view your details");
            System.out.println("Press 2 to make a request");
            System.out.println("Press 3 to views your requests");
            System.out.println("Press 4 to view all employees of your department");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println(userService.getUserById(auth.getId()));
                    break;
                case 2:
                    PermissionService permissionService = new PermissionServiceImpl();

                    Permission permission = new Permission();
                    permission.setId(5);
                    System.out.println("Enter starting date(YYYY-MM-DD)");
                    String startDate = SCANNER.nextLine();
                    permission.setFromDate(java.sql.Date.valueOf(startDate));
                    System.out.println("Enter ending date(YYYY-MM-DD)");
                    String endDate = SCANNER.nextLine();
                    permission.setToDate(java.sql.Date.valueOf(endDate));
                    System.out.println("Why are you taking this permission");
                    String reason = SCANNER.nextLine();
                    permission.setReason(reason);
                    permission.setBusinessDays(2);
                    permission.setPermissionStatus("Pending");
                    permission.setDeleted(false);
                    int userId = auth.getId();
                    permission.setUser_id(userId);
                    permissionService.createPermission(permission);

                    break;
                case 3:
                    System.out.println("your requests");
                    System.out.println(userService.getUserPerm(auth.getId()));
                    break;
                case 4:
                    System.out.println(userService.getUserByDepartment(auth.getDepartmentId()));
                    break;
                default:
                    System.out.println("Didn't understand that");
                    break;
            }
            System.out.println("Press Q to logout or any other key to continue");
            sc.nextLine();
            exit = sc.nextLine().charAt(0);
        } while (exit != 'Q');
    }
}
