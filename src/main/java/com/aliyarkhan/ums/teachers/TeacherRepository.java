package com.aliyarkhan.ums.teachers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

	public Teacher findByCourseId(int id);
}
