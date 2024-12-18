import java.util.Scanner;

public class InputHelper {
    public static String getNonZeroLenString(Scanner scan, String prompt) {
        String input;
        boolean check = false;

        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if (input.length() != 0) {
                check = true;
            } else {
                System.out.println("You have to enter something, try again.");
            }
        } while (!check);

        return input;
    }

    //prompts the user for input until valid input is received
    /* Error displayed when invalid input and prompted to try again
     * passes a scanner object used for user input
     * pass in a string object used as prompt displayed */
    public static int getInt(Scanner scan, String prompt) {
        int num = 0; //eventually returned to user after validated
        boolean check = false;

        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                check = true;
            } else {
                System.out.println("Invalid input, please try again");
            }
            scan.nextLine();
        } while (!check);

        return num;
    }

    public static int getPositiveNonZeroInt(Scanner scan, String prompt) {
        int num = 0; //eventually returned to user after validated
        boolean check = false;

        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num > 0) {
                    check = true;
                } else {
                    System.out.println("Please enter a positive, non-zero integer.");
                }
            } else {
                System.out.println("Invalid input, please try again");
            }
            scan.nextLine();
        } while (!check);

        return num;
    }

    public static int getRangedInt(Scanner scan, String prompt, int min, int max) {
        int num = 0;
        boolean check = false;

        System.out.println(prompt);
        do {
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num >= min && num <= max) {
                    check = true;
                } else {
                    System.out.println("Input not within the range, please try again.");
                }
            } else {
                System.out.println("Invalid input, please try again.");
            }
            scan.nextLine();
        } while (!check);

        return num;
    }

    public static String getRegExString(Scanner scan, String prompt, String regExPattern) {
        String input;
        boolean check = false;

        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if (input.matches(regExPattern)) {
                check = true;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        } while (!check);

        return input;
    }

    public static double getDouble(Scanner scan, String prompt) {
        double input = 0.0;
        boolean check = false;

        System.out.println(prompt);
        do {
            if (scan.hasNextDouble()) {
                input = scan.nextDouble();
                check = true;
            } else {
                System.out.println("Invalid input, please try again");
            }
            scan.nextLine();
        } while (!check);

        return input;
    }

    public static double getRangedDouble(Scanner scan, String prompt, double min, double max) {
        double num = 0;
        boolean check = false;

        System.out.println(prompt);
        do {
            if (scan.hasNextDouble()) {
                num = scan.nextDouble();
                if (num >= min && num <= max) {
                    check = true;
                } else {
                    System.out.println("Input not within the range, please try again.");
                }
            } else {
                System.out.println("Invalid input, please try again.");
            }
            scan.nextLine();
        } while (!check);

        return num;
    }

    public static boolean getYNConfirm (Scanner scan, String prompt) {
        String input;
        boolean confirm = false;
        boolean check = false;

        System.out.println(prompt);
        do {
            input = scan.nextLine();
            if (input.equalsIgnoreCase("y")) {
                confirm = true;
                System.out.println(confirm);
                check = true;
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println(confirm);
                check = true;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        } while (!check);

        return confirm;
    }
}