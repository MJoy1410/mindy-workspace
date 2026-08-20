package utils;

import java.util.Scanner;

public final class Inputter {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Inputter() {
    }

    public static String getNonEmptyString(String message) {
        while (true) {
            System.out.print(message);
            String value = SCANNER.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty!");
        }
    }

    public static String getOptionalString(String message) {
        System.out.print(message);
        return SCANNER.nextLine().trim();
    }

    public static double getDouble(String message, double min, boolean allowEqualMin) {
        while (true) {
            String input = getOptionalString(message);
            try {
                double value = Double.parseDouble(input);
                if (isValidDouble(value, min, allowEqualMin)) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println(allowEqualMin
                    ? "Value must be greater than or equal to " + min + "!"
                    : "Value must be greater than " + min + "!");
        }
    }

    public static Double getOptionalDouble(String message, double min, boolean allowEqualMin) {
        while (true) {
            String input = getOptionalString(message);
            if (input.isEmpty()) {
                return null;
            }
            try {
                double value = Double.parseDouble(input);
                if (isValidDouble(value, min, allowEqualMin)) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println(allowEqualMin
                    ? "Value must be greater than or equal to " + min + "!"
                    : "Value must be greater than " + min + "!");
        }
    }

    public static int getInt(String message, int min, int max) {
        while (true) {
            String input = getOptionalString(message);
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.printf("Value must be an integer from %d to %d!%n", min, max);
        }
    }

    public static Integer getOptionalInt(String message, int min, int max) {
        while (true) {
            String input = getOptionalString(message);
            if (input.isEmpty()) {
                return null;
            }
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.printf("Value must be an integer from %d to %d!%n", min, max);
        }
    }

    private static boolean isValidDouble(double value, double min, boolean allowEqualMin) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            return false;
        }
        return allowEqualMin ? value >= min : value > min;
    }

    public static String getRole(String message) {
        while (true) {
            String role = getNonEmptyString(message);
            String normalized = normalizeRole(role);
            if (normalized != null) {
                return normalized;
            }
            System.out.println("Role must be Developer, Tester, Manager, or HR!");
        }
    }

    public static String getOptionalRole(String message) {
        while (true) {
            String role = getOptionalString(message);
            if (role.isEmpty()) {
                return null;
            }
            String normalized = normalizeRole(role);
            if (normalized != null) {
                return normalized;
            }
            System.out.println("Role must be Developer, Tester, Manager, or HR!");
        }
    }

    public static String getStatus(String message) {
        while (true) {
            String status = getNonEmptyString(message);
            String normalized = normalizeStatus(status);
            if (normalized != null) {
                return normalized;
            }
            System.out.println("Status must be active or inactive!");
        }
    }

    public static String getOptionalStatus(String message) {
        while (true) {
            String status = getOptionalString(message);
            if (status.isEmpty()) {
                return null;
            }
            String normalized = normalizeStatus(status);
            if (normalized != null) {
                return normalized;
            }
            System.out.println("Status must be active or inactive!");
        }
    }

    public static String normalizeRole(String role) {
        if (role == null) {
            return null;
        }
        if (role.equalsIgnoreCase("Developer")) {
            return "Developer";
        }
        if (role.equalsIgnoreCase("Tester")) {
            return "Tester";
        }
        if (role.equalsIgnoreCase("Manager")) {
            return "Manager";
        }
        if (role.equalsIgnoreCase("HR")) {
            return "HR";
        }
        return null;
    }

    public static String normalizeStatus(String status) {
        if (status == null) {
            return null;
        }
        if (status.equalsIgnoreCase("active")) {
            return "active";
        }
        if (status.equalsIgnoreCase("inactive")) {
            return "inactive";
        }
        return null;
    }

    public static boolean confirm(String message) {
        while (true) {
            String answer = getNonEmptyString(message).toUpperCase();
            if ("Y".equals(answer)) {
                return true;
            }
            if ("N".equals(answer)) {
                return false;
            }
            System.out.println("Please enter Y or N!");
        }
    }
}
