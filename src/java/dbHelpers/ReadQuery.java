/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GermanyFootballTeam;

/**
 *
 * @author nliesmanto
 */
public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery() {
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead() {
        try {
            String query = "Select * FROM GermanyFootballTeam ORDER BY playerID ASC";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getHTMLTable() {
        String table = "";
        table += "<table>";
        
        table += "<tr>";

            table += "<th>";
            table += "ID"; 
            table += "</th>";
                
            table += "<th>";
            table += "Jersey #";
            table += "</th>";
                
            table += "<th>";
            table += "Name";
            table += "</th>";
                
            table += "<th>";
            table += "Age";
            table += "</th>";
                
            table += "<th>";
            table += "POB";
            table += "</th>";
                 
            table += "<th>";
            table += "Position";
            table += "</th>";
                
            table += "<th>";
            table += "Caps";
            table += "</th>";
                
            table += "<th>";
            table += "Goals";
            table += "</th>";
                
            table += "<th>";
            table += "Domestic Club";
            table += "</th>";
            
            table += "<th>";
            table += " ";
            table += "</th>";
            
        table += "</tr>";
        
        try {
            while(this.results.next()) {
                GermanyFootballTeam germanyfootballteam = new GermanyFootballTeam();
                germanyfootballteam.setPlayerID(this.results.getInt("playerID"));
                germanyfootballteam.setPlayerJerseyNumber(this.results.getInt("playerJerseyNumber"));
                germanyfootballteam.setPlayerName(this.results.getString("playerName"));
                germanyfootballteam.setPlayerAge(this.results.getInt("playerAge"));
                germanyfootballteam.setPlayerPOB(this.results.getString("playerPOB"));
                germanyfootballteam.setPlayerPosition(this.results.getString("playerPosition"));
                germanyfootballteam.setPlayerCaps(this.results.getInt("playerCaps"));
                germanyfootballteam.setPlayerGoals(this.results.getInt("playerGoals"));
                germanyfootballteam.setPlayerDomesticClub(this.results.getString("PlayerDomesticClub"));
                
                table += "<tr>";
                
                table += "<td>";
                table += germanyfootballteam.getPlayerID();
                table += "</td>";
                
                table += "<td>";
                table += germanyfootballteam.getPlayerJerseyNumber();
                table += "</td>";
                
                table += "<td>";
                table += germanyfootballteam.getPlayerName();
                table += "</td>";
                
                table += "<td>";
                table += germanyfootballteam.getPlayerAge();
                table += "</td>";
                
                table += "<td>";
                table += germanyfootballteam.getPlayerPOB();
                table += "</td>";
                
                table += "<td>";
                table += germanyfootballteam.getPlayerPosition();
                table += "</td>";
                
                table += "<td>";
                table += germanyfootballteam.getPlayerCaps();
                table += "</td>";
                
                table += "<td>";
                table += germanyfootballteam.getPlayerGoals();
                table += "</td>";
                
                table += "<td>";
                table += germanyfootballteam.getPlayerDomesticClub();
                table += "</td>";
                
                table += "<td>";
                table += "<a href=update?playerID=" + germanyfootballteam.getPlayerID() + "> Update </a>" + "<a href=delete?playerID=" + germanyfootballteam.getPlayerID() + ">Delete</a>";
                table += "</td>";
                
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table +="</table>";
        return table;
    }

}

