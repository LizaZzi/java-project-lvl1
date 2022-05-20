package hexlet.code;

import java.util.List;
import java.util.Scanner;

public class Engine {
    private static final int EXIT = 0;
    public static final String ANSWER_YES = "yes";
    public static final String ANSWER_NO = "no";
    public static final int ROUNDS = 3;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void greet() {
        System.out.println("Welcome to the Brain Games! \n"
                + "May I have your name?");
        String name = SCANNER.nextLine();
        System.out.println("Hello, "  + name + "!");
        SCANNER.close();
    }

    public static void runGame(String description, List<RoundData> gameData) {
        System.out.println("Welcome to the Brain Games! \n"
                + "May I have your name?");
        String name = SCANNER.nextLine();
        System.out.println("Hello, "  + name + "!");

        System.out.println(description);

        for (RoundData roundData : gameData) {
            String correctAnswer = roundData.getAnswer();
            System.out.println("Question: " + roundData.getQuestion());
            String answer = SCANNER.nextLine();
            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'. \n"
                        + "Let's try again, " + name + "!");
                SCANNER.close();
                return;
            } else {
                System.out.println("Correct!");
            }
        }

        System.out.println("Congratulations, " + name + "!");
        System.out.println(EXIT);
    }
}
