package com.calculator.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CalculatorServlet
 */
@WebServlet(name = "CalculatorServlet",urlPatterns = "/result")
public class CalculatorServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        validateInputs(req).ifPresentOrElse(a->{  
            try {
                redirect(req, resp);
            } catch (ServletException | IOException e) {
                log("An Error Occured", e);
            }

        }, ()->{

            try {
                resp.sendRedirect("");
            } catch (IOException e) {
                log("An error occurred", e);
            }

        });
    
    }


    private Optional<Boolean> validateInputs(HttpServletRequest request){
        String inputPlus1 = request.getParameter("inputPlus1");
        String inputPlus2 = request.getParameter("inputPlus2");

        String inputMultiply1 = request.getParameter("inputMultiply1");
        String inputMultiply2 = request.getParameter("inputMultiply2");

        //Validate  Inputs
        if(!inputPlus1.isEmpty() && !inputPlus2.isEmpty() || !inputMultiply1.isEmpty() && !inputMultiply2.isEmpty()){
            return Optional.of(true);
        }

        return Optional.of(false);
    }

    

    /** */
    private Integer add(HttpServletRequest request){
        String inputPlus1 = request.getParameter("inputPlus1");
        String inputPlus2 = request.getParameter("inputPlus2");

        if(inputPlus1.isEmpty() && inputPlus2.isEmpty())
                return 0;

        return Integer.parseInt(inputPlus1) + Integer.parseInt(inputPlus2);
    }

    /**
     * Multiplication
     * @param request
     * @return
     */
    private Integer multiply(HttpServletRequest request){
        String inputMultiply1 = request.getParameter("inputMultiply1");
        String inputMultiply2 = request.getParameter("inputMultiply2");

        if(inputMultiply1.isEmpty() && inputMultiply2.isEmpty())
                return 0;
        return Integer.parseInt(inputMultiply1) * Integer.parseInt(inputMultiply2);
    }

    /**
     * 
     * @param req
     * @param page
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer addition = add(req);
        Integer multiply = multiply(req);

        if(addition > 0 && multiply > 0){

            //Attribute
            req.setAttribute("additionResult", addition);
            req.setAttribute("multiplyResult",multiply);

            
            req.setAttribute("inputPlus1",Integer.parseInt(req.getParameter("inputPlus1")));
            req.setAttribute("inputPlus2", Integer.parseInt(req.getParameter("inputPlus2")));
           
            req.setAttribute("inputMultiply1",Integer.parseInt(req.getParameter("inputMultiply1")));
            req.setAttribute("inputMultiply2", Integer.parseInt(req.getParameter("inputMultiply2")));


        }else if(addition > 0 && multiply == 0){

            //Attribute
            req.setAttribute("additionResult", addition);
            
            req.setAttribute("inputPlus1",Integer.parseInt(req.getParameter("inputPlus1")));
            req.setAttribute("inputPlus2", Integer.parseInt(req.getParameter("inputPlus2")));
            
        }else{
           
            //Attribute
            req.setAttribute("multiplyResult", multiply);
            req.setAttribute("inputMultiply1",Integer.parseInt(req.getParameter("inputMultiply1")));
            req.setAttribute("inputMultiply2", Integer.parseInt(req.getParameter("inputMultiply2")));
        }

        
        RequestDispatcher dispatcher  = req.getRequestDispatcher("/jsp/index.jsp");
        dispatcher.forward(req, resp);
    }
    
}