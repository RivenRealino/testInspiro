package com.RivenRealinoK.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.RivenRealinoK.entity.ToDoDto;
import com.RivenRealinoK.entity.ToDoEntity;

import com.RivenRealinoK.service.ToDoService;

public class Inspiro_rest_controller {
	
	@Autowired
	ToDoService todoSvc;
	
//	@GetMapping(path = "/hello") 
//	public String test() throws Exception {
//		return "Hello";
//	}
	
	@GetMapping(path = "/listAllToDo") 
	public List<ToDoEntity> listSemuaToDo() throws Exception {
		return todoSvc.findAllToDo();
	}
	
	@GetMapping(path = "/findToDo") 
	public ToDoEntity findToDo(@RequestParam int id) throws Exception {
		return todoSvc.findToDo(id);
	}
	
	
	@PostMapping(path = "/addToDo") 
	public String addIndInvestor(@RequestBody ToDoDto entity) throws Exception {
		
		try {
			todoSvc.AddNewToDo(entity);
		
			return "Add Dilaksanakan";
		} catch(Exception e) {
			return e.getMessage();
		}
	}
	
	@PostMapping(path = "/updateToDo") 
	public String updateToDo(@RequestBody ToDoDto entity) throws Exception {
		
		try {
			todoSvc.updateToDo(entity);
		
			return "Update Dilaksanakan";
		} catch(Exception e) {
			return e.getMessage();
		}
	}
	
	@GetMapping(path = "/deleteToDo") 
	public String deleteToDo(@RequestParam int id) throws Exception {
		return todoSvc.deleteToDo(id);
	}
		

}
