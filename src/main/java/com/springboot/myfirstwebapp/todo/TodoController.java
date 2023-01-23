package com.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class TodoController {
	@Autowired	
	private TodoService todoService;
	
	@RequestMapping("List-todos") // it display todo list in the jsp
	public String listAllTodos(ModelMap model) {
		String username =getLoggedInUsername(model);
		List<Todo> todos =todoService.findByUsername(username);
		model.addAttribute("todos", todos);
		return "listTodos";
	}

	@RequestMapping(value = "add-todo", method=RequestMethod.GET) // it will show add todo page
	public String showNewTodopage(ModelMap model) {
		String username =getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(4), false);
		model.put("todo", todo);
			return "todo";
	}
	@RequestMapping(value = "add-todo", method=RequestMethod.POST) // it add new new todo
	public String addNewTodo( ModelMap model,@Valid Todo todo, BindingResult result ) { // valid is used to valid description input
		if(result.hasErrors()){
			return "todo";
		}
		String username =getLoggedInUsername(model);
		todoService.addTodo(username, todo.getDescription(),todo.getTargetDate(), false);
		
			return "redirect:List-todos"; // here we are redirecting to list- todos page path  after we added.
	}
	//implemet delete function
	@RequestMapping("delete-todo") 
	public String deleteTodo(@RequestParam int id) {
		todoService.deletbyId(id);
		return "redirect:List-todos";
			
	}
	//implemet update function
	@RequestMapping(value = "update-todo",method=RequestMethod.GET) // it display todo list in the jsp
	public String showupdateTodoPage(@RequestParam int id,ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
				
	}	
	@RequestMapping(value = "update-todo", method=RequestMethod.POST) // it add new new todo
	public String updatedo( ModelMap model,@Valid Todo todo, BindingResult result ) { // valid is used to valid description input
		if(result.hasErrors()){
			return "todo";
		}
		String username =getLoggedInUsername(model);
		todo.setUsername(username);
		todoService.updateTodo(todo);
			return "redirect:List-todos"; // here we are redirecting to list- todos page path  after we added.
	}
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}

