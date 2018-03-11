/**
 *
 * @author noukist
 */
import java.sql.*;
import javax.swing.*;
public class Javaconnect 
{
    Connection conn = null;
    
    public static Connection ConnectDb()
    {
        
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "dissert";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root";
	String password = "";
	try 
        {
	     Class.forName(driver);
	     Connection conn = DriverManager.getConnection(url+dbName,userName,password);
             //JOptionPane.showMessageDialog(null, "Connection Established.");
             return conn;
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
            return null;            
        }
        
    }
}

