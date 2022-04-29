/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Even.makeGame;

public class App {
    /**
     * say Welcome.
     *
     * @return - String
     */
    public String getGreeting() {
        return "Welcome to the Brain Games!";
    }

    public static void main(String[] args) {
        Scanner scannerChoice = new Scanner(System.in);
        final int greet = 1;
        final int even = 2;

        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                0 - Exit""");

        int choice = scannerChoice.nextInt();

        System.out.println("Your choice: " + choice);

        switch (choice) {
            case greet -> Greet.getGreeting();
            case even -> {
                Greet.getGreeting();
                makeGame();
            }
            default -> {
            }
        }
    }
}
