package com.ms.app.users.services;

import org.springframework.stereotype.Service;

import com.ms.app.commons.services.CommonServiceImpl;
import com.ms.app.commonsstudents.models.entity.Student;
import com.ms.app.users.models.repository.StudentRepository;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {

}
