package hexlet.code.games;

import hexlet.code.Engine;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Util.getRandomNumber;

public class Progression extends Engine {
    private static final int MIN_PROGRESSION_SIZE = 5;
    private static final int MAX_PROGRESSION_SIZE = 10;

    private static String[] getProgression() {
        int begin = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        int diff = getRandomNumber(MIN_RANDOM_NUMBER + 1, MAX_RANDOM_NUMBER);
        int maxSize = getRandomNumber(MIN_PROGRESSION_SIZE, MAX_PROGRESSION_SIZE);

        String[] progression = new String[maxSize];
        progression[0] = String.valueOf(begin);

        for (int i = 1; i < maxSize; i++) {
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

    public static void runGame() {
        Map<String, String> questions = new HashMap<>();

        for (int i = 0; i < ROUNDS; i++) {
            String[] progressionQuestion = getProgression();
            int randomNumberProgression = getRandomNumber(MIN_RANDOM_NUMBER, progressionQuestion.length - 1);
            String correctAnswer = progressionQuestion[randomNumberProgression];

            progressionQuestion[randomNumberProgression] = "..";

            questions.put(getProgressionAsString(progressionQuestion), correctAnswer);
        }

        makeGame("What number is missing in the progression?", questions);
    }
}
