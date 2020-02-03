package quiz.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AgeServlet
 */
@WebServlet(name = "AgeServlet",urlPatterns = "/age")
public class AgeServlet extends HttpServlet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Integer age = Integer.parseInt(req.getParameter("age").toString());

            if(age >= 4 && age <= 100){
                resp.sendRedirect("quiz?ageError=false");
            }else{
                resp.sendRedirect("quiz?ageError=true");
            }

        } catch(Exception e){
            System.err.println(e);
            resp.sendRedirect("quiz?ageError=true");
        }
        

    }
    
}