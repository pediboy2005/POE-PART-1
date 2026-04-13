/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login = new Login();

    // ================= USERNAME TESTS =================
    @Test
    void testValidUsername() {
        assertTrue(login.checkUserName("ab_cd"));
    }

    @Test
    void testUsernameNoUnderscore() {
        assertFalse(login.checkUserName("abcd"));
    }

    @Test
    void testUsernameTooLong() {
        assertFalse(login.checkUserName("abcdef_"));
    }

    // ================= PASSWORD TESTS =================
    @Test
    void testValidPassword() {
        assertTrue(login.checkPasswordComplexity("Abcdef1!"));
    }

    @Test
    void testPasswordNoCapital() {
        assertFalse(login.checkPasswordComplexity("abcdef1!"));
    }

    @Test
    void testPasswordNoNumber() {
        assertFalse(login.checkPasswordComplexity("Abcdefg!"));
    }

    @Test
    void testPasswordNoSpecialChar() {
        assertFalse(login.checkPasswordComplexity("Abcdef12"));
    }

    @Test
    void testPasswordTooShort() {
        assertFalse(login.checkPasswordComplexity("Ab1!"));
    }

    // ================= PHONE TESTS =================
    @Test
    void testValidPhoneNumber() {
        assertTrue(login.checkCellphoneNumber("+27831234567"));
    }

    @Test
    void testPhoneMissingCountryCode() {
        assertFalse(login.checkCellphoneNumber("0831234567"));
    }

    @Test
    void testPhoneTooShort() {
        assertFalse(login.checkCellphoneNumber("+27123"));
    }

    // ================= REGISTER & LOGIN TESTS =================
    @Test
    void testSuccessfulLogin() {
        login.registerUser("ab_cd", "Abcdef1!", "John", "Doe");
        assertTrue(login.loginUser("ab_cd", "Abcdef1!"));
    }

    @Test
    void testLoginWrongPassword() {
        login.registerUser("ab_cd", "Abcdef1!", "John", "Doe");
        assertFalse(login.loginUser("ab_cd", "wrongPass"));
    }

    @Test
    void testLoginWrongUsername() {
        login.registerUser("ab_cd", "Abcdef1!", "John", "Doe");
        assertFalse(login.loginUser("wrong", "Abcdef1!"));
    }

    // ================= LOGIN STATUS TEST =================
    @Test
    void testLoginStatusSuccessMessage() {
        login.registerUser("ab_cd", "Abcdef1!", "John", "Doe");
        String message = login.returnLoginStatus(true);
        assertTrue(message.contains("Welcome John Doe"));
    }

    @Test
    void testLoginStatusFailureMessage() {
        String message = login.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", message);
    }
}