package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greet() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games! \n"
                + "May I have your name?");
        String name = scanner.nextLine();
        System.out.println("Hello, "  + name + "!");
        scanner.close();
    }
}
