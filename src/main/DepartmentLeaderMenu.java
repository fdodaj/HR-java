package main;
import entity.Permission;
import service.DepartmentServiceImpl;
import service.PermissionServiceImpl;
import service.UserServiceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import static main.HrApplication.SCANNER;
import static main.HrApplication.auth;

import service.services.DepartmentService;
import service.services.PermissionService;

public class DepartmentLeaderMenu {
    private DepartmentLeaderMenu(){};

    public static void menu(){
        PermissionService permissionService = new PermissionServiceImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        System.out.println("---------------Department leader menu---------------");
        char exit;
        do {
            System.out.println("Press 1 to view your details");
            System.out.println("Press 2 to view all employees of your department");
            System.out.println("Press 3 to view all your department employees requests");
            System.out.println("Press 4 to approve a request ");
            System.out.println("Press 5 to  reject a request ");
            System.out.println("Press 6 to make a request");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println(userService.getUserById(auth.getId()));
                case 2:
                    System.out.println("All users of " + departmentService.getDepartmentName(auth.getDepartmentId()).printName() + " department");
                    System.out.println(userService.getUserByDepartment(auth.getDepartmentId()));
                    break;
                case 3:
                    System.out.println("All permissions of " + departmentService.getDepartmentName(auth.getDepartmentId()).printName() + " employees");
                    System.out.println(permissionService.getPermissionsByDepartment(auth.getDepartmentId()));
                    break;
                case 4:
                    System.out.println("Enter the permission id you want to Approve");
                    int id = SCANNER.nextInt();
                    permissionService.approvePermission(id);
                    break;
                case 5:
                    System.out.println("Enter the permission id you want to Reject");
                    int Id = SCANNER.nextInt();
                    permissionService.rejectPermission(Id);
                case 6:
                    Permission permission = new Permission();
                    System.out.println("Enter starting date(YYYY-MM-DD)");
                    String startDate = SCANNER.nextLine();
                    permission.setFromDate(LocalDate.parse(startDate));
                    System.out.println("Enter ending date(YYYY-MM-DD)");
                    String endDate = SCANNER.nextLine();
                    permission.setToDate(LocalDate.parse(endDate));
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

