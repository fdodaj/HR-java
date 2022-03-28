package main;

import service.DepartmentServiceImpl;
import service.UserServiceImpl;
import service.services.DepartmentService;
import service.services.UserService;

import java.util.Scanner;

import static main.HrApplication.auth;


public class AdminMenu {

    private final UserServiceImpl userService = new UserServiceImpl();

    private AdminMenu(){};
    public static void menu(){

        UserService userService = new UserServiceImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();

        System.out.println("---------------Admin menu---------------");
        char exit;
        do {
            System.out.println("Press 1 to get your details");
            System.out.println("Press 2 to CRUD employeess");
            System.out.println("Press 3 to CRUD roles");
            System.out.println("Press 4 to CRUD holidays ");
            System.out.println("Press 5 to CRUD departmentst");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("you");
                case 2:
                    userService.deleteUser(1);
                    break;
                case 3:
                    System.out.println("CRUD roles");
                    break;
                case 4:
                    System.out.println("CRUD holidays");
                    break;
                case 5:
                    System.out.println("CRUD departments");
//                    departmentService.deleteDepartment(2);
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

