import java.util.Scanner;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {
       
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        String specialChars = "~!@#$%^&*()-=+_";

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.indexOf(c) != -1) {
                hasSpecialChar = true;
            }
        }

        int categoryCount = 0;
        if (hasLowerCase) categoryCount++;
        if (hasUpperCase) categoryCount++;
        if (hasDigit) categoryCount++;
        if (hasSpecialChar) categoryCount++;

        return categoryCount >= 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password to validate: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("The password is valid.");
        } else {
            System.out.println("The password is invalid.");
        }

        scanner.close();
    }
}
