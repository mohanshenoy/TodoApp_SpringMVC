package com.infoscilabs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.infoscilabs.model.Todo;
import com.infoscilabs.service.TodoService;

@Controller
@SessionAttributes("userId")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	@RequestMapping(value="/listTodos" ,method = RequestMethod.GET)
	public String listTodos( ModelMap model) {
		List<Todo> todos = service.retrieveTodos("mohan");
		model.put("todos", todos); 
		return "listTodos";
	}
	
	@RequestMapping(value="/addTodo" ,method = RequestMethod.GET)
	public String showAddTodo(ModelMap model) {
		model.addAttribute("todo", new Todo());
		return "addTodo";
	}	
	
	@RequestMapping(value="/addTodo" ,method = RequestMethod.POST)
	public String submitAddTodo( ModelMap model , @Valid Todo todo  , BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		service.addTodo("mohan", todo.getDescription(), new Date(), false);
		model.clear();
		return "redirect:/listTodos";
	}	
	
	@RequestMapping(value="/deleteTodo" ,method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id , ModelMap model) {
		service.deleteTodo(id);
		model.clear();
		return "redirect:/listTodos";
	}	
	
	@RequestMapping(value="/updateTodo" ,method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id , ModelMap model) {
	    Todo todo = service.fetchTodo(id);
	    model.addAttribute("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="/updateTodo" ,method = RequestMethod.POST)
	public String submitUpdateTodo( ModelMap model , @Valid Todo todo  , BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		todo.setUser("mohan");//get it from session 
		todo.setDone(false);
		service.updateTodo(todo);
		model.clear();
		return "redirect:/listTodos";
	}		
}
