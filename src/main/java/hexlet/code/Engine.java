package hexlet.code;

import hexlet.code.games.Greet;

import java.util.Map;
import java.util.Scanner;

import static hexlet.code.games.Greet.getName;

public class Engine {
    public static final int EXIT = 0;
    public static final String ANSWER_YES = "yes";
    public static final String ANSWER_NO = "no";
    public static final int ROUNDS = 3;
    public static final int MAX_RANDOM_NUMBER = 100;
    public static final int MIN_RANDOM_NUMBER = 0;

    public static void makeGame(String condition, Map<String, String> questions) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        int correctCnt = 0;

        Greet.getGreeting();

        System.out.println(condition);

        for (Map.Entry<String, String> question : questions.entrySet()) {
            String correctAnswer = question.getValue();

            System.out.println("Question: " + question.getKey());

            answer = scanner.nextLine();

            if (answer.equals(correctAnswer)) {
                correctCnt++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'. \n"
                        + "Let's try again, " + getName() + "!");
                break;
                }
            }

        if (correctCnt == ROUNDS) {
            System.out.println("Congratulations, " + getName() + "!");
        }

        System.out.println(EXIT);

        scanner.close();
    }
}
