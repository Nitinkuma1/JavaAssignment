package com.capgemini.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.springrest.Model.Student;
import com.capgemini.springrest.studentrepository.StudentRepository;
@Service
public class StudentService {
	public StudentRepository repository;

	public StudentService(StudentRepository repository) {
		super();
		this.repository = repository;
	}
	public List<Student> getAllStudents(){
		return repository.findAll();
	}
	public Student createStudent(Student student) {
		return repository.save(student);
	}
	public Optional<Student> getstudentbyid(Long id) {
		return repository.findById(id);
	}
	public Student updateStudent(Student student) {
		return repository.save(student);
	}
	public void deleteStudent(Long id) {
		repository.deleteById(id);
	}
}
