package utils;

import java.util.Scanner;

/**
 * Handles console input and input validation for the application.
 */
public final class Inputter {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CLUB_ID_REGEX = "CL-\\d{4}";
    private static final String PLAYER_ID_REGEX = "P\\d{4}";
    private static final String[] POSITIONS = {
            "Goalkeeper", "Defender", "Midfielder", "Forward", "Winger"
    };

    private Inputter() {
    }

    public static String input(String message) {
        System.out.print(message);
        return SCANNER.nextLine().trim();
    }

    public static String inputNotEmpty(String message) {
        while (true) {
            String value = input(message);
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty!");
        }
    }

    public static String inputClubId(String message) {
        while (true) {
            String id = input(message);
            if (isValidClubId(id)) {
                return id;
            }
            System.out.println("Invalid club ID format! Expected CL-xxxx (e.g., CL-0001).");
        }
    }

    public static String inputPlayerId(String message) {
        while (true) {
            String id = input(message);
            if (isValidPlayerId(id)) {
                return id;
            }
            System.out.println("Invalid player ID format! Expected Pxxxx (e.g., P0001).");
        }
    }

    public static double inputPositiveDouble(String message) {
        while (true) {
            String value = input(message);
            try {
                double number = Double.parseDouble(value);
                if (Double.isFinite(number) && number > 0) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Value must be a positive real number!");
        }
    }

    public static Double inputOptionalPositiveDouble(String message) {
        while (true) {
            String value = input(message);
            if (value.isEmpty()) {
                return null;
            }
            try {
                double number = Double.parseDouble(value);
                if (Double.isFinite(number) && number > 0) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Value must be a positive real number or empty to skip!");
        }
    }

    public static int inputInt(String message, int min, int max) {
        while (true) {
            String value = input(message);
            try {
                int number = Integer.parseInt(value);
                if (number >= min && number <= max) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.printf("Value must be an integer from %d to %d!%n", min, max);
        }
    }

    public static Integer inputOptionalInt(String message, int min, int max) {
        while (true) {
            String value = input(message);
            if (value.isEmpty()) {
                return null;
            }
            try {
                int number = Integer.parseInt(value);
                if (number >= min && number <= max) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.printf("Value must be an integer from %d to %d or empty to skip!%n", min, max);
        }
    }

    public static String inputPosition(String message) {
        while (true) {
            String position = normalizePosition(input(message));
            if (position != null) {
                return position;
            }
            System.out.println("Position must be Goalkeeper, Defender, Midfielder, Forward, or Winger!");
        }
    }

    public static String inputOptionalPosition(String message) {
        while (true) {
            String value = input(message);
            if (value.isEmpty()) {
                return null;
            }
            String position = normalizePosition(value);
            if (position != null) {
                return position;
            }
            System.out.println("Position must be Goalkeeper, Defender, Midfielder, Forward, or Winger, or empty to skip!");
        }
    }

    public static boolean isValidClubId(String id) {
        return id != null && id.matches(CLUB_ID_REGEX);
    }

    public static boolean isValidPlayerId(String id) {
        return id != null && id.matches(PLAYER_ID_REGEX);
    }

    public static String normalizePosition(String value) {
        if (value == null) {
            return null;
        }
        for (String position : POSITIONS) {
            if (position.equalsIgnoreCase(value.trim())) {
                return position;
            }
        }
        return null;
    }
}
