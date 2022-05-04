package hexlet.code.games;

import hexlet.code.Engine;

public class Even extends Engine {
    public static void makeGame() {
        final String answerYes = "yes";
        final String answerNO = "no";

        System.out.println(Greet.getGreeting());

        System.out.println(getConditions(
                "Answer '" + answerYes + "' if the number is even, otherwise answer '" + answerNO + "'."
        ));

        for (int i = 0; i < ROUNDS; i++) {
            int randomNumber = getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            String correctAnswer = randomNumber % 2 == 0 ? answerYes : answerNO;

            System.out.println(getQuestion(String.valueOf(randomNumber)));
            System.out.println(getAnswer(correctAnswer));
        }

        System.out.println(getCongratulation());
    }
}
