package main;
import entity.Permission;
import service.PermissionServiceImpl;
import service.UserServiceImpl;

import java.sql.Date;
import java.util.Scanner;
import static main.HrApplication.auth;
import service.services.PermissionService;

public class DepartmentLeaderMenu {
    public static final Scanner SCANNER = new Scanner(System.in);
    private DepartmentLeaderMenu(){};

    public static void menu(){
        PermissionService permissionService = new PermissionServiceImpl();
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
                    System.out.println("View all employees of your department");
                    break;
                case 3:
                    System.out.println("View all requests of your employees");
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

