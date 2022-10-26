package com.jdbcdemo;

import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Diablo {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/diablo", properties);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        List<String> usernames = List.of(username, "nakov");


        PreparedStatement query = connection.prepareStatement(
                "SELECT user_name, first_name, last_name, " +
                    "(SELECT COUNT(*) FROM users_games WHERE user_id = u.id) AS games_count " +
                "FROM users AS u " +
                "WHERE user_name IN (?)");

        query.setString(1, String.join(",", usernames));

        System.out.println(query);

        ResultSet result = query.executeQuery();

        if (result.next()) {
            String dbUsername = result.getString("user_name");
            String dbFirstName = result.getString("first_name");
            String dbLastName = result.getString("last_name");
            int dbGamesCount = result.getInt("games_count");

            System.out.printf("User: %s%n%s %s has played %d games",
                    dbUsername, dbFirstName, dbLastName, dbGamesCount);
        } else {
            System.out.println("No such user exists");
        }
    }
}
