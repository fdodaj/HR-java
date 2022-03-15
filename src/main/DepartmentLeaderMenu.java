package main;

import entity.User;
import service.UserService;
import service.UserServiceImpl;

import java.util.Scanner;

import static main.HrApplication.auth;
import static main.HrApplication.SCANNER;


public class DepartmentLeaderMenu {

    private final UserServiceImpl userService = new UserServiceImpl();

    private DepartmentLeaderMenu(){};
    public static void menu(){

        System.out.println("---------------Department leader menu---------------");
        char exit;
        do {
            System.out.println("Press 1 to view your details");
            System.out.println("Press 2 to view all employees");
            System.out.println("Press 3 to view all requests");
            System.out.println("Press 4 register new user");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:

                    String role = auth.getRole();;

//                    System.out.println(user.toString());
                    break;
                case 2:
                    System.out.println("View all employees");
                    break;
                case 3:
                    System.out.println("View all requests");
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

//    private  getUserById(){
//        User user = new User();
//        return getUserById(auth.getId());
//    }
}

