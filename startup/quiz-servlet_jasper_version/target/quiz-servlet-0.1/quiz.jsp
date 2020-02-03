<%@ page isELIgnored="false" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
    <html class="no-js">
    <!--<![endif]-->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Number Quize</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="">
    </head>

    <body>
        <form method="POST" action="age">
            <input type="number" name="age" />
            <br>
            <p style='color:red'>${param['ageError'] == null?'':param['ageError']?'Please enter a valid Age. Age between 4 and 100':''}</p>
            <button type="submit">Enter</button>
        </form><br><br>
        <form method='post'>
            <h3>Have fun with NumberQuiz!</h3>
            <p>Your current score is: ${getNumCorrect}</br>
                </br>
            </p>
            <p>Guess the next number in the sequence! ${currQuest} </p>
            <p>Your answer:<input type='text' name='answerInput' /></p>


            <p style='color:red'>${error}</p>

            <p><input type='submit' name='btnNext' value='Next' /></p>
        </form>
    </body>

    </html>