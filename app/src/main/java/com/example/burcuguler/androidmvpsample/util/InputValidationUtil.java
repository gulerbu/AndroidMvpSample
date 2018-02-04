package com.example.burcuguler.androidmvpsample.util;

import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by burcuguler on 18/12/2017.
 */

public final class InputValidationUtil {

    public static boolean isValidName(String name) {
        return Pattern.matches("[a-zA-Z]+", name);

    }

    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }
}
