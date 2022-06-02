package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Util.getRandomNumber;

public class Progression {
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final String DESCRIPTION = "What number is missing in the progression?";

    private static int[] generateProgression(int begin, int diff, int size) {
        int[] progression = new int[size];
        progression[0] = begin;

        for (int i = 1; i < size; i++) {
            progression[i] = progression[i - 1] + diff;
        }
        return progression;
    }

    private static String getProgressionAsQuestion(int[] progression, int elementNumber) {
        StringBuilder progressionString = new StringBuilder();
        String numberStr;
        for (int i = 0; i < progression.length; i++) {
            numberStr = String.valueOf(progression[i]);

            if (i == elementNumber) {
                numberStr = "..";
            }
            progressionString.append(numberStr).append(" ");
        }
        return progressionString.toString();
    }

    private static RoundData generateRoundData() {
        final int minProgressionSize = 5;
        final int maxProgressionSize = 10;
        int begin = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int diff = getRandomNumber(MIN_RANDOM_NUMBER + 1, MAX_RANDOM_NUMBER);
        int size = getRandomNumber(minProgressionSize, maxProgressionSize);
        int[] progressionQuestion = generateProgression(begin, diff, size);
        int randomElementNumber = getRandomNumber(MIN_RANDOM_NUMBER, progressionQuestion.length - 1);
        String answer = String.valueOf(progressionQuestion[randomElementNumber]);
        String question = getProgressionAsQuestion(progressionQuestion, randomElementNumber);

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
