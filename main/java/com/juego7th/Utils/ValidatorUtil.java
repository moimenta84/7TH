package com.juego7th.Utils;

public
class ValidatorUtil {
    private static final String validadorName = "^[A-Za-zÁÉÍÓÚÑáéíóúñ ]{2,}$";
    private static final String validadorEmail = "^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$";
    private static final String validadorPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";;


    public static boolean isValidEmail(String email) {
        return email.matches(validadorEmail);
    }

    public static boolean isValidPassword(String password) {
        return password.matches(validadorPassword);

    }

    public static boolean isName(String Name) {
        return Name.matches(validadorName);
    }
}
