package com.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.app.model.Todo;

//Todo todo1 = new Todo(1,);

public class TodoService {

	List<Todo> todos = new ArrayList<>();
		int id =0;
			public void addTodo(String title) {
				id++;
				todos.add(new Todo(id,title,false,LocalDateTime.now()));
			}
			
			public void editTodo(int id,String newTitle) {
//					todos
//					.stream()
//					.filter(t->t.getId()==id)
//					.forEach(todo->todo.setTitle(newTitle));
				
					this.todos.replaceAll(todo -> {
						if (todo.getId() == id) {
							todo.setTitle(newTitle);
						}
						return todo;
					});		
			}
			
			public boolean deleteTodo(int id) {
				boolean ans = todos.removeIf(todo->todo.getId()==id);
				return ans;
			}
			

			public void completeTodo(int id) {	//toggle
				this.todos.replaceAll(todo->{
					if(todo.getId() == id) {
						todo.setCompleted(true);
					}
					return todo;
				});
			}
			
			public void completeAll() {
				this.todos.replaceAll(todo->{
						if(todo.isCompleted()==true)
							todo.setCompleted(false);
						else
							todo.setCompleted(true);
					
					return todo;
				});
			}
			 
			public void clearComplete() {		//int
				todos.removeIf(todo->todo.isCompleted());
			}
			
			public List<Todo> filter(Predicate<Todo> predicate){
				
				List<Todo> list=
				todos
				.stream()
				.filter(predicate)
				.collect(Collectors.toList());
				return list;
			}
			
			public List<Todo> sort(Predicate<Todo> predicate){
						List<Todo> sort_list=
						todos
						.stream()
						.filter(predicate)
						.collect(Collectors.toList());
						return sort_list;
					}
					
			public void display() {
					for(Todo t: todos) {
						System.out.println( t.getId()+" "+t.getTitle()+" "+t.isCompleted()+" "+t.getDate());
					}
			}
			
			
}
