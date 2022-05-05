package hexlet.code;

import java.util.Scanner;

import static hexlet.code.games.Greet.getName;

public class Engine {
    public static final int EXIT = 0;
    public static final String ANSWER_YES = "yes";
    public static final String ANSWER_NO = "no";
    public static final int ROUNDS = 3;
    public static final int MAX_RANDOM_NUMBER = 100;
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final String CORRECT_ANSWER = "Correct!";
    private static String answer;
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

    public static String getYourAnswer() {
        Scanner scanner = new Scanner(System.in);

        answer = scanner.nextLine();

        return "Your answer: " + answer;
    }

    public static String checkAnswer(String correctAnswer) {
        if (answer.equals(correctAnswer)) {
            correctCnt++;
            return CORRECT_ANSWER;
        } else {
            return "'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'. \n"
                    + "Let's try again, " + getName() + "!";
        }
    }

    public static String getCongratulation() {
        return correctCnt == ROUNDS ? "Congratulations, " + getName() + "!" : "";
    }
}
