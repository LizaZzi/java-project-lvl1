package hexlet.code;

import java.util.Map;
import java.util.Scanner;

public class Engine {
    public static final int EXIT = 0;
    public static final String ANSWER_YES = "yes";
    public static final String ANSWER_NO = "no";
    public static final int ROUNDS = 3;
    public static final int MAX_RANDOM_NUMBER = 100;
    public static final int MIN_RANDOM_NUMBER = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static String greet() {
        System.out.println("Welcome to the Brain Games! \n"
                + "May I have your name?");

        String name = scanner.nextLine();

        scanner.close();
        return "Hello, " + name + "!";
    }

    public static void runGame(String description, Map<String, String> gameData) {
        String name;

        System.out.println("Welcome to the Brain Games! \n"
                + "May I have your name?");

        name = scanner.nextLine();

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
            }
        }

        System.out.println("Congratulations, " + name + "!");

        System.out.println(EXIT);
    }
}
