package com.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos=  new ArrayList <Todo>();
	private static int todosCount = 0;
	static {
		
		todos.add(new Todo(++todosCount,"nishchal","learnAws",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todosCount,"nishchal","learnAzure",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"nishchal","learnGoogle",LocalDate.now().plusYears(3),false));
		
	}
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate=todo ->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
		
	}
	//this is a logic to add todo.
	public void addTodo(String username, String description,LocalDate targetdate,boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetdate,done);
		todos.add(todo);
	}
	//this is logic to delete todo
	public void deletbyId(int id) {
		
		Predicate<? super Todo> predicate=todo ->todo.getId()==id;
		todos.removeIf(predicate); // first wirte this and import class.
		
	}
	// this is logic to update todo
		public Todo findById(int id) {
			Predicate<? super Todo> predicate=todo ->todo.getId()==id;
			Todo todo =todos.stream().filter(predicate).findFirst().get();
			return todo;
	}
		public void updateTodo(@Valid Todo todo) {
			deletbyId(todo.getId());
			todos.add(todo);
		
			
		}
		
	
	}
	
	

