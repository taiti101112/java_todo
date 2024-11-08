<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<jsp:useBean id="toDoList" class="sampleServlet.ToDoList" scope="request" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ToDoリスト</title>
</head>
<body>
	<h1>ToDoリスト</h1>
	<form action="todo" method="post">
		<input type="text" name="task" placeholder="新しいタスク">
		<button type="submit" name="action" value="add">追加</button>
	</form>
	<ul>
		<%
			java.util.List<sampleServlet.ToDo> tasks = toDoList.getTasks();
			for (sampleServlet.ToDo task : tasks) {
		%>
			<li>
				<form action="todo" method="post" style="display:inline">
					<input type="hidden" name="id" value="<%= task.getId() %>">
					<button type="submit" name="action" value="toggle">
						<%= task.getCompleted() ? "未完了" : "完了" %>
					</button>
				</form>
				<form action="todo" method="post" style="display:inline">
				    <input type="hidden" name="id" value="<%= task.getId() %>">
    				<button type="submit" name="action" value="delete">削除</button>
				</form>
				<%= task.getTask() %>
			</li>
		<%
			}
		%>
	</ul>
</body>
</html>


