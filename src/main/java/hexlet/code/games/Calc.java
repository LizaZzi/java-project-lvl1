package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Engine.MIN_RANDOM_NUMBER;
import static hexlet.code.Engine.MAX_RANDOM_NUMBER;
import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Util.getRandomNumber;;

public class Calc {

    public static Map<String, String> round() {
        Map<String, String> gameData = new HashMap<>();
        final int maxOperation = 3;
        final char subtraction = '-';
        final char addition = '+';
        final char multiply = '*';
        final char[] operations = {subtraction, addition, multiply};
        int number1 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int number2 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int numberOperation = getRandomNumber(MIN_RANDOM_NUMBER, maxOperation);
        char operation = operations[numberOperation];

        int correctAnswer = switch (operation) {
            case subtraction -> number1 - number2;
            case addition -> number1 + number2;
            case multiply -> number1 * number2;
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
            gameData.putAll(round());
        }

        Engine.runGame("What is the result of the expression?", gameData);
    }
}
