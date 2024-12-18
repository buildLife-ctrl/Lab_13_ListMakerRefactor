import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(10);
        Scanner scan = new Scanner(System.in);

        //do {
            System.out.println(); //makes it look better
            System.out.println("Options:");
            System.out.println("A - Add an item to the list");
            System.out.println("D – Delete an item from the list");
            System.out.println("P – Print the list");
            System.out.println("Q – Quit the program");
            System.out.println("O – Open a list file from PC");
            System.out.println("S – Save the current list file to PC");
            System.out.println("C – Clear removes all the elements from the current list");
            System.out.println(); //for better structure
            String ask = InputHelper.getRegExString(scan, "Please pick one of the options above:", "[AaDdVvQqOoSsCc]");

            System.out.println(); //for better structure
            if (ask.equalsIgnoreCase("a")) {
                boolean file = InputHelper.getYNConfirm(scan, "Are you working with a loaded file? [Y/N]");
                if (file) {
                    IOHelper.writeFile();
                } else {
                    add(scan, list);
                }

                displayList(list);
            }/* else if (ask.equalsIgnoreCase("d")) {
                delete(scan);
            } else if (ask.equalsIgnoreCase("p")) {
                print();
            } else {
                quit = quit(scan, "Are you sure you want to quit? [Y/N]");
            }
        } while (!quit);*/
    }

    public static void add(Scanner scan, ArrayList list) {
        String userInput = InputHelper.getNonZeroLenString(scan, "What would you like to add?");
        String i = valueOf(userInput.charAt(0));
        userInput = i.toUpperCase() + userInput.substring(1);
        list.add(userInput);
    }

    public static void displayList(ArrayList list) { //10 fruits that I came up with as letters increment
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("\n%-2s %3s", i, " - ");
            System.out.printf((String) list.get(i));
        }
        System.out.println();
    }
}
