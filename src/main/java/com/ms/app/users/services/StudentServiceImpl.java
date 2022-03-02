package com.ms.app.users.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.app.commons.services.CommonServiceImpl;
import com.ms.app.commonsstudents.models.entity.Student;
import com.ms.app.users.models.repository.StudentRepository;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {

	@Override
	@Transactional(readOnly = true)
	public List<Student> findByNameOrLastName(String term) {
		return repository.findByNameOrLastName(term);
	}

}
