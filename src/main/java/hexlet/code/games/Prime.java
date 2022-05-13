package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Util.getRandomNumber;

public class Prime extends Engine {
    private static final int[] PRIME_NUMBERS = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    public static void runGame() {
        Map<String, String> questions = new HashMap<>();

        for (int i = 0; i < ROUNDS; i++) {
            int randomNumber = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            String correctAnswer = Arrays.stream(PRIME_NUMBERS).anyMatch(prime -> prime == randomNumber)
                    ? ANSWER_YES : ANSWER_NO;

            questions.put(String.valueOf(randomNumber), correctAnswer);
        }

        makeGame("Answer '" + ANSWER_YES + "' if given number is prime. Otherwise answer '" + ANSWER_NO + "'.", questions);
    }
}
