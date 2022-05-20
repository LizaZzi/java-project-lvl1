package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Util.getRandomNumber;;

public class Calc {
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_OPERATION = 3;
    private static final char[] OPERATIONS = {'-', '+', '*'};

    public static Map<String, String> generateRoundData() {
        Map<String, String> gameData = new HashMap<>();
        int number1 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int number2 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int numberOperation = getRandomNumber(MIN_RANDOM_NUMBER, MAX_OPERATION);
        char operation = OPERATIONS[numberOperation];

        int correctAnswer = switch (operation) {
            case '-' -> number1 - number2;
            case '+' -> number1 + number2;
            case '*' -> number1 * number2;
            default -> 0;
        };

        String question = number1 + " " + operation + " " + number2;
        String answer = String.valueOf(correctAnswer);

        gameData.put(question, answer);
        return gameData;
    }

    public static void runGame() {
        Map<String, String> gameData = new HashMap<>();

        for (int i = 0; i < ROUNDS; i++) {
            gameData.putAll(generateRoundData());
        }
        Engine.runGame("What is the result of the expression?", gameData);
    }
}
