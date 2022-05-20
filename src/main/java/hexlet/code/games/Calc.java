package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Util.getRandomNumber;

public class Calc {
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_OPERATION = 3;
    private static final char[] OPERATIONS = {'-', '+', '*'};

    private static int calculate(int number1, int number2, char operation) throws IllegalArgumentException {
        return switch (operation) {
            case '-' -> number1 - number2;
            case '+' -> number1 + number2;
            case '*' -> number1 * number2;
            default -> throw new IllegalArgumentException("Unexpected operation: '" + operation + "'");
        };
    }

    private static RoundData generateRoundData() {
        int number1 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int number2 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int numberOperation = getRandomNumber(MIN_RANDOM_NUMBER, MAX_OPERATION);
        char operation = OPERATIONS[numberOperation];
        int correctAnswer = calculate(number1, number2, operation);
        String question = number1 + " " + operation + " " + number2;
        String answer = String.valueOf(correctAnswer);

        return new RoundData(question, answer);
    }

    public static void runGame() {
        List<RoundData> gameData = new ArrayList<>();

        for (int i = 0; i < ROUNDS; i++) {
            gameData.add(generateRoundData());
        }
        Engine.runGame("What is the result of the expression?", gameData);
    }
}
