package hexlet.code;

public class Util {
    public static int getRandomNumber(int minNumber, int maxNumber) {
        return (int) (minNumber + Math.random() * maxNumber);
    }
}
