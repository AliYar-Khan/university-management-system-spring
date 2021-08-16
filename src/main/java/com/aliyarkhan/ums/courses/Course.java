package com.aliyarkhan.ums.courses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Course {
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;


	public Course( ) {
		
	}
	
	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
