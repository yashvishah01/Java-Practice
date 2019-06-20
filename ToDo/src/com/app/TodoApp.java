package com.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.app.service.*;
import com.app.model.Todo; 

public class TodoApp {
	public static void main(String [] args) {
		
		
		TodoService todoService = new TodoService();
//		todo.addTodo("task-1");
//		todo.display();
//		System.out.println();
//		todo.addTodo("task-2");
//		todo.display();
//		System.out.println();
//		todo.editTodo(1, "TASK-1");
//		todo.display();
//		System.out.println();
//		todo.addTodo("task-3");
//		todo.display();
//		System.out.println();
//		todo.addTodo("task-4");
//		todo.display();
//		System.out.println();
//		System.out.println("id is present : "+todo.deleteTodo(1));
//		todo.display();
//		System.out.println();
//		todo.addTodo("task-1");
//		todo.display();
//		
//		System.out.println();
//		todo.completeTodo(2);
//		todo.display();
//		System.out.println();
//		todo.completeAll();
//		todo.display();
//		System.out.println();
//		
//		List<Todo> list_com = todo.filter(complete->complete.isCompleted());
//		System.out.println(list_com);
//		
//		Comparator<Todo> com = (o1,o2)->Integer.compare(o1.getId(), o2.getId());
//		List<Todo> sort_list = todo.sort(com);
//		System.out.println(sort_list);
		
		todoService.addTodo("Nag", "item-1");
		todoService.addTodo("Nag", "item-3");
		todoService.addTodo("Nag", "item-2");
		
		
		todoService.addTodo("BOB", "item-1");
		todoService.addTodo("BOB", "item-2");
		todoService.addTodo("BOB", "item-3");
		
		todoService.display("Nag");
		todoService.display("BOB");
		
		todoService.editTodo("Nag", 3, "item-three");
		
		todoService.completeTodo("Nag", 3);
		todoService.completeTodo("Nag", 3);
		
		todoService.sort("Nag", "title");
		todoService.display("Nag");
		//System.out.println(todoService.size("Nag"));
		
	}
}
