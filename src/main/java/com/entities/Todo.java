package com.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Todo {
	@Id
	private String title;
	private String message;
	private Date date;
	private boolean done;
	public Todo(String title, String message, Date date, boolean done) {
		super();
		this.title = title;
		this.message = message;
		this.date = date;
		this.done = done;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Todo(String title, boolean done, String message) {
		super();
		this.title = title;
		this.done = done;
		this.message = message;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public Todo(String title, String message) {
		super();
		this.title = title;
		this.message = message;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
//	public Date getDate() {
//		return date;
//	}
//	public void setDate(Date date) {
//		this.date = date;
//	}

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Todo [title=" + title + ", message=" + message + ", date=" + date + ", done=" + done + "]";
	}

}
