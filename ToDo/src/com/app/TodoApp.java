package com.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.app.service.*;
import com.app.model.Todo; 

public class TodoApp {
	public static void main(String [] args) {
		
		
		TodoService todo = new TodoService();
		todo.addTodo("task-1");
		todo.display();
		System.out.println();
		todo.addTodo("task-2");
		todo.display();
		System.out.println();
		todo.editTodo(1, "TASK-1");
		todo.display();
		System.out.println();
		todo.addTodo("task-3");
		todo.display();
		System.out.println();
		todo.addTodo("task-4");
		todo.display();
		System.out.println();
		System.out.println("id is present : "+todo.deleteTodo(1));
		todo.display();
		System.out.println();
		todo.addTodo("task-1");
		todo.display();
		
		System.out.println();
		todo.completeTodo(2);
		todo.display();
		System.out.println();
		todo.completeAll();
		todo.display();
		System.out.println();
		
		List<Todo> list_com = todo.filter(complete->complete.isCompleted());
		System.out.println(list_com);
		
		Comparator<Todo> com = (o1,o2)->Integer.compare(o1.getId(), o2.getId());
		List<Todo> sort_list = todo.sort(com);
		System.out.println(sort_list);
		
	}
}
