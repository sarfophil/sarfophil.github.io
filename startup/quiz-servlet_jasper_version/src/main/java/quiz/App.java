package quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import quiz.buisiness.Question;
import quiz.buisiness.Quiz;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        
        try {
            Quiz quiz = new Quiz();
            
            addQuestion(quiz);

            Scanner sc = new Scanner(System.in);
            boolean questionsLeft = true;

            while (questionsLeft) { 
                // They have to keep trying until get the right number.
                /* print out the current score and the question */
                System.out.println();
                System.out.println("Your score is:  " + quiz.getNumCorrect());
                System.out.println("Next sequence is:  " + quiz.getCurrentQuestion());

                System.out.println("Enter the next number for the given sequence.");
                String answer = sc.nextLine();

                boolean error = true;
                /* i.e., if answer is correct then increment the question index and score */
                if ((answer != null) && quiz.isCorrect(answer)) {
                    error = false;
                    // quiz.scoreAnswer();
                }

                /* give error message if wrong */
                if (error == true) {
                    System.out.println();
                    System.out.println("Wrong answer, please try again.");
                    System.out.println();
                }

                /* see if have finished questions */
                if (quiz.getNumCorrect() == quiz.getNumQuestions()) {
                    questionsLeft = false;
                    System.out.println("Congratulations, you have completed the quiz!");
                }
            }
        } catch (Exception ex) {
            System.out.format("%s: %s", ex.getClass().getName(), ex.getMessage());
        }
    }

    private static void addQuestion(Quiz quiz) {
        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question("[1,2,3,4,?]","9"));
        questions.add(new Question("[21,3,4,5,?]","5"));
       
        
        quiz.addQuestions(questions);
    }
}