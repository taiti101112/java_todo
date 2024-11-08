package sampleServlet;

public class ToDo {
	private int id;
	private String task;
	private boolean completed;
	
	
	public ToDo(int id, String task) {
		this.id = id;
		this.task = task;
		this.completed = false;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTask() {
		return task;
	}
	
	public boolean getCompleted() {
		return completed;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;

	}
}

