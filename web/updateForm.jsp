<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.GermanyFootballTeam"%>
<% GermanyFootballTeam germanyfootballteam = (GermanyFootballTeam) request.getAttribute("germanyfootballteam");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Player</title>
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
            <h1>Update A Player Record</h1>

            <form name="updateForm" action="updatePlayer" method="get">

                <table class="update">
                        <tr>
                            <td class="right">Player ID:</td>
                            <td><input type="text" name="playerID" value="<%= germanyfootballteam.getPlayerID() %>" readonly/></td>
                        </tr>

                        <tr>
                            <td class="right">Jersey #:</td>
                            <td><input type="text" name="playerJerseyNumber" value="<%= germanyfootballteam.getPlayerJerseyNumber() %>"/></td>
                        </tr>

                        <tr>
                            <td class="right">Name:</td>
                            <td><input type="text" name="playerName" value="<%= germanyfootballteam.getPlayerName() %>"/></td>
                        </tr>

                        <tr>
                            <td class="right">Age:</td>
                            <td><input type="tex" name="playerAge" value="<%= germanyfootballteam.getPlayerAge() %>"/></td>
                        </tr>

                        <tr>
                            <td class="right">Place of Birth:</td>
                            <td><input type="text" name="playerPOB" value="<%= germanyfootballteam.getPlayerPOB() %>"/></td>
                        </tr>

                        <tr>
                            <td class="right">Position:</td>
                            <td><input type="text" name="playerPosition" value="<%= germanyfootballteam.getPlayerPosition() %>"/></td>
                        </tr>

                        <tr>
                            <td class="right"># of Caps:</td>
                            <td><input type="text" name="playerCaps" value="<%= germanyfootballteam.getPlayerCaps() %>"/></td>
                        </tr>

                        <tr>
                            <td class="right"># of Goals:</td>
                            <td><input type="text" name="playerGoals" value="<%= germanyfootballteam.getPlayerGoals() %>"/></td>
                        </tr>

                        <tr>
                            <td class="right">Domestic Club:</td>
                            <td><input type="text" name="playerDomesticClub" value="<%= germanyfootballteam.getPlayerDomesticClub() %>"/></td>
                        </tr>
                </table>
                <input type="reset" name="reset" value="Clear"/>
                <input type="submit" name="submit" value="Update"/>
            </form>
        </div>

            <!--Footer-->
            <%@include file="includes/footer.jsp" %>
        </div> <!-- close the wrap div -->
    </body>
</html>
