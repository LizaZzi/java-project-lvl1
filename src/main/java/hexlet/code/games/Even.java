package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Engine.MIN_RANDOM_NUMBER;
import static hexlet.code.Engine.MAX_RANDOM_NUMBER;
import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Engine.ANSWER_YES;
import static hexlet.code.Engine.ANSWER_NO;
import static hexlet.code.Util.getRandomNumber;

public class Even {
    private static boolean isEven(int randomNumber) {
        return randomNumber % 2 == 0;
    }

    public static Map<String, String> round() {
        Map<String, String> gameData = new HashMap<>();

        int randomNumber = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        String question = String.valueOf(randomNumber);
        String answer = isEven(randomNumber) ? ANSWER_YES : ANSWER_NO;

        gameData.put(question, answer);

        return gameData;
    }

    public static void runGame() {
        Map<String, String> gameData = new HashMap<>();

        for (int i = 0; i < ROUNDS; i++) {
            gameData.putAll(round());
        }

        Engine.runGame("Answer '" + ANSWER_YES + "' if the number is even, otherwise answer '" + ANSWER_NO + "'.",
                gameData);
    }
}
