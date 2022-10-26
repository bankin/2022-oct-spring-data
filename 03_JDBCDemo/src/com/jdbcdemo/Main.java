package com.jdbcdemo;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter username default (root): ");
//        String user = sc.nextLine();
//        user = user.equals("") ? "root" : user;
//        System.out.println();
//
//        System.out.print("Enter password default (empty):");
//        String password = sc.nextLine().trim();
//        System.out.println();

        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "12345");

        Connection connection = DriverManager
            .getConnection("jdbc:mysql://127.0.0.1:3306/soft_uni", props);


        PreparedStatement stmt =
            connection.prepareStatement("SELECT first_name, department_id " +
                    "FROM employees WHERE first_name = ?");


        String name = sc.nextLine();
        String formatSQL = String.format("SELECT first_name, department_id " +
                "FROM employees WHERE first_name = '%s'", name);

        PreparedStatement stmt1 =
            connection.prepareStatement(formatSQL);

//        String salary = sc.nextLine();
//        stmt.setDouble(1, Double.parseDouble(salary));
        stmt.setString(1, name);

        System.out.println(stmt);
        System.out.println(stmt1);


//        ResultSet rs = stmt1.executeQuery();

//        while (rs.next()) {
//            System.out.println(rs.getString("first_name") + " " +
//                rs.getInt("department_id"));
//        }

        connection.close();
    }
}