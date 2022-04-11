package main;

import entity.User;
import service.UserServiceImpl;

import java.util.Scanner;

import static main.HrApplication.auth;


public class HrMenu {

    private static UserServiceImpl userService = new UserServiceImpl();

    private HrMenu(){};
    public static void menu(){

        System.out.println("---------------HR menu---------------");
        char exit;
        do {
            System.out.println("Press 1 to view your details");
            System.out.println("Press 2 to view all department leaders  requests");
            System.out.println("Press 3 to Approve or Reject requests ");
            System.out.println("Press 5 to register a user");

            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("your details");
                case 2:
                    System.out.println("View all DP requests");

                    break;
                case 3:
                    System.out.println("Approve or reject PD requests");
                    break;
                case 4:
                    User user = new User();
                    user.setFirstName("first name");
                    user.setLastName("last name");
                    user.setEmail("email");
                    user.setPassword("password");
                    user.setBirthday(null);
                    user.setGender("male");
                    user.setHireDate(null);
                    user.setPaidTimeOff(50);
                    user.setDeleted(false);
                    user.setRole_id(1);
                    user.setDepartment_id(2);
                    userService.addUser(user);
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

