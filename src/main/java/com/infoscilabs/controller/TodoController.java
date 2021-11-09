package com.infoscilabs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		List<Todo> todos = service.retrieveTodos(retrieveLoggedInUserId());
		model.put("todos", todos); 
		return "listTodos";
	}


	private String retrieveLoggedInUserId() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	@RequestMapping(value="/addTodo" ,method = RequestMethod.GET)
	public String showAddTodo(ModelMap model) {
		//throw new RuntimeException( "Dummy exception raised");
		model.addAttribute("todo", new Todo());
		return "addTodo";
	}	
	
//	private Log logger = LogFactory.getLog(ExceptionController.class);
	
//	@ExceptionHandler(value = Exception.class)
//	public String handleError(HttpServletRequest req, Exception exception) {
//		logger.error("Request: " + req.getRequestURL() + " raised " + exception);
//		return "error-specific";
//	}
	
	
	@RequestMapping(value="/addTodo" ,method = RequestMethod.POST)
	public String submitAddTodo( ModelMap model , @Valid Todo todo  , BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		service.addTodo(retrieveLoggedInUserId(), todo.getDescription(), new Date(), false);
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
		todo.setUser(retrieveLoggedInUserId());//get it from session 
		todo.setDone(false);
		service.updateTodo(todo);
		model.clear();
		return "redirect:/listTodos";
	}		
}
