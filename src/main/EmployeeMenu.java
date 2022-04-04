package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import static main.HrApplication.SCANNER;
import static main.HrApplication.auth;

import entity.Holiday;
import entity.Permission;
import service.HolidayServicesImpl;
import service.PermissionServiceImpl;
import service.UserServiceImpl;

import service.services.HolidayService;
import service.services.PermissionService;

public final class EmployeeMenu {

    private EmployeeMenu() {
    }

    public static void menu() throws ParseException {
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println("---------------Employee menu---------------");
        char exit;

        do {
            System.out.println("Press 1 to view your details");
            System.out.println("Press 2 to make a request");
            System.out.println("Press 3 to views your requests");
            System.out.println("Press 4 to view all employees of your department");
            Scanner sc = new Scanner(System.in);
            int menuItem = sc.nextInt();
            switch (menuItem) {
                case 1:
                    System.out.println(userService.getUserById(auth.getId()));
                    break;
                case 2:
                    PermissionService permissionService = new PermissionServiceImpl();

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
                    permission.setBusinessDays(getBusinessDays(LocalDate.parse(startDate), LocalDate.parse(endDate)));
                    permission.setPermissionStatus("Pending");
                    permission.setDeleted(false);
                    int userId = auth.getId();
                    permission.setUser_id(userId);
                    permissionService.createPermission(permission);

                    break;
                case 3:
                    System.out.println("your requests");
                    System.out.println(userService.getUserPerm(auth.getId()));
                    break;
                case 4:
                    System.out.println(userService.getUserByDepartment(auth.getDepartmentId()));
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

    private static int getBusinessDays(LocalDate from, LocalDate to) {
        int businessDays = 0;
        for (LocalDate date = from; date.isBefore(to); date = date.plusDays(1)) {
            if (!(isWeekendDay(date) || isHoliday(date))) {
                businessDays++;
            }
        }
        return businessDays;
    }

    private static boolean isWeekendDay(LocalDate date) {
        return (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
    }

    private static boolean isHoliday(LocalDate date) {
        HolidayService holidayService = new HolidayServicesImpl();
        int counter = 0;
        for (Holiday holiday : holidayService.listHolidays()) {
            if (holiday.getDate().equals(date)) {
                counter++;
            }
        }
        return counter > 0;
    }

}
