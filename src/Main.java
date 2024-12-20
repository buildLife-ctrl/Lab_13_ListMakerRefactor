import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.valueOf;
import static java.nio.file.Files.delete;
import static sun.misc.Version.print;

public class Main {
    static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean needsToBeSaved = false;
        boolean file = false;
        String openedFile = "";
        String name = "";
        boolean quit = false;

        do {
            System.out.println(); //makes it look better
            System.out.println("Options:");
            System.out.println("A - Add an item to the list");
            System.out.println("D – Delete an item from the list");
            System.out.println("V – View the list");
            System.out.println("Q – Quit the program");
            System.out.println("O – Open a list file from PC");
            System.out.println("S – Save the current list file to PC");
            System.out.println("C – Clear removes all the elements from the current list");
            System.out.println(); //for better structure
            String ask = InputHelper.getRegExString(scan, "Please pick one of the options above:", "[AaDdVvQqOoSsCc]");

            System.out.println(); //for better structure
            if (ask.equalsIgnoreCase("a")) {
                add(scan, list);
                needsToBeSaved = true;
                System.out.println("Value added!");
            } else if (ask.equalsIgnoreCase("d")) {
                delete(scan, list);
                needsToBeSaved = true;
                System.out.println("Value deleted!");
            } else if (ask.equalsIgnoreCase("v")) {
                if (list.isEmpty()) {
                    System.out.println("You have not selected any list. Please try again.");
                } else {
                    displayList(list);
                }
            } else if (ask.equalsIgnoreCase("O")) {
                openedFile = IOHelper.openFile(list);
                System.out.println(openedFile);
            } else if (ask.equalsIgnoreCase("q")) {
                quit = quit(scan, "Are you sure you want to quit? [Y/N]");
            } else if (ask.equalsIgnoreCase("s")) {
                if (needsToBeSaved) {
                    file = InputHelper.getYNConfirm(scan, "Are you working with a loaded file? [Y/N]");
                    if (!file) {
                        name = InputHelper.getNonZeroLenString(scan, "What would you like to name your file?");
                    } else {
                        name = openedFile;
                    }
                    IOHelper.writeFile(list, name);
                    System.out.println("File saved!");
                } else {
                    System.out.println("There is no file you need to save.");
                }
            } else {
                list.clear();
                needsToBeSaved = true;
                System.out.println("File cleared!");
            }
        } while (!quit);
    }

    public static void add(Scanner scan, ArrayList<String> list) {
        String userInput = InputHelper.getNonZeroLenString(scan, "What would you like to add?");
        String i = valueOf(userInput.charAt(0));
        userInput = i.toUpperCase() + userInput.substring(1);
        list.add(userInput);
    }

    private static void delete(Scanner scan, ArrayList<String> list) {
        int userInput = InputHelper.getRangedInt(scan, "Which array list value would you like to remove?" +
                "[0-" + (list.size() - 1) + "]", 0, list.size() - 1);
        list.remove(userInput);
    }

    public static boolean quit (Scanner scan, String prompt) {
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

    public static void displayList(ArrayList<String> list) { //10 fruits that I came up with as letters increment
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("\n%-2s %3s", i, " - ");
            System.out.printf((String) list.get(i));
        }
        System.out.println();
    }
}
