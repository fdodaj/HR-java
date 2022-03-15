package main;

import entity.User;
import service.UserServiceImpl;

public class TestQueries {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
//
//        User user = new User();
//        user.setId(5);
//        user.setFirstName("Koli");
//        user.setLastName("Koli");
//        user.setEmail("koli");
//        user.setPassword("koli");
//        user.setPhoneNumber("koli");
//        user.setBirthday(null);
//        user.setAddress("koli");
//        user.setGender("koli");
//        user.setHireDate(null);
//        user.setPaidTimeOff(25);
//        user.setDeleted(false);
//        user.setRole("koli");
//
//        userService.addUser(user);

        userService.deleteUser(1);
    }
}
