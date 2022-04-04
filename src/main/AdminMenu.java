package main;

import service.DepartmentServiceImpl;
import service.HolidayServicesImpl;
import service.UserServiceImpl;
import service.services.DepartmentService;
import service.services.HolidayService;
import service.services.UserService;

import java.util.Scanner;

import static main.HrApplication.auth;


public class AdminMenu {

    private final UserServiceImpl userService = new UserServiceImpl();

    private AdminMenu(){};
    public static void menu(){

        UserService userService = new UserServiceImpl();
        HolidayService holidayService = new HolidayServicesImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();

        System.out.println("---------------Admin menu---------------");
        char exit;
        do {
            System.out.println("Press 1 to get your details");
            System.out.println("Press 2 to delete a user");
            System.out.println("Press 3 to delete a user");
            System.out.println("Press 4 to get all holidays");
            System.out.println("Press 5 to delete a holiday");
            System.out.println("Press 6 to get all departments");
            System.out.println("Press 7 to delete department ");
            System.out.println("Press 8 to get department by id ");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
                    userService.getUserById(auth.getId());
                case 2:
                    System.out.println("Enter the users id you want to delete");
                    int deleteUserId =  sc.nextInt();
                    userService.deleteUser(deleteUserId);
                    break;
                case 3:
                    System.out.println("Enter the users id");
                    int getUserById = sc.nextInt();
                    userService.getUserById(getUserById);
                    break;
                case 4:
                    System.out.println("get all holidays");
                    holidayService.listHolidays();
                    break;
                case 5:
                    System.out.println("delete holiday: enter id");
                    int deleteHolidayId = sc.nextInt();
                    holidayService.deleteHoliday(deleteHolidayId);
                    break;
                case 6:
                    System.out.println("Get all departments");
                    departmentService.listDepartments();
                case 7:
                    System.out.println("enter id  department to delete ");
                    int deleteDepartmentId = sc.nextInt();
                    departmentService.deleteDepartment(deleteDepartmentId);

                case 8:
                    System.out.println("enter id  department get ");
                    int getDepartmentId = sc.nextInt();
                    departmentService.getDepartmentById(getDepartmentId);
                    // TO-DO
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

