package com.ms.app.users.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.app.commons.controllers.CommonController;
import com.ms.app.commonsstudents.models.entity.Student;
import com.ms.app.users.services.StudentService;

@RestController
public class StudentController extends CommonController<Student, StudentService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editStudent(@RequestBody Student studentRequest, @PathVariable Long id) {
		Optional<Student> optional = _service.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Student studentEdit = optional.get();
		studentEdit.setFirstname(studentRequest.getFirstname());
		studentEdit.setLastname(studentRequest.getLastname());
		studentEdit.setEmail(studentRequest.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(_service.save(studentEdit));
	}

}
