package sampleServlet;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
	private List<ToDo> tasks = new ArrayList<>();
	private int currentId = 0;
	
	public void addTask(String task) {
		tasks.add(new ToDo(currentId++, task));
	}
	
	public List<ToDo> getTasks(){
		return tasks;
	}
	
	public void toggleTask(int id) {
		for(ToDo task : tasks) {
			if(task.getId() == id) {
				task.setCompleted(!task.getCompleted());
				break;
			}
		}
	}
	
	public  void deleteTask(int id) {
		tasks.removeIf(task -> task.getId() == id);
	}
}
