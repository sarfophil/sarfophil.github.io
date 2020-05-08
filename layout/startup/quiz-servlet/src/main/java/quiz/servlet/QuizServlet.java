package quiz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quiz.buisiness.Quiz;



/**
 * QuizServlet
 */
@WebServlet(name = "QuizServlet",urlPatterns = "/")
public class QuizServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

   


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("quiz", new Quiz());

        Quiz sessQuiz = (Quiz) httpSession.getAttribute("quiz");
        String currQuest = sessQuiz.getCurrentQuestion();
        
        genQuizPage(sessQuiz, resp.getWriter(), currQuest, true, null);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Quiz sessQuiz = (Quiz) req.getSession().getAttribute("quiz");
       
        String answer = (String) req.getParameter("answerInput");
        

        String currQuest = sessQuiz.getCurrentQuestion();

        if(sessQuiz.getNumCorrect() == sessQuiz.getNumQuestions()-1){
            
            genQuizOverPage(resp.getWriter());
        }else{
            if(sessQuiz.isCorrect(answer)){
                genQuizPage(sessQuiz, resp.getWriter(), sessQuiz.getCurrentQuestion(), true, answer);
            }else{
                genQuizPage(sessQuiz, resp.getWriter(), currQuest, false, null);
            }
        }
        

    }

    

    private void genQuizPage(Quiz sessQuiz, PrintWriter out, String currQuest, boolean error, String answer) {
        
        out.print("<html>");
        out.print("<head>");
        out.print("	<title>NumberQuiz</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("	<form  method='post'>");
        out.print("		<h3>Have fun with NumberQuiz!</h3>");
        out.print("<p>Your current score is: ");
        out.print(sessQuiz.getNumCorrect() + "</br></br>");
        out.print("<p>Guess the next number in the sequence! ");
        out.print(currQuest + "</p>");

        out.print("<p>Your answer:<input type='text' name='answerInput' /></p> ");

        /* if incorrect, then print out error message */
        if (!error) {  //REFACTOR?-- assumes answer null only when first open page
            out.print("<p style='color:red'>Your last answer was not correct! Please try again</p> ");
        }
        out.print("<p><input type='submit' name='btnNext' value='Next' /></p> ");

        out.print("</form>");
        out.print("</body></html>");
    }

    private void genQuizOverPage(PrintWriter out) {
        out.print("<html> ");
	out.print("<head >");
	out.print("<title>NumberQuiz is over</title> ");
	out.print("</head> ");
	out.print("<body> ");
	out.print("<p style='color:red'>The number quiz is over!</p>	</body> ");
        out.print("</html> ");
    }

    
}