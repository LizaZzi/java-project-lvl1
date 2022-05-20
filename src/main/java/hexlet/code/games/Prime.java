package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;

import java.util.*;

import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Engine.ANSWER_YES;
import static hexlet.code.Engine.ANSWER_NO;
import static hexlet.code.Util.getRandomNumber;

public class Prime {
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MIN_RANDOM_NUMBER = 0;

    private static RoundData generateRoundData() {
        final int[] primeNumbers = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int randomNumber = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        String correctAnswer = Arrays.stream(primeNumbers).anyMatch(prime -> prime == randomNumber)
                ? ANSWER_YES : ANSWER_NO;

        return new RoundData(String.valueOf(randomNumber), correctAnswer);
    }

    public static void runGame() {
        List<RoundData> gameData = new ArrayList<>();

        for (int i = 0; i < ROUNDS; i++) {
            gameData.add(generateRoundData());
        }
        Engine.runGame("Answer '" + ANSWER_YES + "' if given number is prime. Otherwise answer '" + ANSWER_NO + "'.",
                gameData);
    }
}
