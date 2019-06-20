package com.app.model;

import java.time.LocalDateTime;

public class Todo {
	private int id;
	private String title;
	private boolean completed;
	private LocalDateTime date;
	
	// no need to pass completed and date
	public Todo(int id, String title/*,boolean completed, LocalDateTime date*/) {
		super();
		this.id = id;
		this.title = title;
		this.completed = false;	//false
		this.date = LocalDateTime.now();	//LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public LocalDateTime getDate() {
		return date;
	}
	
	// not required
//	public void setId(int id) {
//		this.id = id;
//	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	// not required
//	public void setDate(LocalDateTime date) {
//		this.date = date;
//	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", completed=" + completed + ", date=" + date + "]";
	} 
	
	
	
	
}
