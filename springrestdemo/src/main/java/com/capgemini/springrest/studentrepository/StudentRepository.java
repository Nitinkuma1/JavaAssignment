package com.capgemini.springrest.studentrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.springrest.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
