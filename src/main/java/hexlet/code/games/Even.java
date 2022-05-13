package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Util.getRandomNumber;

public class Even extends Engine {
    public static void runGame() {
        Map<String, String> questions = new HashMap<>();

        for (int i = 0; i < ROUNDS; i++) {
            int randomNumber = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            questions.put(String.valueOf(randomNumber), randomNumber % 2 == 0 ? ANSWER_YES : ANSWER_NO);
        }

        makeGame("Answer '" + ANSWER_YES + "' if the number is even, otherwise answer '" + ANSWER_NO + "'.", questions);
    }
}
