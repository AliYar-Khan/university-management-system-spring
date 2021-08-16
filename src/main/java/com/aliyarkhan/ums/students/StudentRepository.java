package com.aliyarkhan.ums.students;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student,Integer>{
	
	public List<Student> findByCourseId(int id);
}
