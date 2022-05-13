package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Util.getRandomNumber;

public class Calc extends Engine {
    private static final String SUBTRACTION = "-";
    private static final String ADDITION = "+";
    private static final String MULTIPLY = "*";
    private static final int MAX_OPERATION = 3;
    private static final String[] OPERATIONS = {SUBTRACTION, ADDITION, MULTIPLY};

    private static int getCorrectAnswer(int number1, int number2, String operation) {
        return switch (operation) {
            case SUBTRACTION -> number1 - number2;
            case ADDITION -> number1 + number2;
            case MULTIPLY -> number1 * number2;
            default -> 0;
        };
    }

    public static void runGame() {
        Map<String, String> questions = new HashMap<>();

        for (int i = 0; i < ROUNDS; i++) {
            int number1 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int number2 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int numberOperation = getRandomNumber(MIN_RANDOM_NUMBER, MAX_OPERATION);
            String operation = OPERATIONS[numberOperation];

            questions.put(number1 + " " + operation + " " + number2,
                    String.valueOf(getCorrectAnswer(number1, number2, operation)));
        }

        makeGame("What is the result of the expression?", questions);
    }
}
