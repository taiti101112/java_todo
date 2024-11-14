package sampleServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private static final String JDBC_URL = "jdbc:h2:~/todo";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";
    
    static {
    	try(Connection conn = getConnection();
    		Statement stmt = conn.createStatement()){
    		String sql = "CREATE TABLE IF NOT EXISTS todo (" +
    					 "id INT PRIMARY KEY, " +
    					 "task VARCHAR(255), " +
    					 "completed BOOLEAN)";
    		stmt.execute(sql);
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} 	
    }
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.h2.Driver");  // H2ドライバーをロード
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
    }
}
