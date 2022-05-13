package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Util.getRandomNumber;

public class GCD extends Engine {

    private static int getCorrectAnswer(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }

        return getCorrectAnswer(number2, number1 % number2);
    }

    public static void runGame() {
        Map<String, String> questions = new HashMap<>();

        for (int i = 0; i < ROUNDS; i++) {
            int number1 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            int number2 = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            questions.put(number1 + " " + number2, String.valueOf(getCorrectAnswer(number1, number2)));
        }

        makeGame("Find the greatest common divisor of given numbers.", questions);
    }
}
