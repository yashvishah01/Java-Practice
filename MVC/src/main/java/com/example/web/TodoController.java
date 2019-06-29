package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Todo;
//import com.sun.net.httpserver.Filter;

@Controller
public class TodoController {

//	@RequestMapping(value = "/todos.htm", method = RequestMethod.GET)
//	public @ResponseBody String getTodos() {
//		return "Get :/todos => TodoController::getTodos";
//	}
//
//	@RequestMapping(value = "todos.htm", method = RequestMethod.GET, params = { "filter=all" })
//	@ResponseBody
//	public String getTodosByFilter() {
//		return "Get :/todos => TodoController::getTodosByFilter";
//	}
//
//	@RequestMapping(value = "todos.htm", method = RequestMethod.GET, headers = { "Accept-Language=en" })
//	@ResponseBody
//	public String getTodosInEnglish() {
//		return "Get :/todos => TodoController::getTodosInEnglish";
//	}

//	@RequestMapping(value = "/todos.htm", method = RequestMethod.POST)
//	public @ResponseBody String postTodo() {
//		return "POST : /todos =>  TodoController :: postTodo()";
//	}
//
//	@RequestMapping(value = "/todos.htm", method = RequestMethod.PUT)
//	public @ResponseBody String putTodo() {
//		return "PUT : /todos =>  TodoController :: putTodo()";
//	}
//
//	@RequestMapping(value = "/todos/completed.htm", method = RequestMethod.GET)
//	public @ResponseBody String getCompletedTodos() {
//		return "GET : /todos/completed.htm =>  TodoController :: getCompletedTodos()";
//	}

//	
//	// way-1
//	@RequestMapping(value = "/todos.htm", method = RequestMethod.POST)
//	public @ResponseBody String postTodo(HttpServletRequest req) {
//		String id=req.getParameter("id");
//		String title=req.getParameter("title");
//		String completed=req.getParameter("completed");
//		
//		
//		Todo todo=new Todo();
//		todo.setId(Integer.parseInt(id));
//		todo.setTitle(title);
//		todo.setCompleted(Boolean.parseBoolean(completed));
//		
//		
//		return "POST : /todos =>  TodoController :: postTodo() => "+todo.toString();
//	}

//	// way-2
//	@RequestMapping(value = "/todos.htm", method = RequestMethod.POST)
//	public @ResponseBody String postTodo(@RequestParam(required=false,defaultValue="0") int id,@RequestParam String title,@RequestParam boolean completed) {
//		
//		Todo todo=new Todo();
//		todo.setId(id);
//		todo.setTitle(title);
//		todo.setCompleted(completed);
//		
//		return "POST : /todos =>  TodoController :: postTodo() => "+todo.toString();
//	}

//	 way-3
//	@RequestMapping(value = "/todos.htm", method = RequestMethod.POST)
//	public @ResponseBody String postTodo1(@ModelAttribute Todo todo,BindingResult result) {
//		if(result.hasErrors()) {
//			return result.getAllErrors()
//						 .stream()
//						 .map(error->error.getDefaultMessage())
//						 .collect(Collectors.joining(",","{","}"));
//		}
//		return "POST : /todos =>  TodoController :: postTodo1() => " + todo.toString();
//	}
//	
//	
//	// way-4
//	@RequestMapping(value = "/todos.htm", method = RequestMethod.POST,consumes= {"application/xml","application/json" })
//	public @ResponseBody String postTodo2(@RequestBody Todo todo, BindingResult result) {
//		if (result.hasErrors()) {
//			return result.getAllErrors().stream().map(error -> error.getDefaultMessage())
//					.collect(Collectors.joining(",", "{", "}"));
//		}
//		return "POST : /todos =>  TodoController :: postTodo2() => " + todo.toString();
//	}

	// way-4
//	@RequestMapping(value = "/todos.htm", method = RequestMethod.POST, consumes = { "application/json" })
//	public @ResponseBody String postTodo3(@RequestBody Todo todo, BindingResult result) {
//		if (result.hasErrors()) {
//			return result.getAllErrors().stream().map(error -> error.getDefaultMessage())
//					.collect(Collectors.joining(",", "{", "}"));
//		}
//		return "POST : /todos =>  TodoController :: postTodo3() => " + todo.toString();
//	}
//	

	@RequestMapping(value = "/todos", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public @ResponseBody Todo getTodos1() {
		Todo todo = new Todo();
		todo.setId(1);
		todo.setTitle("Live Life");
		todo.setCompleted(false);
		return todo;
	}

}
