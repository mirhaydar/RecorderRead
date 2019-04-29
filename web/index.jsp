<%-- 
    Document   : index
    Created on : Mar 6, 2017, 3:15:25 PM
    Author     : nliesmanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Germany Football Team</title>
        <link rel="stylesheet" type="text/css" href="stylesheet.css"/>
    </head>
    <body>
        <div class="wrap"> <!-- div to hold all other divs -->
            <!--Header-->
            <%@include file="includes/header.jsp" %>
            
            <!--Navigation-->
            <%@include file="includes/nav.jsp" %>
            
            <!--Main-->
            <div class="main">

                <h1>Germany Football Team</h1>
                <a href="read">View Current Squad Database</a>
                <br>
                <a href="search.jsp">Search Player</a>
            
            </div>

            <!--Footer-->
            <%@include file="includes/footer.jsp" %>
        </div> <!-- close the wrap div -->
    </body>
</html>
