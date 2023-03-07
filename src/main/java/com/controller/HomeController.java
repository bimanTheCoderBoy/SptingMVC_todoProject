package com.controller;


import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.TodoDao;
import com.dao.TodoDaoImpl;
import com.entities.Todo;

@Controller
public class HomeController {
	ApplicationContext ac=new ClassPathXmlApplicationContext("com/controller/controller.xml");	
	TodoDao todoDao=(TodoDao) ac.getBean("todoDaoImpl");
	@RequestMapping("/home")
	public String home(Model m) {
		m.addAttribute("page", "All Tasks");
		TodoDao todoDao=new TodoDaoImpl();
		List<Todo>li=todoDao.getAllDoneTodo();
		m.addAttribute("taskList", li);
		return "home";
		}
	
	@RequestMapping("/homeCompleted")
	public String homeCompleted(Model m) {
		m.addAttribute("page", "Done Tasks");
		TodoDao todoDao=new TodoDaoImpl();
		List<Todo>li=todoDao.getAllNotDoneTodo();
		m.addAttribute("taskList", li);
		return "home";
		}
	
	
	@RequestMapping("/add")
	public String addTodo(Model m) {
		Todo dummy=new Todo();
		m.addAttribute("page", "Add Tasks");
		m.addAttribute("Todo", dummy);
		return "home";
		}
	
	@RequestMapping(value =  "/saveTodo",method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("Todo") Todo todo, Model m) {
		todo.setDone(false);
		todo.setDate(new Date());
		System.out.println(todo);
		TodoDao todoDao=new TodoDaoImpl();
		todoDao.saveTodo(todo);
		return "redirect:/home";
	}
	
	@RequestMapping(value =  "/doneTodo",method = RequestMethod.POST)
	public String doneTodo(@RequestParam("title") String title,Model m) {
		
		TodoDao todoDao=new TodoDaoImpl();
		todoDao.doneTodo(title);
		return "redirect:/home";
	}
	@RequestMapping(value =  "/deleteTodo",method = RequestMethod.POST)
	public String deleteTodo(@RequestParam("title") String title,Model m) {
		
		TodoDao todoDao=new TodoDaoImpl();
		todoDao.deleteTodo(title);
		return "redirect:/homeCompleted";
	}
}
