package hexlet.code;

import java.util.Scanner;

import static hexlet.code.App.name;

public class Even {
    private static int randomNumber;
    private static int correctCnt;
    private static final String YES = "yes";
    private static final String NO = "no";

    private static String getGameConditions() {
        return "Answer '" + YES + "' if the number is even, otherwise answer '" + NO + "'.";
    }

    private static String getQuestion() {
        randomNumber = (int) (0 + Math.random() * 100);

        return "Question: " + randomNumber + "\n";
    }

    private static String getAnswer() {
        Scanner scanner = new Scanner(System.in);

        return "Your answer: " + checkAnswer(randomNumber, scanner.nextLine()) + "\n";
    }

    private static String checkAnswer(int number, String answer) {
        String correct = number % 2 == 0 ? YES : NO;

        if (answer.equals(correct)) {
            correctCnt++;
            return "Correct!";
        } else {
            correctCnt--;
            return "'" + answer + "' is wrong answer ;(. Correct answer was '" + correct + "'. \n"
                    + "Let's try again, " + name + "!";
        }
    }

    public static String getCongratulation() {
        return "Congratulations, " + name + "!";
    }

    public static void makeGame(int ROUND_CNT) {
        System.out.println(getGameConditions());

        for (int i = 0; i < ROUND_CNT; i++) {
            System.out.println(getQuestion());
            System.out.println(getAnswer());
        }

        if (correctCnt == ROUND_CNT) {
            System.out.println(getCongratulation());
        }
    }

}
