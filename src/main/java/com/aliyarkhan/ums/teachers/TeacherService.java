package com.aliyarkhan.ums.teachers;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aliyarkhan.ums.courses.Course;
import com.aliyarkhan.ums.courses.CourseRepository;
import com.aliyarkhan.ums.students.Student;
import com.aliyarkhan.ums.students.StudentRepository;


@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Teacher> getAllTeachers() {
		List<Teacher> teachers = new ArrayList<>();
		teacherRepository.findAll().forEach(teachers::add);
		return teachers;
	}
	
	public Teacher getTeacher(int id) {
		return teacherRepository.findById(id).get();
	}

	public void addTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
	}

	public Collection<Course> getCourses(int id) {
		Teacher t = teacherRepository.findById(id).get();
		return t.getCourse();
	}


	public void addCourse(int id, int courseid) {
		Course course = courseRepository.findById(courseid).get();
		Teacher t = teacherRepository.findById(id).get();
		if (t.getCourse().size() < 3)
		{
			t.setCourse(course);
			teacherRepository.save(t);
		}
	}

	public List<Student> getCourses(int id, int courseId) {
		List<Student> students = new ArrayList<>();
		studentRepository.findByCourseId(courseId).forEach(students::add);
		return students;
	}

	public Teacher getTeacherByCourseId(int id) {
		return teacherRepository.findByCourseId(id);
	}
	
}
