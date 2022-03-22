package main;

import entity.AuthenticatedUser;
import service.HrAuthException;
import service.UserServiceImpl;

import java.util.Objects;
import java.util.Scanner;

public class HrApplication {


    public final static Scanner SCANNER = new Scanner(System.in);

    public static String exit = "N";

    public static AuthenticatedUser auth;

    public static void main(String[] args) {

        System.out.println("Welcome to HR system");

        auth = authenticateUser();

        RoleEnum role = RoleEnum.getById(auth.getRole());

        do {
            switch (Objects.requireNonNull(role)) {
                case HR:
                    // HR menu

                case ADMIN:
                    // ADMIN menu

                case PD:
                    DepartmentLeaderMenu.menu();
                case EMPLOYEE:
                    // TODO employee menu
            }
        } while ("Y".equalsIgnoreCase(exit));

    }

    private static AuthenticatedUser authenticateUser() throws HrAuthException {
        System.out.println("Login in system:");
        System.out.println("Insert E-mail address: ");
        String email = SCANNER.nextLine();
        System.out.println("Insert Password: ");
        String password = SCANNER.nextLine();
        AuthenticatedUser auth = null;
        if (!email.isEmpty() && !password.isEmpty()) {
            UserServiceImpl userService = new UserServiceImpl();
            auth = userService.loginUser(email, password);
        }
        if (Objects.isNull(auth)) throw new HrAuthException("Nuk mund te aksesosh sistemin");
        return auth;
    }


}
