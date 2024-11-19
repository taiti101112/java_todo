// getConnection() →　データベースへの接続を作成し、成功するとConnectionオブジェクト(プログラムがデータベースとやり取りする入り口)を返す

// createStatement()　→　データベースとやり取りをするためのSQL文を実行するために必要なStatementオブジェクトを作成する、これがあることによってSQLを使ってのデータの操作が可能になる

//　executeQuery() →　データベースに対してSQL文を実行するメソッドで実行結果としてResultSetオブジェクトを返す

// getInt() →　データベースから取得した結果(ResultSet)の特定の列kら整数型のデータを取り出すメソッド

// prepareStatement()　→　SQL文にパラメータ（?で指定した値）を設定し、安全にSQL文を実行するためのオブジェクトを返すメソッド

// executeUpdate()　→　データを変更するSQL文をデータベースに送信して実行するメソッド

package sampleServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ToDoList {
	private int currentId = 0;
	
	// 現在のtaskオブジェクトの一番大きいIDから+1した数を取得して、それを新しく作成したtaskオブジェクトのIDにする
	public ToDoList() {
		try(Connection conn = DatabaseInitializer.getConnection();
			Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS max_id FROM todo");
			if(rs.next()) {
				currentId = rs.getInt("max_id");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void addTask(String task) {
		try(Connection conn = DatabaseInitializer.getConnection()){
			String sql = "INSERT INTO todo(id, task, completed) VALUES(?, ?, ?)";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, currentId++);
				stmt.setString(2, task);
				stmt.setBoolean(3, false);
				stmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	public List<ToDo> getTasks(){
		List<ToDo> tasks = new ArrayList<>();
		try(Connection conn = DatabaseInitializer.getConnection();
			Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery("SELECT * FROM todo");
			while(rs.next()) {
				ToDo task = new ToDo(rs.getInt("id"), rs.getString("task"));
				task.setCompleted(rs.getBoolean("completed"));
				tasks.add(task);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}
	
	
	public void toggleTask(int id) {
		try(Connection conn = DatabaseInitializer.getConnection()){
			String sql = "UPDATE todo SET completed = NOT completed WHERE id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, id);
				stmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteTask(int id) {
		try(Connection conn = DatabaseInitializer.getConnection()){
			String sql = "DELETE FROM todo WHERE id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, id);
				stmt.executeUpdate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
