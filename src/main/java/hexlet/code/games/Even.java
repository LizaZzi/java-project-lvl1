package hexlet.code.games;

import hexlet.code.Engine;

public class Even extends Engine {
    public static void makeGame() {
        System.out.println(Greet.getGreeting());

        System.out.println(getConditions(
                "Answer '" + ANSWER_YES + "' if the number is even, otherwise answer '" + ANSWER_NO + "'."
        ));

        for (int i = 0; i < ROUNDS; i++) {
            int randomNumber = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            String correctAnswer = randomNumber % 2 == 0 ? ANSWER_YES : ANSWER_NO;

            System.out.println(getQuestion(String.valueOf(randomNumber)));
            System.out.println(getAnswer(correctAnswer));
        }

        System.out.println(getCongratulation());
    }
}
