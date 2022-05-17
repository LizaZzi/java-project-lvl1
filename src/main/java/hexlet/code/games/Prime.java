package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Engine.MIN_RANDOM_NUMBER;
import static hexlet.code.Engine.MAX_RANDOM_NUMBER;
import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Engine.ANSWER_YES;
import static hexlet.code.Engine.ANSWER_NO;
import static hexlet.code.Engine.getRandomNumber;

public class Prime {
    private static Map<String, String> round() {
        final int[] primeNumbers = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        Map<String, String> gameData = new HashMap<>();
        int randomNumber = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        String correctAnswer = Arrays.stream(primeNumbers).anyMatch(prime -> prime == randomNumber)
                ? ANSWER_YES : ANSWER_NO;

        gameData.put(String.valueOf(randomNumber), correctAnswer);

        return gameData;
    }

    public static void runGame() {
        Map<String, String> gameData = new HashMap<>();

        for (int i = 0; i < ROUNDS; i++) {
            gameData.putAll(round());
        }

        Engine.runGame("Answer '" + ANSWER_YES + "' if given number is prime. Otherwise answer '" + ANSWER_NO + "'.",
                gameData);
    }
}
