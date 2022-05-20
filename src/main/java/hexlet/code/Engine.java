package hexlet.code;

import java.util.List;
import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;

    public static void runGame(String description, List<RoundData> gameData) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games! \n"
                + "May I have your name?");
        String name = scanner.nextLine();
        System.out.println("Hello, "  + name + "!");

        System.out.println(description);

        for (RoundData roundData : gameData) {
            String correctAnswer = roundData.getAnswer();
            System.out.println("Question: " + roundData.getQuestion());
            String answer = scanner.nextLine();
            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'. \n"
                        + "Let's try again, " + name + "!");
                scanner.close();
                return;
            }
            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + name + "!");
        scanner.close();
    }
}
