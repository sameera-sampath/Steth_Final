/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package steth_final;

/**
 *
 * @author Sameera
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class sqlcon 
{
    static ResultSet rs = null;
    static Statement stmt = null;    
    static Connection dbCon = null;
    static String dbURL = "jdbc:mysql://localhost:3306/PATIENT";
    static String username ="root";
    static String password = "rhssn";
    static boolean notconnect=true;
    
    public sqlcon()
    {
        if(notconnect)
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                dbCon = DriverManager.getConnection(dbURL, username, password);
                notconnect=false;
            } catch (    SQLException | ClassNotFoundException ex) {
                notconnect=true;
                Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public String[] execute(String query)
    {
        String result[]=null;
        try {
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            if(rs.next()) 
            {
                result=new String[4];
                result[0]=rs.getString(1);
                result[1]=rs.getString(2);
                result[2]=rs.getString(3);
                result[3]=rs.getString(4);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean insert(String insert)
    {
        try {
            stmt = dbCon.prepareStatement(insert);
            stmt.executeUpdate(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public int max(String query)
    {
        int result=1;
        try {
            stmt = dbCon.prepareStatement(query);
            rs = stmt.executeQuery(query);
            if(rs.next()) 
            { 
                result+=rs.getInt(1);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
       
}
