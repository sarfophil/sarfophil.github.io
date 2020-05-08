<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Calculator</title>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>

    <body>
        <div class="container">
            <div class="row">
                <form action="result" method="POST">
                    <% Integer additionResult = (Integer)request.getAttribute("additionResult");%>
                        <% Integer multiplyResult = (Integer)request.getAttribute("multiplyResult");%>
                            <% Integer inputPlus1 = (Integer)request.getAttribute("inputPlus1");%>
                                <% Integer inputPlus2 = (Integer)request.getAttribute("inputPlus2");%>
                                    <% Integer inputMultiply1 = (Integer)request.getAttribute("inputMultiply1");%>
                                        <% Integer inputMultiply2 = (Integer)request.getAttribute("inputMultiply2");%>


                                            <div class="col-md-12">
                                                <input type="number" name="inputPlus1" value=<%=inputPlus1%> /> +
                                                <input type="number" name="inputPlus2" value=<%=inputPlus2%> /> =

                                                <input type="number" value=<%=additionResult%> />
                                            </div>
                                            <br>
                                            <div class="col-md-12">
                                                <input type="number" name="inputMultiply1" value=<%=inputMultiply1%> /> *
                                                <input type="number" name="inputMultiply2" value=<%=inputMultiply2%>> =

                                                <input type="number" value=<%=multiplyResult%> />
                                            </div>

                                            <p>

                                            </p>
                                            <br>
                                            <div class="col-md-12">
                                                <button class="btn btn-success" type="submit">Calculate</button>
                                            </div>
                </form>
            </div>
        </div>
    </body>

    </html>