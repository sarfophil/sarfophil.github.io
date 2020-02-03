/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package quiz;

import quiz.buisiness.Question;
import quiz.buisiness.Quiz;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @since 4/8/09
 * @author levi
 * JUnit test for the TestQuiz class.  Basic verification tests that all pass as of 4/8/09.
 */
public class TestQuiz {
    Quiz quizUnderTest = new Quiz();

    public TestQuiz() {
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question("[3, 1, 4, 1, 5, ? ]", "9"));
        questions.add(new Question("[1, 1, 2, 3, 5, ? ]","8"));
        
        quizUnderTest.addQuestions(questions);
    }

    @After
    public void tearDown() {

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testIsCorrect() {
        /* should be at first question, answer should be "9" */
        assertTrue("first question answer should be '9'", quizUnderTest.isCorrect("9"));
    }
    
    @Test
    public void testGetNumberQuestions() {
        /* should be at first question, answer should be 5 */
        assertEquals(2, quizUnderTest.getNumQuestions());
    }    
    
    @Test
    public void testGetNumberCorrect() {
        /* should be at first question, answer should be 0 */
        assertEquals(0, quizUnderTest.getNumCorrect());  
        
        quizUnderTest.isCorrect("9");

        //should increment the score and the current question number
        assertEquals(1, quizUnderTest.getNumCorrect());
        assertEquals(1, quizUnderTest.getCurrentQuestionIndex());    
    }        
    
    

}