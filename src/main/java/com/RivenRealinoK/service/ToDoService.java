package com.RivenRealinoK.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.RivenRealinoK.entity.ToDoDto;
import com.RivenRealinoK.entity.ToDoEntity;
import com.RivenRealinoK.repository.ToDoRepository;

public class ToDoService {
	
	@Autowired
	ToDoRepository todoRepo;
	
	public List<ToDoEntity> findAllToDo() {
		return todoRepo.findAll();
	}
	
	public ToDoEntity findToDo(int id) {
		return todoRepo.findOneTaskByID(id);
	}
	
	public String AddNewToDo(ToDoDto requestBody) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));

			ToDoEntity todoBaru = new ToDoEntity();
			todoBaru.setCreateDate(now);
			todoBaru.setTask(requestBody.getTask());
			todoBaru.setDeadline(requestBody.getDeadline());

			todoRepo.saveAndFlush(todoBaru);

			return "done";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String updateToDo(ToDoDto requestBody) {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));

			ToDoEntity todoBaru = todoRepo.findOneTaskByID(requestBody.getId());
			todoBaru.setTask(requestBody.getTask());
			todoBaru.setDeadline(requestBody.getDeadline());

			todoRepo.saveAndFlush(todoBaru);

			return "done";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String deleteToDo (int id) {
		todoRepo.deleteById(id);
		
		return "To Do Deleted";
	}

}
