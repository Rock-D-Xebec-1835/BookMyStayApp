package com.bookmystayapp.service;

import java.util.regex.Pattern;

public final class ValidationService{

    private ValidationService() {
        // Prevent instantiation
    }

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern STRONG_PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$");

    public static boolean isValidEmail(String email) {

        if (email == null || email.isBlank()) {
            return false;
        }

        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isStrongPassword(String password) {

        if (password == null || password.isBlank()) {
            return false;
        }

        return STRONG_PASSWORD_PATTERN.matcher(password).matches();
    }
}