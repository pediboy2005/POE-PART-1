/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.myproject;

import java.util.Scanner;

public class MyProject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       // created my object
        Login login = new Login();

        String username, password, phone, firstname, lastname;

        System.out.println("--- Registration ---");

        System.out.print("Enter Your First Name: ");
        firstname = input.nextLine();

        System.out.print("Enter Your Last Name: ");
        lastname = input.nextLine();

        // Username loop
        do {
            System.out.print("Enter Your Username (must have '_' and be max 5 chars): ");
            username = input.nextLine();

            if (!login.checkUserName(username)) {
                System.out.println("Username is not correctly formatted; please ensure it contains an underscore and is no more than five characters.");
            }
        } while (!login.checkUserName(username));

        // Password loop
        do {
            System.out.print("Enter Your Password (8+ chars, Capital, Number, Special): ");
            password = input.nextLine();

            if (!login.checkPasswordComplexity(password)) {
                System.out.println("Password is not correctly formatted; please ensure it contains 8 characters,capital letter,number and special character rules.");
            }
        } while (!login.checkPasswordComplexity(password));

        // Phone loop
        do {
            System.out.print("Enter Your Cell Phone (starting with +27): ");
            phone = input.nextLine();

            if (!login.checkCellphoneNumber(phone)) {
                System.out.println("Your Cell phone number is incorrectly formatted or does not contain international code.");
            }
        } while (!login.checkCellphoneNumber(phone));

        // Register user
        login.registerUser(username, password, firstname, lastname);

        System.out.println("\nRegistration Complete! Proceed to Login.");

        // ✅ LOGIN LOOP (keeps asking until correct)
        boolean success = false;

        while (!success) {
            System.out.println("\n--- Login ---");

            System.out.print("Username: ");
            String lUser = input.nextLine();

            System.out.print("Password: ");
            String lPass = input.nextLine();

            success = login.loginUser(lUser, lPass);

            System.out.println(login.returnLoginStatus(success));
        }

        System.out.println("Login successful. Program ends.");
    }
}