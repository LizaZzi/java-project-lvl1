package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Util.getRandomNumber;

public class Even {
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static boolean isEven(int randomNumber) {
        return randomNumber % 2 == 0;
    }

    public static RoundData generateRoundData() {
        int randomNumber = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        String question = String.valueOf(randomNumber);
        String answer = isEven(randomNumber) ? "yes" : "no";

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
