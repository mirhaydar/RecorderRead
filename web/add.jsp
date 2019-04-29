<%-- 
    Document   : add
    Created on : Mar 27, 2017, 9:54:25 AM
    Author     : nliesmanto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A Player</title>
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
        
        <h1>Add A Player</h1>
        
        <form name="addForm" action="addPlayer" method="get">
            <table class="add">
                <tr>
                    <td class="right">Jersey #:</td>
                    <td><input type="text" name="playerJerseyNumber" value=""/></td>
                </tr>

                <tr>
                    <td class="right">Name:</td>
                    <td><input type="text" name="playerName" value=""/></td>
                </tr>

                <tr>
                    <td class="right">Age:</td>
                    <td><input type="text" name="playerAge" value=""/></td>
                </tr>

                <tr>
                    <td class="right">Place of Birth:</td>
                    <td><input type="text" name="playerPOB" value=""/></td>
                </tr>

                <tr>
                    <td class="right">Position:</td>
                    <td><input type="text" name="playerPosition" value=""/></td>
                </tr>

                <tr>
                    <td class="right"># of Caps:</td>
                    <td><input type="text" name="playerCaps" value=""/></td>
                </tr>

                <tr>
                    <td class="right"># of Goals:</td>
                    <td><input type="text" name="playerGoals" value=""/></td>
                </tr>

                <tr>
                    <td class="right">Domestic Club:</td>
                    <td><input type="text" name="playerDomesticClub" value=""/></td>
                </tr>
            </table>
            <input type="submit" name="submit" value="Submit"/>
        </form>
        </div>

            <!--Footer-->
            <%@include file="includes/footer.jsp" %>
        </div> <!-- close the wrap div -->
    </body>
</html>
