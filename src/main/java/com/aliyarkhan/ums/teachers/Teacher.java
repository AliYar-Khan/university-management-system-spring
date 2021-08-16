package com.aliyarkhan.ums.teachers;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.aliyarkhan.ums.courses.Course;

@Entity
public class Teacher {
	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", course=" + course + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private Collection<Course> course;
	
	public Collection<Course> getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course.add(course);
	}

	public Teacher() {
		
	}
	
	public Teacher(int id, String name,Collection<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.course = courses;
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
