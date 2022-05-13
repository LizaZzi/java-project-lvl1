package hexlet.code;

import hexlet.code.games.Greet;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scannerChoice = new Scanner(System.in);
        final int exit = 0;
        final int greet = 1;
        final int even = 2;
        final int calc = 3;
        final int gcd = 4;
        final int progression = 5;
        final int prime = 6;

        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""");

        int choice = scannerChoice.nextInt();

        System.out.println("Your choice: " + choice);

        switch (choice) {
            case exit -> System.out.println("0");
            case greet -> System.out.println(Greet.runGame());
            case even -> Even.runGame();
            case calc -> Calc.runGame();
            case gcd -> GCD.runGame();
            case progression -> Progression.runGame();
            case prime -> Prime.runGame();
            default -> {
                System.out.println("Введен неверный номер игры.");
            }
        }

        scannerChoice.close();
    }
}
