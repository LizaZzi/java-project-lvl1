package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Engine.MIN_RANDOM_NUMBER;
import static hexlet.code.Engine.MAX_RANDOM_NUMBER;
import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Util.getRandomNumber;

public class GCD {

    private static int calculateGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }

        return calculateGCD(number2, number1 % number2);
    }

    private static Map<String, String> round() {
        Map<String, String> gameData = new HashMap<>();
        int number1 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int number2 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        String question = number1 + " " + number2;
        String answer = String.valueOf(calculateGCD(number1, number2));

        gameData.put(question, answer);

        return gameData;
    }

    public static void runGame() {
        Map<String, String> gameData = new HashMap<>();

        for (int i = 0; i < ROUNDS; i++) {
            gameData.putAll(round());
        }

        Engine.runGame("Find the greatest common divisor of given numbers.", gameData);
    }
}
