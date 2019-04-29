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

public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private GermanyFootballTeam germanyfootballteam = new GermanyFootballTeam();
    private int playerID;
    
    public ReadRecord (int playerID) {
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        this.playerID = playerID;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead() {
        try {
            //set up  a string to hold our query
            String query = "SELECT * FROM GermanyFootballTeam WHERE playerID = ?";
            //create a prepared statement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            //fill in the prepared statement
            ps.setInt(1, playerID);
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            germanyfootballteam.setPlayerID(this.results.getInt("playerID"));
            germanyfootballteam.setPlayerJerseyNumber(this.results.getInt("playerJerseyNumber"));
            germanyfootballteam.setPlayerName(this.results.getString("playerName"));
            germanyfootballteam.setPlayerAge(this.results.getInt("playerAge"));
            germanyfootballteam.setPlayerPOB(this.results.getString("playerPOB"));
            germanyfootballteam.setPlayerPosition(this.results.getString("playerPosition"));
            germanyfootballteam.setPlayerCaps(this.results.getInt("playerCaps"));
            germanyfootballteam.setPlayerGoals(this.results.getInt("playerGoals"));
            germanyfootballteam.setPlayerDomesticClub(this.results.getString("PlayerDomesticClub"));
        
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public GermanyFootballTeam getGermanyFootballTeam() {
       
        return this.germanyfootballteam;
    
    }
    
}

