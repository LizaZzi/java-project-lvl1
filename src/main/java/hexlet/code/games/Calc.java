package hexlet.code.games;


public class Calc extends Game {
    private static final int MAX_OPERATION = 3;
    private static int result;

    private static String getQuestion() {
        int number1 = getRandomNumber(MAX_RANDOM_NUMBER);
        int number2 = getRandomNumber(MAX_RANDOM_NUMBER);
        int numberOperation = getRandomNumber(MAX_OPERATION);

        final String subtraction = "-";
        final String addition = "+";
        final String multiply = "*";
        final String[] operations = {subtraction, addition, multiply};

        String operation = operations[numberOperation];

        result = switch (operation) {
            case subtraction -> number1 - number2;
            case addition -> number1 + number2;
            case multiply -> number1 * number2;
            default -> 0;
        };

        return number1 + " " + operation + " " + number2;
    }

    public static void makeGame() {
        System.out.println(Greet.getGreeting());

        System.out.println(getConditions("What is the result of the expression?"));

        for (int i = 0; i < ROUNDS; i++) {
            System.out.println(getQuestion(getQuestion()));
            System.out.println(getAnswer(String.valueOf(result)));
        }

        System.out.println(getCongratulation());
    }
}
