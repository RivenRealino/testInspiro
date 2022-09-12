package com.RivenRealinoK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.RivenRealinoK.entity.ToDoEntity;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Integer>{
	
	@Query("from ToDoEntity where Id = :Id")
	public ToDoEntity findOneTaskByID(@Param(value = "Id") int Id);

}
