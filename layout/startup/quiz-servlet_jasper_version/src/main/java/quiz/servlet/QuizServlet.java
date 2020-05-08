package quiz.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "QuizServlet",urlPatterns = "/quiz")
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
        
       // genQuizPage(sessQuiz, resp.getWriter(), currQuest, true, null);
        viewAttributes(req, sessQuiz, currQuest, "");

        RequestDispatcher dispatcher = req.getRequestDispatcher("quiz.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Quiz sessQuiz = (Quiz) req.getSession().getAttribute("quiz");
       
        String answer = (String) req.getParameter("answerInput");

        //Error Message
        final String error = "Your last answer was not correct! Please try again";
        
        //Current Question
        String currQuest = sessQuiz.getCurrentQuestion();

        //Gameover
        if(sessQuiz.getNumCorrect() == sessQuiz.getNumQuestions()-1){ 

            //Forward Request to gameover page
            RequestDispatcher dispatcher = req.getRequestDispatcher("gameover.jsp");
            dispatcher.forward(req, resp);

        }else{
            if(sessQuiz.isCorrect(answer)){ 
                viewAttributes(req, sessQuiz, currQuest, "");
            }else{
                viewAttributes(req, sessQuiz, currQuest, error);
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("quiz.jsp");
            dispatcher.forward(req, resp);
        }
        




    }

    private void viewAttributes(HttpServletRequest req,Quiz quiz,String currQuest,String error){
       req.setAttribute("getNumCorrect", quiz.getNumCorrect());
       req.setAttribute("currQuest",currQuest);
       req.setAttribute("error",error);
       req.setAttribute("hint",quiz.getCurrentHint());
    }


    
   
}