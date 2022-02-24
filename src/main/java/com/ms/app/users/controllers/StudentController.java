package com.ms.app.users.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.app.users.models.entity.Student;
import com.ms.app.users.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok().body(studentService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudent(@PathVariable Long id) {
		Optional<Student> optional = studentService.findById(id);
		if (optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}

	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody Student student) {
		Student studentSaved = studentService.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentSaved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editStudent(@RequestBody Student studentRequest, @PathVariable Long id) {
		Optional<Student> optional = studentService.findById(id);
		if (optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Student studentEdit = optional.get();
		studentEdit.setFirstname(studentRequest.getFirstname());
		studentEdit.setLastname(studentRequest.getLastname());
		studentEdit.setEmail(studentRequest.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentEdit));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
		studentService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
