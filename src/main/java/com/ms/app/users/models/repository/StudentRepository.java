package com.ms.app.users.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.app.commonsstudents.models.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("select s from Student s where s.firstname like %?1% or s.lastname like %?1%")
	public List<Student> findByNameOrLastName(String term);
}
