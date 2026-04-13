/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myproject;

import java.util.regex.Pattern;

public class Login {
    private String savedUser, savedPass, fName, lName;

    // Username: must contain "_" and be <= 5 chars
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Password: 8+ chars, uppercase, number, special char
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()].*");
    }

    // Cell number: +27 followed by 9 digits
    public boolean checkCellphoneNumber(String num) {
        return Pattern.matches("^\\+27[0-9]{9}$", num);
    }

    // Store user
    public void registerUser(String username, String password, String firstname, String lastname) {
        this.savedUser = username;
        this.savedPass = password;
        this.fName = firstname;
        this.lName = lastname;
    }

    // Check login
    public boolean loginUser(String username, String password) {
        return username.equals(savedUser) && password.equals(savedPass);
    }

    // Login message
    public String returnLoginStatus(boolean loggedIn) {
        if (loggedIn) {
            return "Welcome " + fName + " " + lName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}