package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Ivanov", (byte) 25);
        userService.saveUser("Petr", "Petrov", (byte) 30);
        userService.saveUser("Anna", "Smirnova", (byte) 22);
        userService.saveUser("Olga", "Sidorova", (byte) 28);
        List<User> allUsers = userService.getAllUsers();
        allUsers.forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
