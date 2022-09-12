package com.RivenRealinoK.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ToDoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "create_date", nullable = false)
	private LocalDateTime createDate;
	
	@Column(name = "task", nullable = false)
	private String task;
	
	@Column(name = "deadline", nullable = false)
	private Date deadline;
	


}
