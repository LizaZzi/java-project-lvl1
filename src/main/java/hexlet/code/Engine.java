package hexlet.code;

import java.util.Scanner;

import static hexlet.code.games.Greet.getName;

public class Engine {
    public static final int ROUNDS = 3;
    public static final int MAX_RANDOM_NUMBER = 100;
    public static final int MIN_RANDOM_NUMBER = 0;
    private static int correctCnt;

    public static int getRandomNumber(int minNumber, int maxNumber) {
        return (int) (minNumber + Math.random() * maxNumber);
    }

    public static String getConditions(String condition) {
        return condition;
    }

    public static String getQuestion(String question) {
        return "Question: " + question;
    }

    public static String getAnswer(String correctAnswer) {
        Scanner scanner = new Scanner(System.in);

        String answer = scanner.nextLine();

        return "Your answer: " + answer + "\n" + checkAnswer(correctAnswer, answer);
    }

    private static String checkAnswer(String correctAnswer, String answer) {
        if (answer.equals(correctAnswer)) {
            correctCnt++;
            return "Correct!";
        } else {
            correctCnt--;
            return "'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'. \n"
                    + "Let's try again, " + getName() + "!";
        }
    }

    public static String getCongratulation() {
        return correctCnt == ROUNDS ? "Congratulations, " + getName() + "!" : "";
    }
}
