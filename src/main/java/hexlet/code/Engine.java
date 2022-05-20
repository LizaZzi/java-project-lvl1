package hexlet.code;

import java.util.Map;
import java.util.Scanner;

public class Engine {
    private static final int EXIT = 0;
    public static final String ANSWER_YES = "yes";
    public static final String ANSWER_NO = "no";
    public static final int ROUNDS = 3;
    private static Scanner scanner = new Scanner(System.in);

    public static void greet() {
        System.out.println("Welcome to the Brain Games! \n"
                + "May I have your name?");
        String name = scanner.nextLine();
        System.out.println("Hello, "  + name + "!");
        scanner.close();
    }

    public static void runGame(String description, Map<String, String> gameData) {
        System.out.println("Welcome to the Brain Games! \n"
                + "May I have your name?");
        String name = scanner.nextLine();
        System.out.println("Hello, "  + name + "!");

        System.out.println(description);

        for (Map.Entry<String, String> question : gameData.entrySet()) {
            String correctAnswer = question.getValue();
            System.out.println("Question: " + question.getKey());
            String answer = scanner.nextLine();
            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'. \n"
                        + "Let's try again, " + name + "!");
                scanner.close();
                return;
            } else {
                System.out.println("Correct!");
            }
        }

        System.out.println("Congratulations, " + name + "!");
        System.out.println(EXIT);
    }
}
