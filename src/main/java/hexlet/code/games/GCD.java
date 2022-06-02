package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Util.getRandomNumber;

public class GCD {
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    private static int calculateGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return calculateGCD(number2, number1 % number2);
    }

    private static RoundData generateRoundData() {
        int number1 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int number2 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        String question = number1 + " " + number2;
        String answer = String.valueOf(calculateGCD(number1, number2));

        return new RoundData(question, answer);
    }

    public static void runGame() {
        List<RoundData> gameData = new ArrayList<>();

        for (int i = 0; i < ROUNDS; i++) {
            gameData.add(generateRoundData());
        }
        Engine.runGame(DESCRIPTION, gameData);
    }
}
