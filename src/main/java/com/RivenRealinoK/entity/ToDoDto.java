package com.RivenRealinoK.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoDto {
	
	private int id;
	private String task;
	private Date deadline;

}
