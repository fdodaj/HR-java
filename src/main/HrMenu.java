package main;

import service.UserServiceImpl;

import java.util.Scanner;

import static main.HrApplication.auth;


public class HrMenu {

    private final UserServiceImpl userService = new UserServiceImpl();

    private HrMenu(){};
    public static void menu(){

        System.out.println("---------------HR menu---------------");
        char exit;
        do {
            System.out.println("Press 1 to view your details");
            System.out.println("Press 2 to view all department leaders employees requests");
            System.out.println("Press 3 to Approve or Reject requests ");

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

