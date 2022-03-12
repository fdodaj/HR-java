package main;

import java.util.Scanner;

public class DeparmentLeaderMenu {
    private DeparmentLeaderMenu(){};
    public static void menu(){
        System.out.println("Department leader menu: ");
        char exit;
        do {
            System.out.println("1) Register new user");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("User details");
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
}

