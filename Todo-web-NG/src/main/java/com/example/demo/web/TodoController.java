package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("api/v1/todos")
public class TodoController {

	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping
	public List<Todo> getAllTodos(){
		System.out.println("all todos");
		return todoRepository.findAll();
	}
	
	@DeleteMapping(value = "/{todoId}")
	public void deleteTodo(@PathVariable("todoId") int id){
		System.out.println(id);
		todoRepository.deleteById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addTodo(@RequestBody Todo todo) {
		todo=todoRepository.save(todo);
		ResponseEntity<Todo> responseEntity=new ResponseEntity<Todo>(todo, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping(value="/clearTodo")
	public void clearcompleted() {
		List<Todo> todos = todoRepository.findAll();
		for (Todo todo : todos) {
			if(todo.isCompleted())
				todoRepository.delete(todo);
		}
	}
	
	@PostMapping(value="/completeAll")
	public void completeTodoAll(){
		List<Todo> todos = todoRepository.findAll();
		for (Todo todo : todos) {
			todo.setCompleted(true);
			todoRepository.save(todo);
		}
	}

	@PostMapping(value="/incompleteAll")
	public void incompleteTodoAll(){
		List<Todo> todos = todoRepository.findAll();
		for (Todo todo : todos) {
			todo.setCompleted(false);
			todoRepository.save(todo);
		}
	}
	
	@PutMapping(value="/completeTodo")
	public  Todo completeTodo(@RequestBody Todo todo) {
		System.out.println("putmapping");
		todo.setCompleted(true);
		return todoRepository.save(todo);
	}
	
	@PutMapping(value="/incompleteTodo")
	public  Todo incompleteTodo(@RequestBody Todo todo) {
		System.out.println("putmapping");
		todo.setCompleted(true);
		return todoRepository.save(todo);
	}
	
	
}
