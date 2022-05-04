package hexlet.code.games;

import hexlet.code.Engine;

public class GCD extends Engine {

    private static int getCorrectAnswer(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }

        return getCorrectAnswer(number2, number1 % number2);
    }

    public static void makeGame() {
        System.out.println(Greet.getGreeting());

        System.out.println(getConditions("Find the greatest common divisor of given numbers."));

        for (int i = 0; i < ROUNDS; i++) {
            int number1 = getRandomNumber(MAX_RANDOM_NUMBER);
            int number2 = getRandomNumber(MAX_RANDOM_NUMBER);

            System.out.println(getQuestion(number1 + " " + number2));
            System.out.println(getAnswer(String.valueOf(getCorrectAnswer(number1, number2))));
        }

        System.out.println(getCongratulation());
    }
}
