package quiz.buisiness;

/**
 * Question
 */
public final class Question {

    private String question;
    private String answer;
    private String hint;

    public Question(String question,String answer){
        this.question = question;
        this.answer = answer;
    }

    public Question(String question,String answer,String hint){
        this.question = question;
        this.answer = answer;
        this.hint = hint;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @return the hint
     */
    public String getHint() {
        return hint;
    }
}