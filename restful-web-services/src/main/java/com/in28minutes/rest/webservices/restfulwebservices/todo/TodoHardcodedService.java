package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	
	private static long idCounter = 0;
	
	static {
		
		todos.add(new Todo(++idCounter, "Miro","Learn to Dance",new Date(), false));
		todos.add(new Todo(++idCounter, "Miro","Learn Angular",new Date(), false));
		todos.add(new Todo(++idCounter, "Miro","Learn Docker",new Date(), false));
		
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	//delete
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if(todo==null) {
			return null;
		}
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
		
	}
	public Todo findById(long id) {
		for(Todo todo : todos) {
			if(todo.getId() == id)
				return todo;
		}
		return null;
	}
}
