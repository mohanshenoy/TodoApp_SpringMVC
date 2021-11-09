package com.infoscilabs.controller.restws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.infoscilabs.model.Todo;
import com.infoscilabs.service.TodoService;

@RestController
public class TodoRestController {

	@Autowired
	TodoService service;
	
	@RequestMapping(path="/todos")
	public List<Todo> fetchAllTodos(){
		return service.retrieveTodos("mohan");
	}
	
	@RequestMapping(path="/todos/{id}")
	public Todo fetchTodo(@PathVariable int id){
		return service.fetchTodo(id);
	}	

}