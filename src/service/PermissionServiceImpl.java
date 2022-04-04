package service;

import entity.Holiday;
import entity.Permission;
import entity.User;
import main.DepartmentLeaderMenu;
import main.EmployeeMenu;
import main.HrApplication;
import model.DepartmentPermissionsDTO;
import model.PermissionDTO;
import repository.PermissionsRepository;
import repository.UserRepository;
import service.services.HolidayService;
import service.services.PermissionService;


import static main.HrApplication.auth;



import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PermissionServiceImpl implements PermissionService {
    Permission permission = new Permission();
    UserServiceImpl userService = new UserServiceImpl();
    User user = new User();
    PermissionsRepository permissionsRepository = new PermissionsRepository();
    UserRepository userRepository = new UserRepository();


    @Override
    public List<Permission> listPermissions() {
        return permissionsRepository.listPermissions();
    }


    @Override
    public Permission createPermission(Permission requestPermission) {

        if (auth.getPto() > getBusinessDays(requestPermission.getFromDate(), requestPermission.getToDate())) {
            System.out.println("You dont have enough PTO");
            System.out.println("your request has " + getBusinessDays(requestPermission.getFromDate(), requestPermission.getToDate())+ " business days");
            System.out.println("Remaining PTOs: " + auth.getPto());

            return null;
        }
        else
            return permissionsRepository.createPermission(requestPermission);
    }

    @Override
    public Permission getPermissionById(Integer id) {
        if (permissionsRepository.getPermissionById(id).getDeleted() == false){
            System.out.println("Permission is deleted");
            return null;
        }
        else {
            return permissionsRepository.getPermissionById(id);
        }
    }

    @Override
    public Permission deletePermission(Integer id) {
        return permissionsRepository.delete(id);
    }

    @Override
    public Permission approvePermission(Integer id) throws Exception {
        if (!permissionsRepository.getPermissionById(id).getDeleted() && Objects.equals(permissionsRepository.getPermissionById(id).getPermissionStatus(), "Pending")){
            int userId = permissionsRepository.getPermissionById(id).getUser_id();
            int businessDays = userRepository.getUserById(userId).getPaidTimeOff() - permissionsRepository.getPermissionById(id).getBusinessDays();
            user.setId(userId);
            user.setPaidTimeOff(businessDays);
            userService.updateUserPTO(user);
            return permissionsRepository.approve(id);
        }
        else {
            System.out.println("Permission is deleted or already approved");
            return null;
        }
    }

    @Override
    public Permission rejectPermission(Integer id) {
        if (!permissionsRepository.getPermissionById(id).getDeleted())
             return permissionsRepository.reject(id);
        else {
            System.out.println("The permission has been deleted");
            return  null;
        }
    }
    @Override
    public List<DepartmentPermissionsDTO> getPermissionsByDepartment(Integer id) {
        if (!permissionsRepository.getPermissionById(id).getDeleted())
        return permissionsRepository.getPermissionByDepartment(id);
        else {
            System.out.println("The permission has been deleted");
            return null;
        }

    }


    private int getBusinessDays(LocalDate from, LocalDate to) {
        int businessDays = 0;
        for (LocalDate date = from; date.isBefore(to); date = date.plusDays(1)) {
            if (!(isWeekendDay(date) || isHoliday(date))) {
                businessDays++;
            }
        }
        return businessDays;
    }

    private boolean isWeekendDay(LocalDate date) {
        return (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
    }

    private boolean isHoliday(LocalDate date) {
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
