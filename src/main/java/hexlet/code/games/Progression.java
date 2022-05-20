package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static hexlet.code.Engine.ROUNDS;
import static hexlet.code.Util.getRandomNumber;

public class Progression {
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MIN_RANDOM_NUMBER = 0;

    private static String[] generateProgression(int begin, int diff, int size) {
        String[] progression = new String[size];
        progression[0] = String.valueOf(begin);

        for (int i = 1; i < size; i++) {
            progression[i] = String.valueOf(Integer.parseInt(progression[i - 1]) + diff);
        }
        return progression;
    }

    private static String getProgressionAsString(String[] progression) {
        StringBuilder progressionString = new StringBuilder();
        for (String number : progression) {
            progressionString.append(number).append(" ");
        }
        return progressionString.toString();
    }

    private static RoundData generateRoundData() {
        Map<String, String> gameData = new HashMap<>();
        final int minProgressionSize = 5;
        final int maxProgressionSize = 10;
        int begin = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int diff = getRandomNumber(MIN_RANDOM_NUMBER + 1, MAX_RANDOM_NUMBER);
        int size = getRandomNumber(minProgressionSize, maxProgressionSize);
        String[] progressionQuestion = generateProgression(begin, diff, size);
        int randomNumberProgression = getRandomNumber(MIN_RANDOM_NUMBER, progressionQuestion.length - 1);

        String answer = progressionQuestion[randomNumberProgression];
        progressionQuestion[randomNumberProgression] = "..";
        String question = getProgressionAsString(progressionQuestion);

        return new RoundData(question, answer);
    }

    public static void runGame() {
        List<RoundData> gameData = new ArrayList<>();

        for (int i = 0; i < ROUNDS; i++) {
            gameData.add(generateRoundData());
        }
        Engine.runGame("What number is missing in the progression?", gameData);
    }
}
