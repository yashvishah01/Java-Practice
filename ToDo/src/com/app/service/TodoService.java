package com.app.service;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.app.model.Todo;

//Todo todo1 = new Todo(1,);

public class TodoService {

//	List<Todo> todos = new ArrayList<>();
//		int id =0;
//			public void addTodo(String title) {
//				id++;
//				todos.add(new Todo(id,title,false,LocalDateTime.now()));
//			}
			
	
	private static AtomicInteger atomicInteger = new AtomicInteger(0);
	
	private Map<String, List<Todo>> todosMap = new HashMap<>();
	
	public void addTodo(String user,String title) {
		Todo todo =new Todo(atomicInteger.incrementAndGet(),title);
		List<Todo> todos = todosMap.get(user);
		if(todos==null) {
			todos = new ArrayList<>();
			todos.add(todo);
			todosMap.put(user, todos);
		}
		else {
			todos.add(todo);
			todosMap.put(user, todos);
		}
	}
	
	public void editTodo(String user, int id, String newTitle) {
		List<Todo> todos = todosMap.get(user);
		todos.forEach(item -> {
			if (item.getId() == id) {
				item.setTitle(newTitle);
				return;
			}
		});
	}

	public void completeTodo(String user, int id) {
		List<Todo> todos = todosMap.get(user);
		todos.forEach(item -> {
			if (item.getId() == id) {
				item.setCompleted(!item.isCompleted());
				return;
			}
		});
	}

	public void deleteTodo(String user, int id) {
		List<Todo> todos = todosMap.get(user);
		todos.removeIf(item -> item.getId() == id);
	}

	public void clearCompleted(String user) {
		List<Todo> todos = todosMap.get(user);
		todos.removeIf(item -> item.isCompleted());
	}

	public void completeAll(String user) {
		List<Todo> todos = todosMap.get(user);
		boolean isAllCompleted = todos.stream().allMatch(item -> item.isCompleted());
		todos.replaceAll(item -> {
			item.setCompleted(!isAllCompleted);
			return item;
		});
	}

	public List<Todo> get(String user, String filter) {
		List<Todo> todos = todosMap.get(user);
		switch (filter) {
		case "ALL":
			return todos;
		case "ACTIVE":
			return todos
					.stream()
					.filter(item->!item.isCompleted())
					.collect(Collectors.toList());
		case "COMLETED":
			return todos
					.stream()
					.filter(item->item.isCompleted())
					.collect(Collectors.toList());	
		default:
			return new ArrayList<>();
		}
	}
	
	public List<Todo> sort(String user, String property) {
		List<Todo> todos = todosMap.get(user);
		switch (property) {
		case "id":
			return todos
					.stream()
					.sorted(Comparator.comparingInt(Todo::getId))
					.collect(Collectors.toList());
		case "title":
			return todos
					.stream()
					.sorted(Comparator.comparing(Todo::getTitle))
					.collect(Collectors.toList());
		default:
			return new ArrayList<>();
		}
	}
	

	public int size(String user) {
		return todosMap.get(user).size();
	}


	
//			public void editTodo(int id,String newTitle) {
////					todos
////					.stream()
////					.filter(t->t.getId()==id)
////					.forEach(todo->todo.setTitle(newTitle));
//				
//					this.todos.replaceAll(todo -> {
//						if (todo.getId() == id) {
//							todo.setTitle(newTitle);
//						}
//						return todo;
//					});		
//			}
//			
//			public boolean deleteTodo(int id) {
//				boolean ans = todos.removeIf(todo->todo.getId()==id);
//				return ans;
//			}
//			
//
//			public void completeTodo(int id) {	//toggle
//				this.todos.replaceAll(todo->{
//					if(todo.getId() == id) {
//						todo.setCompleted(true);
//					}
//					return todo;
//				});
//			}
//			
//			public void completeAll() {
//				this.todos.replaceAll(todo->{
//						if(todo.isCompleted()==true)
//							todo.setCompleted(false);
//						else
//							todo.setCompleted(true);
//					
//					return todo;
//				});
//				
//	//			todos.replaceAll(todo->todo.setCompleted(!todo.isCompleted()););
//			}
//			 
//			public void clearComplete() {		//int
//				todos.removeIf(todo->todo.isCompleted());
//			}
//			
//			public List<Todo> filter(Predicate<Todo> predicate){
//				
//				List<Todo> list=
//				todos
//				.stream()
//				.filter(predicate)
//				.collect(Collectors.toList());
//				return list;
//			}
//			
//			public List<Todo> sort(Comparator<Todo> com){
//						List<Todo> sort_list=
//						todos
//						.stream()
//						.sorted(com)
//						.collect(Collectors.toList());
//						return sort_list;
//					}
//					
//			public void display() {
//					for(Todo t: todos) {
//						System.out.println( t.getId()+" "+t.getTitle()+" "+t.isCompleted()+" "+t.getDate());
//					}
//			}
		
	
	public void display(String user) {
		todosMap.get(user).forEach(System.out::println);
		System.out.println();
	}
	
			
}
