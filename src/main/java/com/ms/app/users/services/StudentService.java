package com.ms.app.users.services;

import java.util.List;

import com.ms.app.commons.services.CommonService;
import com.ms.app.commonsstudents.models.entity.Student;

public interface StudentService extends CommonService<Student> {

	public List<Student> findByNameOrLastName(String term);
}
