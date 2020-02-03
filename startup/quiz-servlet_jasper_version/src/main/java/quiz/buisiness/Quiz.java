package quiz.buisiness;

import java.util.ArrayList;
import java.util.List;

/**
 * QuizImpl
 */
public class Quiz {

    private Integer score = 0;
    private List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;

    public Quiz(){
        questions.add(new Question("[3, 1, 4, 1, 5, ? ]", "9"));
        questions.add(new Question("[1, 1, 2, 3, 5, ? ]","8"));
        questions.add(new Question("[1, 4, 9, 16, 25, ? ]","36"));
        questions.add(new Question("[2, 3, 5, 7, 11, ? ]","13"));
        questions.add(new Question("[1, 2, 4, 8, 16, ? ]","32"));
        questions.add(new Question("[1, 2, 4, 8, 16, ? ]","32"));
    }

  
    public int getScore() {
        return score;
    }

  
    public Boolean isCorrect(String answer) {
        
        Question question = questions.get(currentQuestionIndex);

        if(question.getAnswer().equals(answer)){
            score++;
            currentQuestionIndex++;
            log("Correct. Score:"+score+" current question index: "+currentQuestionIndex+" Next question: "+getCurrentQuestion());
            return true;
        }

        return false;
    }

   
    public int getNumCorrect() {
        return score;
    }
    
 
    public void addQuestions(List<Question> questions) {
        this.questions = questions;
    }


  
    public String getCurrentQuestion() {
        return questions.get(currentQuestionIndex).getQuestion();
    }

    
  
    public int getNumQuestions() {
        return questions.size();
    }

 
    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

   public void log(String message){
       System.out.println("Calculator: "+message);
   }
 
}