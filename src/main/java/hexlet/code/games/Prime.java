package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;

import java.util.List;
import java.util.ArrayList;

import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Util.getRandomNumber;

public class Prime {
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static boolean isPrimeNumber(int number) {
        for (int i = number - 1; i > 1; i--) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static RoundData generateRoundData() {
        int randomNumber = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        String correctAnswer = isPrimeNumber(randomNumber) ? "yes" : "no";

        return new RoundData(String.valueOf(randomNumber), correctAnswer);
    }

    public static void runGame() {
        List<RoundData> gameData = new ArrayList<>();

        for (int i = 0; i < ROUNDS; i++) {
            gameData.add(generateRoundData());
        }
        Engine.runGame(DESCRIPTION, gameData);
    }
}
