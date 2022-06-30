package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    private static final UserServiceImpl userService = new UserServiceImpl();


    public static void main(String[] args) throws SQLException {
        userService.createUsersTable();
        userService.saveUser("Николай", "Иванов", (byte) 48);
        userService.saveUser("Петр", "Петров", (byte) 78);
        userService.saveUser("Владимир", "Ленин", (byte) 34);
        userService.saveUser("Александр", "Пушкин", (byte) 23);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
