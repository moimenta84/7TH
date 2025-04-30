package com.juego7th.Utils;

public
class ValidatorUtil {
    private static final String validadorName = "^[A-Za-zÁÉÍÓÚÑáéíóúñ ]{2,}$";
    private static final String validadorEmail = "^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$";
    private static final String validadorPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";;
    private static final boolean validadorObject = false;

    public static boolean isValidEmail(String email) {
        return email != null && email.matches(validadorEmail);
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.matches(validadorPassword);

    }

    public static boolean isName(String name) {
        return name != null && name.matches(validadorName);
    }

    public static boolean isObjectValid(Object obj) {
        return obj != null;
    }
}
