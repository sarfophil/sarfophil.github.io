package quiz.buisiness;

/**
 * Question
 */
public class Question {

    private String question;
    private String answer;

    public Question(String question,String answer){
        this.question = question;
        this.answer = answer;
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
}