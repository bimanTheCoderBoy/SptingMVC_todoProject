package com.dao;

import java.util.List;

import com.entities.Todo;

public interface TodoDao {
	void saveTodo(Todo todo);
	List<Todo> getAllDoneTodo();
	public List<Todo> getAllNotDoneTodo();
	void doneTodo(String title);
	void deleteTodo(String title);

}
