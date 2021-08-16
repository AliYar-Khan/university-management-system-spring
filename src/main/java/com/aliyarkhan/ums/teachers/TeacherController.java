package com.aliyarkhan.ums.teachers;

import java.util.List;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aliyarkhan.ums.courses.Course;
import com.aliyarkhan.ums.students.Student;


@RestController
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	
	@RequestMapping("/teachers")
	public List<Teacher> getAllTeachers() {
		return teacherService.getAllTeachers();
	}
	
	@RequestMapping("/teacher/{id}")
	public Teacher getTeacher(@PathVariable int id) {
		return teacherService.getTeacher(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/teachers")
	public void addTeacher(@RequestBody Teacher teacher) {
		teacherService.addTeacher(teacher);
	}
	
	@RequestMapping("/teacher/{id}/courses")
	public Collection<Course> getCourses(@PathVariable int id) {
		return teacherService.getCourses(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/teacher/{id}/course/{courseId}")
	public void addCourse(@PathVariable int id,@PathVariable int courseId) {
		teacherService.addCourse(id,courseId);
	}
	
	@RequestMapping("/teacher/{id}/course/{courseId}")
	public List<Student> getCourses(@PathVariable int id,@PathVariable int courseId) {
		return teacherService.getCourses(id,courseId);
	}
	
}
