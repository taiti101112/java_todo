package sampleServlet;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseUtil.getConnection();
            System.out.println("H2 Databaseに接続成功！");
            connection.close();
        } catch (SQLException e) {
            System.out.println("H2 Databaseに接続できませんでした:");
            e.printStackTrace();
        }
    }
}
