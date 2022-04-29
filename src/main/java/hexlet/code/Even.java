package hexlet.code;

import java.util.Scanner;

public class Even {
    private static int randomNumber;
    private static int correctCnt;
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int ROUNDS = 3;
    private static String nameGamer;

    private static String getGameConditions() {
        return "Answer '" + YES + "' if the number is even, otherwise answer '" + NO + "'.";
    }

    private static String getQuestion() {
        randomNumber = (int) (0 + Math.random() * MAX_RANDOM_NUMBER);

        return "Question: " + randomNumber;
    }

    private static String getAnswer() {
        Scanner scanner = new Scanner(System.in);

        return "Your answer: " + checkAnswer(randomNumber, scanner.nextLine());
    }

    private static String checkAnswer(int number, String answer) {
        String correct = number % 2 == 0 ? YES : NO;

        if (answer.equals(correct)) {
            correctCnt++;
            return "Correct!";
        } else {
            correctCnt--;
            return "'" + answer + "' is wrong answer ;(. Correct answer was '" + correct + "'. \n"
                    + "Let's try again, " + nameGamer + "!";
        }
    }

    public static String getCongratulation() {
        return "Congratulations, " + nameGamer + "!";
    }

    public static void makeGame(String name) {
        nameGamer = name;

        System.out.println(getGameConditions());

        for (int i = 0; i < ROUNDS; i++) {
            System.out.println(getQuestion());
            System.out.println(getAnswer());
        }

        if (correctCnt == ROUNDS) {
            System.out.println(getCongratulation());
        }
    }

}
