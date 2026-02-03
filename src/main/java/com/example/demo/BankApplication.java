package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.Scanner;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "0000";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Scanner scanner = new Scanner(System.in)) {
            while(true) {
                System.out.println("""
                    Menu
                    Choose an action for Customer
                    1 = Read
                    2 = Write
                    3 = Delete
                    4 = Update
                    5 = Exit
                    """);

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1 -> {
                        Statement statement = connection.createStatement();
                        ResultSet rs = statement.executeQuery("select * from customer");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getLong("customer_id") + " " +
                                            rs.getString("name") + " " +
                                            rs.getString("surname") + " " +
                                            rs.getLong("bank_id")
                            );
                        }
                    }

                    case 2 -> {
                        System.out.println("Enter Name:");
                        String name = scanner.nextLine();

                        System.out.println("Enter Surname:");
                        String surname = scanner.nextLine();

                        System.out.println("Enter Bank ID:");
                        int bankId = Integer.parseInt(scanner.nextLine());

                        String sql = "insert into customer(name, surname, bank_id) values (?, ?, ?)";
                        PreparedStatement ps = connection.prepareStatement(sql);
                        ps.setString(1, name);
                        ps.setString(2, surname);
                        ps.setInt(3, bankId);
                        ps.executeUpdate();

                        System.out.println("Customer added successfully");
                    }

                    case 3 -> {
                        System.out.println("Enter customer_id to delete:");
                        int id = Integer.parseInt(scanner.nextLine());

                        String sql = "delete from customer where customer_id = ?";
                        PreparedStatement ps = connection.prepareStatement(sql);
                        ps.setInt(1, id);
                        ps.executeUpdate();

                        System.out.println("Customer deleted");
                    }

                    case 4 -> {
                        System.out.println("Enter customer_id:");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter new name:");
                        String name = scanner.nextLine();

                        String sql = "update customer set name = ? where customer_id = ?";
                        PreparedStatement ps = connection.prepareStatement(sql);
                        ps.setString(1, name);
                        ps.setInt(2, id);
                        ps.executeUpdate();

                        System.out.println("Customer updated");
                    }

                    case 5 -> {
                        System.out.println("Program ended");
                        return;
                    }

                    default -> System.out.println("Invalid input");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
