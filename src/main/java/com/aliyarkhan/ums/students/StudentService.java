package com.aliyarkhan.ums.students;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyarkhan.ums.courses.Course;
import com.aliyarkhan.ums.courses.CourseRepository;
import com.aliyarkhan.ums.teachers.Teacher;
import com.aliyarkhan.ums.teachers.TeacherRepository;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	
	public Collection<Course> getAllCourses(int studentId) {
		Student st = studentRepository.findById(studentId).get();
		Collection<Course> courses= st.getCourse();
		return courses;
//		Collection<Teacher> teacher =  Collections.emptyList();
//		courses.forEach(c-> teacher.add(teacherRepository.findByCourseId(c.getId())));
//		
//		return Stream.of(courses, teacher).flatMap(Collection::stream).toArray();
				
	}

	public Course getCourse(int courseId) {
		return courseRepository.findById(courseId).get();
	}

	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	public void addCourse(int id, int courseId) {
		Course course = courseRepository.findById(courseId).get();
		Student st = studentRepository.getById(id);
		if (st.getCourse().size()<5) 
		{
			st.setCourse(course);
			studentRepository.save(st);
		}
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	
	

}
