package sampleServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:h2:~/test"; // H2 DatabaseのURL
    private static final String USER = "sa"; // ユーザー名
    private static final String PASSWORD = ""; // パスワード

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
