package com.capgemini.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrest.Model.Student;
import com.capgemini.springrest.service.StudentService;
@RestController
@RequestMapping("/api/student")
public class StudentController {
	StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	@GetMapping
	public List<Student> getStudents(){
		return service.getAllStudents();
	}
	@PostMapping
	public Student saveStudent(@RequestBody Student student) {
		return service.createStudent(student);
	}
	@GetMapping("/{id}")
	public Optional<Student> getStudentbyId(@PathVariable Long id) {
		return service.getstudentbyid(id);
	}
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return service.updateStudent(student);
	}
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
	}
	
}
