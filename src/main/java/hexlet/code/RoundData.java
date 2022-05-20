package hexlet.code;

public class RoundData {
    private final String question;
    private final String answer;

    public RoundData(String roundQuestion, String roundAnswer) {
        this.question = roundQuestion;
        this.answer = roundAnswer;
    }

    public final String getQuestion() {
        return question;
    }

    public final String getAnswer() {
        return answer;
    }
}
