package main;

import java.util.Scanner;

public final class UserMenu {

    private UserMenu() {
    }

    public static void menu() {
        System.out.println("User menu");
        char exit;
        do {
            System.out.println("1) My details");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println("User details");
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
