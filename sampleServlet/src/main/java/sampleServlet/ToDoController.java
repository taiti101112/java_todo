package sampleServlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todo")
public class ToDoController extends HttpServlet {
	private ToDoList toDoList = new ToDoList();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    res.setContentType("text/html; charset=UTF-8");
	    
		req.setAttribute("toDoList", toDoList);
		req.getRequestDispatcher("/todo.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8"); 
	    res.setContentType("text/html; charset=UTF-8");
	    		
		String action = req.getParameter("action");
		if ("add".equals(action)) {
			String task = req.getParameter("task");
			toDoList.addTask(task);
		} else if ("toggle".equals(action)) {
			int id = Integer.parseInt(req.getParameter("id"));
			toDoList.toggleTask(id);
		} else if ("delete".equals(action)) {
			int id = Integer.parseInt(req.getParameter("id"));
			toDoList.deleteTask(id);
		}
		res.sendRedirect("todo");
	}
}


