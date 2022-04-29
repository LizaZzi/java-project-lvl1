package hexlet.code.games;

import java.util.Scanner;

public class Greet {
    private static String name = "";

    public static String getName() {
        return name;
    }

    public static String getGreeting() {
        Scanner scannerName = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games! \n"
                + "May I have your name?");

        name = scannerName.nextLine();

        return "Hello, " + name + "!";
    }
}
