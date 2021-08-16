package com.aliyarkhan.ums.students;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyarkhan.ums.courses.Course;
import com.aliyarkhan.ums.teachers.Teacher;
import com.aliyarkhan.ums.teachers.TeacherService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	
	
	@RequestMapping("/students")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}
	
	@RequestMapping("/student/{id}/courses")
	public Collection<Course> getAllCourses(@PathVariable int id) {
		return studentService.getAllCourses(id);
	}
	
	@RequestMapping("/student/{id}/course/{courseId}/teacher")
	public Teacher getTeacherByCourseId(@PathVariable int courseId) {
		return teacherService.getTeacherByCourseId(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/students")
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/student/{id}/course/{courseId}")
	public void addCourse(@PathVariable int id,@PathVariable int courseId) {
		studentService.addCourse(id,courseId);
	}
	
	
	@RequestMapping("/student/{id}/course/{courseId}")
	public Course getCourse(@PathVariable int courseId) {
		return studentService.getCourse(courseId);
	}
	
}
